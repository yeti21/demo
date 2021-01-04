package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class AController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/a")
    @ResponseBody
    String a() {
        emailService.sendSimpleMail("1186939108@qq.com","第一次","第一次","1186939108@qq.com");
        return "success";
    }

    @GetMapping("/b")
    @ResponseBody
    String b() throws MessagingException {
        emailService.sendHTMLMail("1186939108@qq.com","第二次","第二次","1186939108@qq.com");
        return "success";
    }

    @GetMapping("/c")
    @ResponseBody
    String c() throws MessagingException {
        emailService.sendAttachmentsMail("1186939108@qq.com","第三次","第三次","D:\\Intellij IDEA Project\\demo\\email\\src\\main\\resources\\static\\demo.png","1186939108@qq.com");
        return "success";
    }

    @GetMapping("/d")
    @ResponseBody
    String d() throws MessagingException {
        emailService.sendResourceMail("1186939108@qq.com","第三次","第三次","D:\\Intellij IDEA Project\\demo\\email\\src\\main\\resources\\static\\demo.png","demo","1186939108@qq.com");
        return "success";
    }

}
