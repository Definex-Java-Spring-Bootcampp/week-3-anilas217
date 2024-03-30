package com.patika.kredinbizdeservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements INotificationService{
    @Override
    public void sendEmailNotification(String message) {
        // E-posta gönderme işlemleri
        System.out.println("Email notification sent: " + message);
    }

    @Override
    public void sendSmsNotification(String message) {
        // SMS gönderme işlemleri
    }

    @Override
    public void sendMobileNotification(String message) {
        // Mobil bildirim gönderme işlemleri
    }
}
