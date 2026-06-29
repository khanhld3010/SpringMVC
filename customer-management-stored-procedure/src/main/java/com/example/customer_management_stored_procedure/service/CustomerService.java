package com.example.customer_management_stored_procedure.service;

import com.example.customer_management_stored_procedure.model.Customer;
import com.example.customer_management_stored_procedure.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveWithStoredProcedure(Customer customer) {
         customerRepository.Insert_Customer1(customer.getFirstName(), customer.getLastName());
    }
}
