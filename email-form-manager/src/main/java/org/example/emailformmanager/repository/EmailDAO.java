package org.example.emailformmanager.repository;

import org.example.emailformmanager.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailDAO {
    private static final Map<Integer, Email> emails = new HashMap<>();

    static {
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese", "French", "German"};
        for (int i = 1; i <= 50; i++) {
            String lang = languages[i % languages.length];
            String info = "Signature / Info for Email #" + i + " in " + lang;
            emails.put(i, new Email(i, lang, info));
        }
    }

    public List<Email> getEmails() {
        return new ArrayList<>(emails.values());
    }

    public void save(Email email) {
        emails.put(email.getId(), email);
    }

    public Email getById(int id) {
        return emails.get(id);
    }


}
