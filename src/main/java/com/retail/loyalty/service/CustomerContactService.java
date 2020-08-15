package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.response.CustomerResponse;

public interface CustomerContactService {
    CustomerResponse addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;
    CustomerResponse updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;
}
