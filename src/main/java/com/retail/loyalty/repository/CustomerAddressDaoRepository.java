package com.retail.loyalty.repository;

import com.retail.loyalty.models.CustomerAddress;

public interface CustomerAddressDaoRepository {
    boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception;
    boolean updateCustomerAddress(long customerId,CustomerAddress customerAddress) throws Exception;
}
