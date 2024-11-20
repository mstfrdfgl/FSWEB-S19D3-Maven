package com.workintech.s19d2.controller;

import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.service.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountServiceImpl accountService;

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable long id){
        return accountService.findById(id);
    }

    @PostMapping
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable long id, @RequestBody Account account){
        Account account1 = accountService.findById(id);
        if(account1 != null){
            return accountService.save(account);
        }
        throw new RuntimeException("This id not exist");
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable long id){
        return accountService.delete(id);
    }
}
