package com.patika.kredinbizdenservice.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

public class User {

    private static User instance;   //for the singleton

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email; //bir email ile bir kere kayıt olunabilir.
    private String password; //hash fonskiyonlarından biri ile hashlanecek.
    private String phoneNumber;
    private Boolean isActive;
    private List<Application> applicationList;

    public User() {

    }

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive, List<Application> applicationList) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public User(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
    public static User createUser(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive,List<Application> applicationList) {
        StringBuilder hexString = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            byte[] hash = digest.digest(password.getBytes());

            hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            //   System.out.println("SHA-512 Hash Değeri: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new User(name, surname, birthDate, email, hexString.toString(), phoneNumber, isActive, applicationList);
    }
}
