package com.retail.loyalty.repository;

import com.retail.loyalty.models.Customer;

public interface CustomerDaoRepository {
    boolean createCustomer(Customer customer) throws Exception;
    boolean updateCustomer(long customerId,Customer customer)  throws Exception;
}
