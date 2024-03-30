package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    @Qualifier("emailNotificationService")
    private INotificationService emailNotificationService;

    @Autowired
    @Qualifier("mobileNotificationService")
    private INotificationService mobileNotificationService;

    @Autowired
    @Qualifier("smsNotificationService")
    private INotificationService smsNotificationService;


    @GetMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String type, @RequestParam String message) {
        switch (type) {
            case "email":
                emailNotificationService.sendEmailNotification(message);
                break;
            case "sms":
                smsNotificationService.sendSmsNotification(message);
                break;
            case "mobile":
                mobileNotificationService.sendMobileNotification(message);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid notification type");
        }
        return ResponseEntity.ok("Notification sent successfully");
    }
}
