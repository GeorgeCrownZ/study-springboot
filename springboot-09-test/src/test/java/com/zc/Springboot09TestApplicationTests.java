package com.zc;

import com.zc.utils.SendMailUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    SendMailUtils sendMailUtils;

    @Test
    void contextLoads() {

        while (true) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject("傻狗，你妈炸了");
            mailMessage.setText("你妈炸了？臭狗想钱想疯了？黑你爹数据库还想要钱？傻狗东西你爹有备份");
            mailMessage.setTo("wang16@tutanota.com");
            mailMessage.setFrom("996264548@qq.com");

            mailSender.send(mailMessage);
        }
    }


    @Test
    void contextLoads2() throws MessagingException {

        //  一个复杂的邮件
        //MimeMessage mimeMessage = new MimeMessage();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("你好赵灿-plus");
        helper.setText("<h1 style='color: red'>正文：您好赵灿</h1>", true);

        //  附件
        helper.addAttachment("1.jps", new File("F:\\project\\springboot-09-test\\src\\main\\resources\\static\\welcome-cover.jpg"));

        helper.setTo("zc1872751113@gmail.com");
        helper.setFrom("1872751113@qq.com");

        mailSender.send(mimeMessage);
    }

    @Test
    void test() throws InterruptedException {
        int[] num = {1,2,3,4,6,23,9,11};
        for (int i : num) {
            Thread.sleep(i);
        }
    }

}
