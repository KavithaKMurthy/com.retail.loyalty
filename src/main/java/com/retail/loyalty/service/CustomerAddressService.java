package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerAddressException;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.response.CustomerResponse;

public interface CustomerAddressService {
    CustomerResponse addCustomerAddress(long customerId,CustomerAddress customerAddress) throws CustomerAddressException;
    CustomerResponse updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException;
}
