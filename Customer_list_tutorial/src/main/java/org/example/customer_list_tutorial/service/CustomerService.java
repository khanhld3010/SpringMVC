package org.example.customer_list_tutorial.service;

import org.example.customer_list_tutorial.model.Customer;


import java.util.List;


public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);
}
