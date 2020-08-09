package com.retail.loyalty.models;


import com.retail.loyalty.SpringBootMainApplication;
import com.retail.loyalty.enums.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
    Customer customer;
    Customer customerGenderUnknown;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date = new Date();

    @Before
    public void setup()
    {
        customerAddress = new CustomerAddress();
        customerAddress.setAddressLine1("1/4,1st Main");
        customerAddress.setAddressLine2("R T Nagar");
        customerAddress.setAddressLine3("Bangalore");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");
        customerAddress.setPostalCode("560032");

        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setMobilePhoneNumber("+918095062670");
        customerContactDetails.setDayTimePhoneNumber("+918095062670");
        customerContactDetails.setEveningPhoneNumber("+918095062670");

        customer = new Customer();
        customer.setCustomerId(1231);
        customer.setFirstName("Test");
        customer.setLastName("Test");
        customer.setAge(33);
        customer.setDateOfBirth(date);
        customer.setGender(Gender.FEMALE);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);

        customerGenderUnknown = new Customer();
        customerGenderUnknown.setCustomerId(1231);
        customerGenderUnknown.setFirstName("Test");
        customerGenderUnknown.setLastName("Test");
        customerGenderUnknown.setAge(33);
        customerGenderUnknown.setDateOfBirth(date);
        customerGenderUnknown.setGender(null);
        customerGenderUnknown.setCustomerAddress(customerAddress);
        customerGenderUnknown.setCustomerContactDetails(customerContactDetails);
    }
    @Test
    public void customerTest()
    {
        Assert.assertEquals(1231,customer.getCustomerId());
        Assert.assertEquals("Test",customer.getFirstName());
        Assert.assertEquals("Test",customer.getLastName());
        Assert.assertEquals(33,customer.getAge());
        Assert.assertEquals(date,customer.getDateOfBirth());
        Assert.assertEquals(Gender.FEMALE,customer.getGender());
        Assert.assertNotNull(customer.getCustomerAddress());
        Assert.assertNotNull(customer.getCustomerContactDetails());
    }

    @Test
    public void customerTestForDefaultGender() {
        Assert.assertEquals(1231,customerGenderUnknown.getCustomerId());
        Assert.assertEquals("Test",customerGenderUnknown.getFirstName());
        Assert.assertEquals("Test",customerGenderUnknown.getLastName());
        Assert.assertEquals(33,customerGenderUnknown.getAge());
        Assert.assertEquals(date,customerGenderUnknown.getDateOfBirth());
        Assert.assertEquals(Gender.UNKNOWN,customerGenderUnknown.getGender());
        Assert.assertNotNull(customerGenderUnknown.getCustomerAddress());
        Assert.assertNotNull(customerGenderUnknown.getCustomerContactDetails());
    }
}
