package com.patika.kredinbizdeservice.service;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements INotificationService{
    @Override
    public void sendEmailNotification(String message) {
    }

    @Override
    public void sendSmsNotification(String message) {
        // SMS gönderme işlemleri
        System.out.println("SMS notification sent: " + message);
    }

    @Override
    public void sendMobileNotification(String message) {
    }
}
