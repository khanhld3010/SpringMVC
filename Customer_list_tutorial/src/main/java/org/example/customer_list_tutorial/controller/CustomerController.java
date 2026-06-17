package org.example.customer_list_tutorial.controller;

import org.example.customer_list_tutorial.model.Customer;
import org.example.customer_list_tutorial.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customers/detail")
    public ModelAndView showDetail(@RequestParam("id") int customerId){
        ModelAndView modelAndView = new ModelAndView("/customers/info");
        Customer customer = customerService.findById(customerId);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
