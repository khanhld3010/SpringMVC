package org.example.dictionary.controller;

import org.example.dictionary.model.Word;
import org.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DictionaryController {
    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dictionary")
    public ModelAndView dictionary() {
        return new ModelAndView("dictionary");
    }

    @PostMapping("/search")
    public ModelAndView searchDictionary(@RequestParam("engWord") String engWord) {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        String viWord = dictionaryService.search(engWord);
        if (viWord == null) {
            modelAndView.addObject("message", "Từ vựng '" + engWord + "' chưa có trong từ điển!");
        }else {
            modelAndView.addObject("message", "Từ vựng '" + engWord + "' có nghĩa là: " + viWord);
        }
        return modelAndView;
    }
}
