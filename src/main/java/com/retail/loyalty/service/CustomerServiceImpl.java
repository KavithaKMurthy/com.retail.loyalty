package com.retail.loyalty.service;

import com.retail.loyalty.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    public boolean createCustomer(Customer customer) {
        return true;
    }

    public boolean updateCustomer(long customerId,Customer customer) {
        return true;
    }
}
