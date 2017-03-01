package com.sastix.email;

import com.sastix.model.Email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaxEmailService implements EmailService {

    @Override
    public void send(Email email) {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("info@sastix.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            message.setSubject(email.getSubject());
            message.setText(email.getMessage());
            Transport.send(message);
        } catch (MessagingException ex) {
            System.err.println("Cannot send email. " + ex);
        }
    }
}
