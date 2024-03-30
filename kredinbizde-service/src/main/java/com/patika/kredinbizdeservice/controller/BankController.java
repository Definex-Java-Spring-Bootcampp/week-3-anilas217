package com.patika.kredinbizdeservice.controller;


import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/banks")
public class BankController {

    //Injection service
    @Autowired
    private IBankService bankService;


    //Injection controller
    @Autowired
    public BankController(IBankService bankService){
        this.bankService = bankService;
    }

/*    @GetMapping(value = "/{name}")
    public  listAllCreditCard(Bank bank) {
       System.out.println(bank.getName());
        return bankService.listAllCreditCard(bank);
    }   */


    @GetMapping(value = "/{name}")
    public Bank GarantibankClient(@PathVariable String bankName) {
       return bankService.getByName(bankName);
    }
    @PostMapping(value = "/save")
    public void GarantibankClient(@RequestBody Bank bank) {
         System.out.println(bank.getLoanList());
         bankService.save(bank);
    }
}
