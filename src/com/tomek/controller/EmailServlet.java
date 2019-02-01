package com.tomek.controller;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

public class EmailServlet extends HttpServlet {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String emailAddress = request.getParameter("emailAddress");

        runMail(emailAddress);

        request.setAttribute("username", username);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);

    }

        private void runMail(String mail)  {

            setMailServerProperties();
            createEmailMessage(mail);
            sendEmail();
        }


        private void setMailServerProperties() {

            String emailPort = "587";//gmail's smtp port

            emailProperties = System.getProperties();
            emailProperties.put("mail.smtp.port", emailPort);
            emailProperties.put("mail.smtp.auth", "true");
            emailProperties.put("mail.smtp.starttls.enable", "true");

        }

        private void createEmailMessage(String mail) {

            try {
                String[] toEmails = {mail};
                String emailSubject = "Welcome!";
                String emailBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci.";
                mailSession = Session.getDefaultInstance(emailProperties, null);
                emailMessage = new MimeMessage(mailSession);

                emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

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
