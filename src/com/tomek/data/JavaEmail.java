package com.tomek.data;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public static void runMail()  {

        JavaEmail javaEmail = new JavaEmail();

        javaEmail.setMailServerProperties();
        javaEmail.createEmailMessage();
        javaEmail.sendEmail();
    }


    private void setMailServerProperties() {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    private void createEmailMessage() {

        try {
            String[] toEmails = {"tomasz.development@gmail.com"};
            String emailSubject = "Pełne schronisko!";
            String emailBody = "Właśnie przyjęliśmy do naszego schroniska kolejnego zwierzaka. W schronisku zostało mniej niż 5 wolnych miejsc.";

            mailSession = Session.getDefaultInstance(emailProperties, null);
            emailMessage = new MimeMessage(mailSession);

            for (int i = 0; i < toEmails.length; i++) {
                emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
            }

            emailMessage.setSubject(emailSubject);
            emailMessage.setText(emailBody);

        } catch (MessagingException me) {
            me.printStackTrace();

        }
    }

    private void sendEmail() {
        try {
            String emailHost = "smtp.gmail.com";
            String fromUser = "savoirself";//just the id alone without @gmail.com
            String fromUserEmailPassword = "sAd8bUT#TruE.^";

            Transport transport = mailSession.getTransport("smtp");

            transport.connect(emailHost, fromUser, fromUserEmailPassword);
            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
            transport.close();
            System.out.println("Email sent successfully.");
        } catch (MessagingException me) {
            me.printStackTrace();
        }

    }
}