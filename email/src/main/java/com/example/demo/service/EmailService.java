package com.example.demo.service;


import javax.mail.MessagingException;

public interface EmailService {

    /**
     * 发送文本邮件
     * to      收件人地址
     * subject 邮件主题
     * content 邮件内容
     * String... cc 不定参数  抄送地址
     */
    void sendSimpleMail(String to, String subject, String content, String... cc);

    /**
     * 发送html邮件
     */
    void sendHTMLMail(String to, String subject, String content, String... cc) throws MessagingException;

    /**
     * 发送带附件的邮件
     * filePath 附件地址
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath, String... cc) throws MessagingException;

    /**
     * 发送正文中含有静态资源的地址
       rscPath 静态资源地址
      rscId   静态资源id
     */
    void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) throws MessagingException;
}