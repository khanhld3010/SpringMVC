package com.example.customer_management_stored_procedure.repository;


import com.example.customer_management_stored_procedure.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Procedure
    void Insert_Customer1(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
