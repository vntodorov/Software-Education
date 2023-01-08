package com.example.demo.services;

import com.example.demo.exceptions.EntityMissingException;
import com.example.demo.models.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Optional<Account> byId = this.accountRepository.findById(id);

        if (byId.isEmpty()){
            throw new EntityMissingException("Account does not exist");
        }

        BigDecimal current = byId.get().getBalance();

        if (amount.compareTo(current) > 0){
            throw new IllegalArgumentException("Your account has less than " + amount + " money");
        }

        byId.get().withdraw(amount);

        this.accountRepository.save(byId.get());
    }

    @Override
    public void depositMoney(BigDecimal amount, Long id) {
        Account account = this.accountRepository.findById(id)
                .orElseThrow(() -> new EntityMissingException("Sorry no account"));

        BigDecimal balance = account.getBalance().add(amount);
        account.deposit(balance);

        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount) {

    }
}
