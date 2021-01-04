package com.example.demo.service.impl;

import com.example.demo.service.EmailService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     *
     * @param to   收件人地址
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param cc    抄送地址
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content, String... cc) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        if(ArrayUtils.isNotEmpty(cc)){
            message.setCc(cc);
        }
        mailSender.send(message);
    }

    @Override
    public void sendHTMLMail(String to, String subject, String content, String... cc) throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        if(ArrayUtils.isNotEmpty(cc)){
            helper.setCc(cc);
        }
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath, String... cc) throws MessagingException {
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        if(ArrayUtils.isNotEmpty(cc)){
            helper.setCc(cc);
        }
        FileSystemResource resource=new FileSystemResource(new File(filePath));
        String filename=filePath.substring(filePath.lastIndexOf("\\")+1);
        helper.addAttachment(filename,resource);
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        if(ArrayUtils.isNotEmpty(cc)){
            helper.setCc(cc);
        }
        FileSystemResource resource=new FileSystemResource(new File(rscPath));
        helper.addInline(rscId,resource);
        mailSender.send(mimeMessage);
    }



}

