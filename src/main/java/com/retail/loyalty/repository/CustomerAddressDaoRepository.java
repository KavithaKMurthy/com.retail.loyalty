package com.retail.loyalty.repository;

import com.retail.loyalty.exception.CustomerAddressException;
import com.retail.loyalty.models.CustomerAddress;

public interface CustomerAddressDaoRepository {
    void addCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException;
    void updateCustomerAddress(long customerId,CustomerAddress customerAddress) throws CustomerAddressException;
}
