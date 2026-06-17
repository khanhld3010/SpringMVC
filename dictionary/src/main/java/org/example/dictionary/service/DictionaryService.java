package org.example.dictionary.service;

import org.example.dictionary.model.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictionaryService {
    private final static List<Word> words = new ArrayList<>();

    static {
        words.add(new Word("hello", "xin chào"));
        words.add(new Word("goodbye", "tạm biệt"));
        words.add(new Word("thank you", "cảm ơn"));
        words.add(new Word("please", "xin hãy"));
    }

    public String search(String engWord){
        for (Word word : words) {
            if(word.getEngWord().equalsIgnoreCase(engWord)){
                return word.getViWord();
            }
        }
        return null;
    }
}
