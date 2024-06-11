package com.petruckio.desafio_dio_banco.account;

import com.petruckio.desafio_dio_banco.transaction.Transaction;
import com.petruckio.desafio_dio_banco.transaction.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final TransactionRepository transactionRepository;

    public AccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionSender(Long idSender) {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.sender().equals(idSender))
                .toList();
    }

    public List<Transaction> getTransactionRecipient(Long idReceived) {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.recipient().equals(idReceived))
                .toList();
    }
}
