package com.retail.loyalty.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerContactDetailsTest {
    CustomerContactDetails customerContactDetails;
    @Before
    public void setup(){
        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setMobilePhoneNumber("+918095062670");
        customerContactDetails.setDayTimePhoneNumber("+918095062670");
        customerContactDetails.setEveningPhoneNumber("+918095062670");
    }

    @Test
    public void customerContactDetailsTest(){
        Assert.assertEquals("+918095062670",customerContactDetails.getMobilePhoneNumber());
        Assert.assertEquals("+918095062670",customerContactDetails.getDayTimePhoneNumber());
        Assert.assertEquals("+918095062670",customerContactDetails.getEveningPhoneNumber());

    }
}
