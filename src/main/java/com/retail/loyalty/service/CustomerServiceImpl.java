package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.repository.CustomerDaoRepository;
import com.retail.loyalty.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerDaoRepository customerDaoRepository;

    public CustomerResponse createCustomer(Customer customer) throws CustomerException {
        try {
            LOG.info("Service Layer : Processing create customer");
            customerDaoRepository.createCustomer(customer);
        }
        catch(Exception ex) {
            LOG.error("Service Layer : Error while creating customer : " + ex.getMessage());
            throw new CustomerException("Service Layer : Error while creating customer : " + ex.getMessage());
        }
        return
          new CustomerResponse(){{setStatus("success");setMessage("customer created successfully");}};
    }

    public CustomerResponse updateCustomer(long customerId, Customer customer) throws CustomerException{
        try {
            LOG.info("Service Layer : Processing update customer");
            customerDaoRepository.updateCustomer(customerId, customer);
        }
        catch(CustomerException ex) {
            LOG.error("Service Layer : Error while updating customer : " + ex.getMessage());
            throw new CustomerException("Service Layer : Error while updating customer : " + ex.getMessage());
        }
        return
                new CustomerResponse(){{setStatus("success");setMessage("customer updated successfully");}};
    }
}
