package org.example.currency_convert.controller;

import org.example.currency_convert.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    private ConvertService convertService;

    @Autowired
    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping("/convert")
    public String showConvertPage() {
        // Chỉ cần trả về tên view, ViewResolver sẽ tìm file: /WEB-INF/views/convert.jsp
        return "convert";
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam("usd") double usd) {
        ModelAndView modelAndView = new ModelAndView("convert");
        modelAndView.addObject("vnd", convertService.convert(usd));
        return modelAndView;
    }
}
