package com.sastix.email;

import com.sastix.model.Email;
import com.sun.jersey.api.client.ClientResponse;

public interface EmailService {
    void send(Email email);
}
