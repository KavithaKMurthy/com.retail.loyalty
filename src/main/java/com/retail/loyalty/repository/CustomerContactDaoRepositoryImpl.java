package com.retail.loyalty.repository;

import com.mongodb.client.model.Updates;
import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerContactDaoRepositoryImpl implements CustomerContactDaoRepository{
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    MongoOperations mongoOperations;

    public void addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException {
        try {
            LOG.info("Repo Layer : Processing create customer");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");
            Update update = new Update();
            update.set("customerContactDetails.mobilePhoneNumber",customerContactDetails.getMobilePhoneNumber());
            update.set("customerContactDetails.dayTimePhoneNumber",customerContactDetails.getDayTimePhoneNumber());
            update.set("customerContactDetails.eveningPhoneNumber",customerContactDetails.getEveningPhoneNumber());
            mongoOperations.findAndModify(query, update, Customer.class);
        }
        catch(Exception ex) {
            LOG.error("Repo Layer : Error while creating customer : " + ex.getMessage());
            throw new CustomerContactException("Repo Layer : Error while creating customer :"+ex);
        }
    }

    public void updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException{
        try {
            LOG.info("Repo Layer : Processing create customer");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");
            Update update = new Update();
            update.set("customerContactDetails.mobilePhoneNumber",customerContactDetails.getMobilePhoneNumber());
            update.set("customerContactDetails.dayTimePhoneNumber",customerContactDetails.getDayTimePhoneNumber());
            update.set("customerContactDetails.eveningPhoneNumber",customerContactDetails.getEveningPhoneNumber());
            mongoOperations.findAndModify(query, update, Customer.class);
        }
        catch(Exception ex) {
            LOG.error("Repo Layer : Error while creating customer : " + ex.getMessage());
            throw new CustomerContactException("Repo Layer : Error while creating customer :"+ex);
        }
    }
}
