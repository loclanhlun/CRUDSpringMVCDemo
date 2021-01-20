package com.huynhbaoloc.service;

import com.huynhbaoloc.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int theId) ;
    void deleteCustomer(int theId);

}
