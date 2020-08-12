package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.repository.CustomerAddressDaoRepository;
import com.retail.loyalty.repository.CustomerContactDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerAddressDaoRepository customerAddressDaoRepository;

    public boolean addCustomerAddress(long customerId,CustomerAddress customerAddress) throws Exception {

        return true;
    }

    public boolean updateCustomerAddress(long customerId,CustomerAddress customerAddress) throws Exception{
        try {
            LOG.info("Service Layer : Processing update customer");
            customerAddressDaoRepository.updateCustomerAddress(customerId, customerAddress);
        }
        catch(Exception ex) {
            LOG.error("Service Layer : Error while updating customer : " + ex.getMessage());
            throw new Exception(""+ex);
        }
        return true;
    }
}
