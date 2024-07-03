package com.example.pjbarber.service;


import com.example.pjbarber.entity.Customer;
import com.example.pjbarber.pojo.CustomerPojo;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerPojo customerPojo);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long customer_id);
    Customer updateCustomerById(Long customer_id, CustomerPojo customerPojo);
    void deleteCustomerById(Long customer_id);



}
