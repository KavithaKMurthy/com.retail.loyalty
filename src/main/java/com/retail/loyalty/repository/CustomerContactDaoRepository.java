package com.retail.loyalty.repository;

import com.retail.loyalty.models.CustomerContactDetails;

public interface CustomerContactDaoRepository {
    boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws Exception;
    boolean updateCustomerContact(long customerId,CustomerContactDetails customerContactDetails) throws Exception;
}

