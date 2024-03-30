package com.patika.kredinbizdeservice.service;

public interface INotificationService {
    void sendEmailNotification(String message);
    void sendSmsNotification(String message);
    void sendMobileNotification(String message);
}
