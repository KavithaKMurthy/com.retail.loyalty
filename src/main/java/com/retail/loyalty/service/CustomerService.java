package com.retail.loyalty.service;

import com.retail.loyalty.models.Customer;

public interface CustomerService {
    boolean createCustomer(Customer customer) throws Exception;
    boolean updateCustomer(long customerId,Customer customer) throws Exception;
}
