package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(Customer customer) throws CustomerException;
    CustomerResponse updateCustomer(long customerId,Customer customer) throws CustomerException;
}
