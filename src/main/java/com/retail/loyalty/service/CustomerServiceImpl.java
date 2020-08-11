package com.retail.loyalty.service;

import com.retail.loyalty.models.Customer;
import com.retail.loyalty.repository.CustomerRepository;
import com.sun.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean createCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    public boolean updateCustomer(long customerId,Customer customer) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(customerId));
        mongoTemplate.save(customer);
        return true;

    }


}
