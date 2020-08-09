package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerAddress;

public interface CustomerAddressService {
    boolean addCustomerAddress(long customerId,CustomerAddress customerAddress);
    boolean updateCustomerAddress(long customerId,CustomerAddress customerAddress);
}
