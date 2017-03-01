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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getAddress()));
            message.setSubject(email.getAddress());
            message.setText(email.getMessage());
            Transport.send(message);
        } catch (MessagingException ex) {
            System.err.println("Cannot send email. " + ex);
        }
    }


//    public static ClientResponse SendSimpleMessage() {
//        Client client = Client.create();
//        client.addFilter(new HTTPBasicAuthFilter("api",
//                "key-58c200893bf78347c3329be5338b5a3f"));
//        WebResource webResource =
//                client.resource("https://api.mailgun.net/v3/sandbox26e997b3393746fa9fadc3ad4f8be504.mailgun.org/messages");
//        MultivaluedMapImpl formData = new MultivaluedMapImpl();
//        formData.add("from", "Mailgun Sandbox <postmaster@sandbox26e997b3393746fa9fadc3ad4f8be504.mailgun.org>");
//        formData.add("to", "Andreas Daskalopoulos <mcaibad2@gmail.com>");
//        formData.add("subject", "Hello Andreas Daskalopoulos");
//        formData.add("text", "Congratulations Andreas Daskalopoulos, you just sent an email with Mailgun!  You are truly awesome!  You can see a record of this email in your logs: https://mailgun.com/cp/log .  You can send up to 300 emails/day from this sandbox server.  Next, you should add your own domain so you can send 10,000 emails/month for free.");
//        return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
//                post(ClientResponse.class, formData);
//    }
}
