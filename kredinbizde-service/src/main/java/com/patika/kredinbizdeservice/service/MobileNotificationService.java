package com.patika.kredinbizdeservice.service;

import org.springframework.stereotype.Service;

@Service
public class MobileNotificationService implements INotificationService {
    @Override
    public void sendEmailNotification(String message) {
    }

    @Override
    public void sendSmsNotification(String message) {
    }

    @Override
    public void sendMobileNotification(String message) {
        System.out.println("Mobile notification sent: " + message);
    }
}
