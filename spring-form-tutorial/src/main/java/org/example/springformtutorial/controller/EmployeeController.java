package org.example.springformtutorial.controller;

import org.example.springformtutorial.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/show-form")
    public String showForm(Model model) {
        // Chỉ tạo tờ đơn rỗng khi khách thực sự muốn vào form
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/add-employee")
    public String submit(@ModelAttribute("employee") Employee employee) {
        return "employee/info";
    }
}
