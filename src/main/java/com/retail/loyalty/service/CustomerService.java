package com.retail.loyalty.service;

import com.retail.loyalty.models.Customer;

public interface CustomerService {
    boolean createCustomer(Customer customer);
    boolean updateCustomer(long customerId,Customer customer);
}
