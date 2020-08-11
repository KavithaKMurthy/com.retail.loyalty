package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerContactDetails;

public interface CustomerContactService {
    boolean addCustomerContact(long customerId,CustomerContactDetails customerContactDetails) throws Exception;
    boolean updateCustomerContact(long customerId,CustomerContactDetails customerContactDetails) throws Exception;
}
