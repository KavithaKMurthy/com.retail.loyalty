package com.retail.loyalty.service;

import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.repository.CustomerContactDaoRepository;
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
public class CustomerContactServiceTest {

    CustomerContactDetails customerContactDetails;
    CustomerResponse customerResponse;
    long customerId;
    @Mock
    private CustomerContactDaoRepository customerContactDaoRepository;

    @InjectMocks
    private CustomerContactServiceImpl customerContactService;
    boolean status;
    @Before
    public void setup(){
        customerId=123l;
        status = Boolean.TRUE;
        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setEveningPhoneNumber("+918095713751");
        customerContactDetails.setDayTimePhoneNumber("+918095713751");
        customerContactDetails.setMobilePhoneNumber("+918095713751");
    }
    @Test
    public void addCustomerContactService() throws CustomerContactException {
        doNothing().when(customerContactDaoRepository).addCustomerContact(Mockito.anyLong(), Mockito.any());
        customerResponse = customerContactService.addCustomerContact(Mockito.anyLong(), Mockito.any());
        Assert.assertNotNull(customerResponse);
        Assert.assertEquals("success",customerResponse.getStatus());
        Assert.assertEquals("contact created successfully",customerResponse.getMessage());
    }

    @Test
    public void updateCustomerContactService() throws CustomerContactException {
        doNothing().when(customerContactDaoRepository).addCustomerContact(Mockito.anyLong(), Mockito.any());
        customerResponse = customerContactService.updateCustomerContact(customerId,customerContactDetails);
        Assert.assertNotNull(customerResponse);
        Assert.assertEquals("success",customerResponse.getStatus());
        Assert.assertEquals("contact updated successfully",customerResponse.getMessage());
    }

    @Test
    public void updateCustomerContactServiceTestWithException() throws CustomerContactException {

        doThrow(new CustomerContactException("Invalid Customer")).when(customerContactDaoRepository).updateCustomerContact(Mockito.anyLong(),Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerContactService.updateCustomerContact(Mockito.anyLong(),Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerContactException.class);


    }

    @Test
    public void addCustomerContactServiceTestWithException() throws CustomerContactException {
        doThrow(new CustomerContactException("Invalid Customer")).when(customerContactDaoRepository).addCustomerContact(Mockito.anyLong(),Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerContactService.addCustomerContact(Mockito.anyLong(),Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerContactException.class);
    }

}