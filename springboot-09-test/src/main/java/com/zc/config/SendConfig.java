package com.zc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class SendConfig {



    public static void main(String[] args) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        //  一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();




        mailSender.send(mailMessage);
    }
}
