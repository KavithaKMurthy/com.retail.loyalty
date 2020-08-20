package com.retail.loyalty.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerClubcardTest {
    CustomerClubcard customerClubcard;

    @Before
    public void setup(){
        customerClubcard = new CustomerClubcard();
        customerClubcard.setClubcardId(6340012);
        customerClubcard.setClubcardStatus(0);
        customerClubcard.setClubcardType(1);
        customerClubcard.setPrimaryClubcardId(6340012);
    }

    @Test
    public void customerClubcardTest()
    {
        Assert.assertEquals(6340012,customerClubcard.getClubcardId());
        Assert.assertEquals(0,customerClubcard.getClubcardStatus());
        Assert.assertEquals(1,customerClubcard.getClubcardType());
        Assert.assertEquals(6340012,customerClubcard.getPrimaryClubcardId());
    }
}
