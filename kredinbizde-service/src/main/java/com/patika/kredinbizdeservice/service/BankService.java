package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService implements IBankService{


    @Autowired
    private LogService logService;
    private BankRepository bankRepository = new BankRepository();

    @Override
    public List<CreditCard> listAllCreditCard(Bank bank) {
        List<CreditCard> creditcards = bank.getCreditCards();
        for (CreditCard creditCard : creditcards) {
            List<Campaign> campaigns = creditCard.getCampaignList();
        }

        return creditcards;
    }
    @Override
    public List<Bank> getAll() {
        System.out.println("bankRepository: " + bankRepository.hashCode());
        return bankRepository.getAll();
    }

    @Override
    public Bank getByName(String name) {

        Optional<Bank> foundBank = bankRepository.findByName(name);

        Bank bank = null;

        //User user = foundBank.orElseThrow(RuntimeException::new);

        if (foundBank.isPresent()) {
            bank = foundBank.get();
            return bank;
        }
        else{
            String errorMessage = "Bank is not found BankService/getByName";
            logService.collectAndSendLogs(errorMessage);
            return null;
        }



    }



    @Override
    public void save(Bank bank) {
        System.out.println("bankRepository: " + bankRepository.hashCode());

        bankRepository.save(bank);

    }

    public Optional<Bank> getBankByName(String bankName) {
        Optional<Bank> bank = bankRepository.findByName(bankName);
        return bank;
    }
}
