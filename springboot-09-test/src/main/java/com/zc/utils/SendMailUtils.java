package com.zc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class SendMailUtils {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     *
     * @param subject：邮件标题
     * @param text：邮件正文
     * @param setTo：发送至邮箱
     */
    public void EasyMail(String subject, String text, String setTo) {

        //  一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setTo(setTo);
        mailMessage.setFrom("996264548@qq.com");

        mailSender.send(mailMessage);
    }

    /**
     *
     * @param html：邮件内容是否以html标签格式输出
     * @param subject：邮件标题
     * @param text：邮件正文
     * @param setTo：邮件发送至邮箱
     * @throws MessagingException
     */
    public void SendMail(boolean html, String subject, String text, String setTo) throws MessagingException {

        //  一个复杂的邮件
        //MimeMessage mimeMessage = new MimeMessage();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject(subject);
        helper.setText(text, html);
        helper.setTo(setTo);
        helper.setFrom("1872751113@qq.com");

        mailSender.send(mimeMessage);
    }

    /**
     *
     * @param html：邮件内容是否以html标签格式输出
     * @param subject：邮件标题
     * @param text：邮件正文
     * @param setTo：邮件发送至邮箱
     * @param filename：附件名称
     * @param filepath：附件路径
     * @throws MessagingException
     */
    public void SendMailByFile(boolean html, String subject, String text, String setTo, String filename, String filepath) throws MessagingException {

        //  一个复杂的邮件
        //MimeMessage mimeMessage = new MimeMessage();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject(subject);
        helper.setText(text, html);

        //  附件
        helper.addAttachment(filename, new File(filepath));

        helper.setTo(setTo);
        helper.setFrom("1872751113@qq.com");

        mailSender.send(mimeMessage);
    }
}
