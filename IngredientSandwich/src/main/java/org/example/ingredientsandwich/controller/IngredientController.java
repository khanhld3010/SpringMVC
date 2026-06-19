package org.example.ingredientsandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IngredientController {
    @GetMapping("/ingredient-form")
    public String showForm() {
        return "ingredient-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, RedirectAttributes flash) {
        if (condiments == null) {
            flash.addFlashAttribute("errorMessage", "Bạn chưa chọn gia vị nào!");
        } else {
            flash.addFlashAttribute("selectedCondiments", condiments);
            flash.addFlashAttribute("successMessage", "Đã lưu thành công!");
        }
        return "redirect:/ingredient-form";
    }
}
