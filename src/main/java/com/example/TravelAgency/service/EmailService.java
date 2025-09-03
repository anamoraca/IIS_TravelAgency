package com.example.TravelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendActivationEmail(String email, String activationLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("isa595976@gmail.com");
        message.setTo(email);
        message.setSubject("Account Activation - OnlyBuns");
        message.setText("Please click the following link to activate your account:\n" + activationLink);

        mailSender.send(message);
    }
}
