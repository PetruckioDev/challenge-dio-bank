package com.petruckio.desafio_dio_banco.transaction;

import com.petruckio.desafio_dio_banco.account.Account;
import com.petruckio.desafio_dio_banco.account.AccountRepository;
import com.petruckio.desafio_dio_banco.account.AccountType;
import com.petruckio.desafio_dio_banco.exception.AccountNotFoundException;
import com.petruckio.desafio_dio_banco.exception.InvalidTransactionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        validate(transaction);

        var newTransaction = transactionRepository.save(transaction);
        var accountSender = getAccount(transaction.sender());
        var accountRecipient = getAccount(transaction.recipient());
        accountSender.transfer(transaction.value(), accountRecipient);

        accountRepository.save(accountSender);
        accountRepository.save(accountRecipient);

        return newTransaction;
    }

    private Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found "));
    }

    private void validate(Transaction transaction) {
        accountRepository.findById(transaction.recipient())
                .map(recipient -> accountRepository.findById(transaction.sender())
                        .map(sender -> isTransactionValid(transaction, sender) ? transaction : null)
                        .orElseThrow(() -> new InvalidTransactionException("Invalid transaction %s".formatted(transaction))))
                .orElseThrow(() -> new InvalidTransactionException("Invalid transaction %s".formatted(transaction)));
    }

    private static boolean isTransactionValid(Transaction transaction, Account sender) {
        boolean checkingAccount = sender.getType() == AccountType.CHECKING.getValue() &&
                sender.getBalance().compareTo(transaction.value()) >= 0 &&
                !sender.getId().equals(transaction.recipient());

        boolean savingAccount = sender.getType() == AccountType.CHECKING.getValue() &&
                sender.getBalance().compareTo(transaction.value()) >= 0 &&
                sender.getId().equals(transaction.recipient());

        return checkingAccount || savingAccount;
    }

    public List<Transaction> list() {
        return transactionRepository.findAll();
    }
}
