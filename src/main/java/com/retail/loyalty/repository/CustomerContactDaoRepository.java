package com.retail.loyalty.repository;

import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.models.CustomerContactDetails;

public interface CustomerContactDaoRepository {
    void addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;
    void updateCustomerContact(long customerId,CustomerContactDetails customerContactDetails) throws CustomerContactException;
}

