package com.sastix.email;

import com.sastix.model.Email;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;

public class MailGunService implements EmailService {

    @Override
    public void send(Email email) {
        Configuration configuration = new Configuration()
                .domain("sastix.com")
                .apiKey("key-58c200893bf78347c3329be5338b5a3f")
                .from("Sastix", "postmaster@sastix.com");
        Mail.using(configuration)
                .to("mcaibad2@gmail.com")
                .subject("Test")
                .text("Test")
                .build()
                .send();
    }
}
