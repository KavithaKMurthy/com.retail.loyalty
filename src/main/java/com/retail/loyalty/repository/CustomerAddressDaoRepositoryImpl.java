package com.retail.loyalty.repository;

import com.retail.loyalty.models.CustomerAddress;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAddressDaoRepositoryImpl implements CustomerAddressDaoRepository{
    public boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) {
        return true;
    }

    public boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress) {
        return true;
    }
}
