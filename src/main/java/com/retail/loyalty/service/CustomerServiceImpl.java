package com.retail.loyalty.service;

import com.retail.loyalty.models.Customer;
import com.retail.loyalty.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    MongoOperations mongoOperations;

    public boolean createCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    public boolean updateCustomer(long customerId, Customer customer) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(customerId));
        query.fields().include("_id");

        Customer customerRepo = mongoOperations.findAndReplace(query, customer);
        return true;

    }


}
