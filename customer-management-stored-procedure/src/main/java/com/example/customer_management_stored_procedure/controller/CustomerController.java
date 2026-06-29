package com.example.customer_management_stored_procedure.controller;

import com.example.customer_management_stored_procedure.model.Customer;
import com.example.customer_management_stored_procedure.service.CustomerService;
import com.example.customer_management_stored_procedure.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.saveWithStoredProcedure(customer);
        model.addAttribute("customer", new Customer());
//        if (checkSave) {
//            model.addAttribute("message", "New customer created successfully");
//        }else {
//            model.addAttribute("message", "Error exists!");
//        }
        return "create";
    }
}
