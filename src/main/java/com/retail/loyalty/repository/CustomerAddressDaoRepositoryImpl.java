package com.retail.loyalty.repository;

import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAddressDaoRepositoryImpl implements CustomerAddressDaoRepository{
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    MongoOperations mongoOperations;

    public boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception {

        try {
            LOG.info("Repo Layer : Processing add customer address");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");
            Update update = new Update();
            update.set("customerAddress.addressLine1",customerAddress.getAddressLine1());
            update.set("customerAddress.addressLine2",customerAddress.getAddressLine2());
            update.set("customerAddress.addressLine3",customerAddress.getAddressLine3());
            update.set("customerAddress.state",customerAddress.getState());
            update.set("customerAddress.country",customerAddress.getCountry());
            update.set("customerAddress.postalCode",customerAddress.getPostalCode());
            mongoOperations.findAndModify(query, update, Customer.class);
        }
        catch(Exception ex) {
            LOG.error("Repo Layer : Error while adding customer address : " + ex.getMessage());
            throw new Exception(""+ex);
        }
        return true;
    }

    public boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception {
        try {
            LOG.info("Repo Layer : Processing update customer address");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");
            Update update = new Update();
            update.set("customerAddress.addressLine1",customerAddress.getAddressLine1());
            update.set("customerAddress.addressLine2",customerAddress.getAddressLine2());
            update.set("customerAddress.addressLine3",customerAddress.getAddressLine3());
            update.set("customerAddress.state",customerAddress.getState());
            update.set("customerAddress.country",customerAddress.getCountry());
            update.set("customerAddress.postalCode",customerAddress.getPostalCode());
            mongoOperations.findAndModify(query, update, Customer.class);
        }
        catch(Exception ex) {
            LOG.error("Repo Layer : Error while updating customer address : " + ex.getMessage());
            throw new Exception(""+ex);
        }
        return true;
    }
}
