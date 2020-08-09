package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerContactDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl implements CustomerContactService{
    public boolean addCustomerContact(long customerId,CustomerContactDetails customerContactDetails) {
        return true;
    }

    public boolean updateCustomerContact(long customerId,CustomerContactDetails customerContactDetails) {
        return true;
    }
}
