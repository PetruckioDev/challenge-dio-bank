package com.petruckio.desafio_dio_banco.account;

import com.petruckio.desafio_dio_banco.transaction.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/sender/{idSender}")
    public ResponseEntity<List<Transaction>> getTransactionSender(@PathVariable Long idSender) {
        var transactions = accountService.getTransactionSender(idSender);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/recipient/{idRecipient}")
    public ResponseEntity<List<Transaction>> getTransactionRecipient(@PathVariable Long idRecipient) {
        var transactions = accountService.getTransactionRecipient(idRecipient);
        return ResponseEntity.ok(transactions);
    }
}
