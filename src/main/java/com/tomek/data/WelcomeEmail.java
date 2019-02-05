package com.tomek.data;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class WelcomeEmail {

    private static final String GMAIL_PORT = "587";
    private static final String GMAIL_HOST = "smtp.gmail.com";
    private static final String WELCOME_MAIL_SUBJECT = "Welcome!";
    private static final String WELCOME_EMAIL_BODY = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci.";
    private static final String SENDER_EMAIL = "savoirself";
    private static final String SENDER_PASSWORD = "testPassword";

    private static Properties emailProperties;
    private static Session mailSession;
    private static MimeMessage emailMessage;

     public static void runMail(String receiverMail)  {
        setMailServerProperties();
        createEmailMessage(receiverMail);
        sendEmail();
    }

    private static void setMailServerProperties() {
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", GMAIL_PORT);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
    }

    private static void createEmailMessage(String receiverMail) {
        try {
            mailSession = Session.getDefaultInstance(emailProperties, null);
            emailMessage = new MimeMessage(mailSession);
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverMail));
            emailMessage.setSubject(WELCOME_MAIL_SUBJECT);
            emailMessage.setText(WELCOME_EMAIL_BODY);
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    private static void sendEmail() {
        try {
        Transport transport = mailSession.getTransport("smtp");
            transport.connect(GMAIL_HOST, SENDER_EMAIL, SENDER_PASSWORD);
            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}