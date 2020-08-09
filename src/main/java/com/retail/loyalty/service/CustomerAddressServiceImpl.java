package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerAddress;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    public boolean addCustomerAddress(long customerId,CustomerAddress customerAddress) {
        return true;
    }

    public boolean updateCustomerAddress(long customerId,CustomerAddress customerAddress) {
        return true;
    }
}
