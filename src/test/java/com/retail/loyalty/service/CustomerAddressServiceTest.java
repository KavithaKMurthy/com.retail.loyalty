package com.retail.loyalty.service;

import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.repository.CustomerAddressDaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAddressServiceTest {

    CustomerAddress customerAddress;
    boolean status;
    long customerId;
    @Mock
    private CustomerAddressDaoRepository customerAddressDaoRepository;
    @InjectMocks
    private CustomerAddressServiceImpl customerAddressService;
    @Before
    public void setup(){
        customerId=123l;
        status=Boolean.TRUE;
        customerAddress = new CustomerAddress();
        customerAddress.setAddressLine1("AddressLine1");
        customerAddress.setAddressLine2("AddressLine2");
        customerAddress.setAddressLine3("AddressLine3");
        customerAddress.setPostalCode("560064");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");
    }
    @Test
    public void addCustomerAddressService() throws Exception {

        when(customerAddressDaoRepository.addCustomerAddress(Mockito.anyLong(),Mockito.any())).thenReturn(true);
        status=
                customerAddressService.addCustomerAddress(customerId,customerAddress);
        Assert.assertEquals(true,customerAddressService.addCustomerAddress(customerId,customerAddress));
    }


    @Test
    public void updateCustomerAddressService() throws Exception {
        when(customerAddressDaoRepository.updateCustomerAddress(Mockito.anyLong(),Mockito.any())).thenReturn(true);
        status=
                customerAddressService.updateCustomerAddress(customerId,customerAddress);
        Assert.assertEquals(true,customerAddressService.updateCustomerAddress(customerId,customerAddress));
    }

}