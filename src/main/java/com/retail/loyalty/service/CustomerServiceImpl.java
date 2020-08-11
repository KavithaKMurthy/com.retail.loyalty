package com.retail.loyalty.service;

import com.retail.loyalty.models.Customer;
import com.retail.loyalty.repository.CustomerDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerDaoRepository customerDaoRepository;

    public boolean createCustomer(Customer customer) throws Exception{
        try {
            LOG.info("Service Layer : Processing create customer");
            customerDaoRepository.createCustomer(customer);
        }
        catch(Exception ex) {
            LOG.error("Service Layer : Error while creating customer : " + ex.getMessage());
            throw new Exception(""+ex);
        }
        return true;
    }

    public boolean updateCustomer(long customerId, Customer customer) throws Exception{
        try {
            LOG.info("Service Layer : Processing update customer");
            customerDaoRepository.updateCustomer(customerId, customer);
        }
        catch(Exception ex) {
            LOG.error("Service Layer : Error while updating customer : " + ex.getMessage());
            throw new Exception(""+ex);
        }
        return true;

    }


}
