package com.retail.loyalty.models;

import com.retail.loyalty.SpringBootMainApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAddressTest {
    CustomerAddress customerAddress;

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
    }
    @Test
    public void customerAddressTest()
    {
        Assert.assertEquals("1/4,1st Main", customerAddress.getAddressLine1());
        Assert.assertEquals("R T Nagar",customerAddress.getAddressLine2());
        Assert.assertEquals("Bangalore",customerAddress.getAddressLine3());
        Assert.assertEquals("Karnataka",customerAddress.getState());
        Assert.assertEquals("India",customerAddress.getCountry());
        Assert.assertEquals("560032",customerAddress.getPostalCode());
    }
}
