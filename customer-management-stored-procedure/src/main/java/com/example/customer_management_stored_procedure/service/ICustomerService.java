package com.example.customer_management_stored_procedure.service;

import com.example.customer_management_stored_procedure.model.Customer;


public interface ICustomerService {
    void saveWithStoredProcedure(Customer customer);
}
