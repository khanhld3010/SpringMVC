package org.example.emailformmanager.controller;

import org.example.emailformmanager.model.Email;
import org.example.emailformmanager.repository.EmailDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {
    private final EmailDAO emailDAO;

    public EmailController(EmailDAO emailDAO) {
        this.emailDAO = emailDAO;
    }

    @ModelAttribute("languageList")
    public String[] populateLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese", "French", "German"};
    }


    @GetMapping("/home")
    public String getEmail(Model model) {
        model.addAttribute("emails", emailDAO.getEmails());
        return "home";
    }

    @GetMapping("/email-form")
    public String getForm(Model model) {
        model.addAttribute("email", new Email());
        return "email-form";
    }

    @PostMapping("/save")
    public String saveEmail(@ModelAttribute("email") Email email) {
        emailDAO.save(email);
        return "redirect:/home";
    }
}
