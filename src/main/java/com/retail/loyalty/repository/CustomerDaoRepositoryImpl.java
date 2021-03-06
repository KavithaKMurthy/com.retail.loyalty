package com.retail.loyalty.repository;

import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoRepositoryImpl implements CustomerDaoRepository {
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    MongoOperations mongoOperations;

    public void createCustomer(Customer customer)  throws CustomerException {
        try {
            LOG.info("Repo Layer : Processing create customer");
            customerRepository.save(customer);
        }
        catch(Exception ex) {
            LOG.error("Repository Layer : Error while creating customer : " + ex.getMessage());
            throw new CustomerException("Repository Layer : Error while creating customer : " + ex.getMessage());
        }
    }

    public void updateCustomer(long customerId, Customer customer)  throws CustomerException{
        try {
            LOG.info("Repository Layer : Processing create customer");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");

            Customer customerRepo = mongoOperations.findAndReplace(query, customer);
        }
         catch(Exception ex) {
            LOG.error("Repository Layer : Error while updating customer : " + ex.getMessage());
            throw new CustomerException("Repository Layer : Error while updating customer : " + ex.getMessage());
        }
    }
}
