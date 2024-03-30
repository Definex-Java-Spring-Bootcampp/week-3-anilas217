package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.*;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserService implements IUserService {

    private UserRepository userRepository = new UserRepository();

    @Autowired
    private BankService bankService;

    @Autowired
    private LogService logService;



    @Override
    public User save(User user) {
        System.out.println("userRepository: " + userRepository.hashCode());

        userRepository.save(user);

        return user;
    }

    @Override
    public List<User> getAll() {
        System.out.println("userRepository: " + userRepository.hashCode());
        return userRepository.getAll();
    }

    @Override
    public User getByEmail(String email) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        User user = null;

        //User user = foundUser.orElseThrow(RuntimeException::new);

        if (foundUser.isPresent()) {
            user = foundUser.get();
        }
        else{
            String errorMessage = "User not a found by email UserService/getByEmail";
            logService.collectAndSendLogs(errorMessage);
            return null;
        }

        return user;

    }

    @Override
    public User update(String email, User user) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        foundUser.get().setName(user.getName());

        foundUser.get().setSurname(user.getSurname());

        userRepository.delete(user);

        userRepository.save(foundUser.get());

        return foundUser.get();
    }

    @Override
    public ResponseEntity<List<Application>> applicationVIAbankName(String bankName, User user) {
        Optional<Bank> bankOptional = bankService.getBankByName(bankName);
        if (bankOptional.isPresent()){
            Bank bank = bankOptional.get();
            List<CreditCard> creditCards = bank.getCreditCards();
            List<Loan> loanLists = bank.getLoanList();
            Random random = new Random();
            int index = random.nextInt(loanLists.size()-1);
            List<Application> applicationList = new ArrayList<>();
            Loan loan = loanLists.get(index);
            LocalDateTime dateTime = LocalDateTime.now();
            Application application = new Application(loan,null,dateTime);
            applicationList.add(application);
            user.setApplicationList(applicationList);
            System.out.println(applicationList);
            return ResponseEntity.ok(user.getApplicationList());
        }
        else{
            String errorMessage = "Bank is not present in UserService/applicationVIAbankName";
            logService.collectAndSendLogs(errorMessage);
            return null;
        }

    }




}
