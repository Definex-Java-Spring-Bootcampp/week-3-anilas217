package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankRepository {
    private List<Bank> bankList = new ArrayList<>();

    public void save(Bank bank) {
        bankList.add(bank);
    }

    public List<Bank> getAll() {
        return bankList;
    }
    public Optional<Bank> findByName(String name) {
        return bankList.stream().filter(bank -> name.equals(bank.getName())).findFirst();
    }
}
