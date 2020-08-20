package com.retail.loyalty.service;

import com.retail.loyalty.enums.Gender;
import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.repository.CustomerDaoRepository;
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

import java.util.Date;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {


    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    CustomerResponse customerResponse;
    @Mock
    private CustomerDaoRepository customerDaoRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void setup()
    {
        customerId=123l;
        date= new Date();
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
    public void addCustomerServiceTest() throws CustomerException {

       doNothing().when(customerDaoRepository).createCustomer(Mockito.any());
         customerResponse =customerService.createCustomer(Mockito.any());
         Assert.assertNotNull(customerResponse);
        Assert.assertEquals("success",customerResponse.getStatus());
        Assert.assertEquals("customer created successfully",customerResponse.getMessage());
    }

    @Test
    public void updateCustomerServiceTest() throws CustomerException {
        doNothing().when(customerDaoRepository).updateCustomer(Mockito.anyLong(), Mockito.any());
        customerResponse = customerService.updateCustomer(Mockito.anyLong(),Mockito.any());
        Assert.assertNotNull(customerResponse);
        Assert.assertEquals("success",customerResponse.getStatus());
        Assert.assertEquals("customer updated successfully",customerResponse.getMessage());

    }

    @Test
    public void addCustomerServiceTestWithException() throws CustomerException {

        doThrow(new CustomerException("Invalid Customer")).when(customerDaoRepository).createCustomer(Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerService.createCustomer(customer)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);

    }

    @Test
    public void updateustomerServiceTestWithException() throws CustomerException {

        doThrow(new CustomerException("Invalid Customer")).when(customerDaoRepository).updateCustomer(Mockito.anyLong(), Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerService.updateCustomer(customerId,customer)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);

    }
}