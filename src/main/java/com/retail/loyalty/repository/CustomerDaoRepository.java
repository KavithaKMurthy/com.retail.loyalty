package com.retail.loyalty.repository;

import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;

public interface CustomerDaoRepository {
    void createCustomer(Customer customer) throws CustomerException;
    void updateCustomer(long customerId,Customer customer)  throws CustomerException;
}
