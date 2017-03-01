package com.sastix.email;

import com.sastix.model.Email;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;

public class MailGunService implements EmailService {

    @Override
    public void send(Email email) {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api","key-58c200893bf78347c3329be5338b5a3f"));
        WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox26e997b3393746fa9fadc3ad4f8be504.mailgun.org/messages");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("from", "Mailgun Sandbox <postmaster@sandbox26e997b3393746fa9fadc3ad4f8be504.mailgun.org>");
        formData.add("to", email.getTo());
        formData.add("subject", email.getSubject());
        String template = "Hi there!" +
                "\n\n" +
                "You just received an email from %s having the following subject and message:" +
                "\n\n" +
                "Subject:" +
                "\n" +
                "%s" +
                "\n" +
                "Message:" +
                "\n" +
                "%s" +
                "\n\n" +
                "Thank you";
        String text = String.format(template, email.getFrom(), email.getSubject(), email.getMessage());
        formData.add("text", text);
        ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
        int status = clientResponse.getStatus();
    }
}
