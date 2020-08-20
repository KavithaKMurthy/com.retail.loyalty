package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.repository.CustomerContactDaoRepository;
import com.retail.loyalty.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl implements CustomerContactService{
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerContactDaoRepository customerContactDaoRepository;

    public CustomerResponse addCustomerContact(long customerId,CustomerContactDetails customerContactDetails)throws CustomerContactException {
        try {
            LOG.info("Service Layer : Processing create customer contact");
            customerContactDaoRepository.addCustomerContact(customerId, customerContactDetails);
        }
        catch(CustomerContactException ex) {
            LOG.error("Service Layer : Error while creating customer contact: " + ex.getMessage());
            throw new CustomerContactException(""+ex);
        }
        return
                new CustomerResponse(){{setStatus("success");setMessage("contact created successfully");}};
    }

    public CustomerResponse updateCustomerContact(long customerId,CustomerContactDetails customerContactDetails) throws CustomerContactException{
        try {
            LOG.info("Service Layer : Processing update customer contact");
            customerContactDaoRepository.updateCustomerContact(customerId, customerContactDetails);
        }
        catch(CustomerContactException ex) {
            LOG.error("Service Layer : Error while updating customer contact : " + ex.getMessage());
            throw new CustomerContactException(""+ex);
        }
        return
                new CustomerResponse(){{setStatus("success");setMessage("contact updated successfully");}};
    }
}
