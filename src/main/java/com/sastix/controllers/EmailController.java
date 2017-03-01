package com.sastix.controllers;

import com.sastix.email.EmailService;
import com.sastix.email.MailGunService;
import com.sastix.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/email")
    public String emailForm(Model model) {
        model.addAttribute("email", new Email());
        return "email";
    }

    @PostMapping("/email")
    public String emailSubmit(@ModelAttribute Email email) {
        EmailService emailService = new MailGunService();
        emailService.send(email);
        return "result";
    }
}
