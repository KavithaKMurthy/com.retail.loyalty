package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.repository.CustomerContactDaoRepository;
import com.retail.loyalty.repository.CustomerDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl implements CustomerContactService{
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerContactDaoRepository customerContactDaoRepository;

    public boolean addCustomerContact(long customerId,CustomerContactDetails customerContactDetails)throws Exception {
        return true;
    }

    public boolean updateCustomerContact(long customerId,CustomerContactDetails customerContactDetails) throws Exception{
        try {
            LOG.info("Service Layer : Processing update customer");
            customerContactDaoRepository.updateCustomerContact(customerId, customerContactDetails);
        }
        catch(Exception ex) {
            LOG.error("Service Layer : Error while updating customer : " + ex.getMessage());
            throw new Exception(""+ex);
        }
        return true;
    }
}
