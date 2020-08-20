package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerAddressException;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.repository.CustomerAddressDaoRepository;
import com.retail.loyalty.response.CustomerResponse;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAddressServiceTest {

    CustomerAddress customerAddress;
    CustomerResponse customerResponse;
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
    public void addCustomerAddressService() throws CustomerAddressException {

        doNothing().when(customerAddressDaoRepository).addCustomerAddress(Mockito.anyLong(), Mockito.any());
        customerResponse = customerAddressService.addCustomerAddress(Mockito.anyLong(), Mockito.any());
        Assert.assertNotNull(customerResponse);
        Assert.assertEquals("success",customerResponse.getStatus());
        Assert.assertEquals("address created successfully",customerResponse.getMessage());
    }


    @Test
    public void updateCustomerAddressService() throws CustomerAddressException {
        doNothing().when(customerAddressDaoRepository).updateCustomerAddress(Mockito.anyLong(), Mockito.any());
        customerResponse = customerAddressService.updateCustomerAddress(Mockito.anyLong(), Mockito.any());
        Assert.assertNotNull(customerResponse);
        Assert.assertEquals("success",customerResponse.getStatus());
        Assert.assertEquals("address updated successfully",customerResponse.getMessage());
    }


    @Test
    public void updateCustomerContactServiceTestWithException() throws CustomerAddressException {

        doThrow(new CustomerAddressException("Invalid Customer")).when(customerAddressDaoRepository).updateCustomerAddress(Mockito.anyLong(),Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerAddressService.updateCustomerAddress(Mockito.anyLong(),Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerAddressException.class);
    }

    @Test
    public void addCustomerAddressServiceWithException() throws CustomerAddressException {

        doThrow(new CustomerAddressException("Invalid Customer")).when(customerAddressDaoRepository).addCustomerAddress(Mockito.anyLong(),Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerAddressService.addCustomerAddress(Mockito.anyLong(),Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerAddressException.class);

    }
}