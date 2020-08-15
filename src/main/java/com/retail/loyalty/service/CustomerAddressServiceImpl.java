package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerAddressException;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.repository.CustomerAddressDaoRepository;
import com.retail.loyalty.repository.CustomerContactDaoRepository;
import com.retail.loyalty.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private static final Logger LOG = LoggerFactory. getLogger(CustomerServiceImpl. class);

    @Autowired
    private CustomerAddressDaoRepository customerAddressDaoRepository;

    public CustomerResponse addCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException {
        try {
            LOG.info("Service Layer : Processing create customer address");
            customerAddressDaoRepository.addCustomerAddress(customerId, customerAddress);
        }
        catch(CustomerAddressException ex) {
            LOG.error("Service Layer : Error while updating customer address : " + ex.getMessage());
            throw new CustomerAddressException("Service Layer : Error while updating customer address :"+ex);
        }
        return
                new CustomerResponse(){{setStatus("success");setMessage("address created successfully");}};
    }

    public CustomerResponse updateCustomerAddress(long customerId,CustomerAddress customerAddress) throws CustomerAddressException{
        try {
            LOG.info("Service Layer : Processing update customer address");
            customerAddressDaoRepository.updateCustomerAddress(customerId, customerAddress);
        }
        catch(CustomerAddressException ex) {
            LOG.error("Service Layer : Error while updating customer address: " + ex.getMessage());
            throw new CustomerAddressException("Service Layer : Error while updating customer address:"+ex);
        }
        return
                new CustomerResponse(){{setStatus("success");setMessage("address updated successfully");}};
    }
}
