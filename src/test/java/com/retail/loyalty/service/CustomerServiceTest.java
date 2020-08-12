package com.retail.loyalty.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.retail.loyalty.enums.Gender;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.repository.CustomerContactDaoRepository;
import com.retail.loyalty.repository.CustomerDaoRepository;
import com.retail.loyalty.service.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {


    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;
    @Mock
    private CustomerDaoRepository customerDaoRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void setup()
    {
        customerId=123l;
        date= new Date();
        status = Boolean.TRUE;
        customerAddress = new CustomerAddress();
        customerAddress.setAddressLine1("AddressLine1");
        customerAddress.setAddressLine2("AddressLine2");
        customerAddress.setAddressLine3("AddressLine3");
        customerAddress.setPostalCode("560064");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");

        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setEveningPhoneNumber("+918095713751");
        customerContactDetails.setDayTimePhoneNumber("+918095713751");
        customerContactDetails.setMobilePhoneNumber("+918095713751");

        customer = new Customer();
        customer.setAge(30);
        customer.setCustomerId(123l);
        customer.setDateOfBirth(date);
        customer.setGender(Gender.MALE);
        customer.setFirstName("FirtName");
        customer.setLastName("LastName");
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);

    }
    @Test
    public void addCustomerServiceTest() throws Exception {

        when(customerDaoRepository.createCustomer(Mockito.any())).thenReturn(true);
        status=customerService.createCustomer(customer);
        Assert.assertEquals(true,customerService.createCustomer(customer));
    }

    @Test
    public void updateCustomerServiceTest() throws Exception {
        when(customerDaoRepository.updateCustomer(Mockito.anyLong(),Mockito.any())).thenReturn(true);
        status=customerService.updateCustomer(customerId,customer);
        Assert.assertEquals(true,customerService.createCustomer(customer));

    }

    @Test
    public void addCustomerServiceTestWithException() throws Exception {

        when(customerDaoRepository.createCustomer(Mockito.any())).thenThrow(new Exception("Invalid Customer"));
        Throwable thrown = catchThrowable(() ->
                customerService.createCustomer(customer)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(Exception.class);

    }

    @Test
    public void updateustomerServiceTestWithException() throws Exception {

        when(customerDaoRepository.updateCustomer(Mockito.anyLong(),Mockito.any())).thenThrow(new Exception("Invalid Customer"));
        Throwable thrown = catchThrowable(() ->
                customerService.updateCustomer(customerId,customer)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(Exception.class);

    }
}