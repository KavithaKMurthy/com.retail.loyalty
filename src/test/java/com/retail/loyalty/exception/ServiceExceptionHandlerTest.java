package com.retail.loyalty.exception;

import com.retail.loyalty.models.CustomerClubcard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceExceptionHandlerTest {

    ServiceExceptionHandler serviceExceptionHandler;

    @Before
    public void setup(){
      serviceExceptionHandler = new ServiceExceptionHandler("Test","Test");
    }

    @Test
    public void serviceExceptionHandlerTest()
    {
        Assert.assertEquals("Test",serviceExceptionHandler.getMessage());
        Assert.assertEquals("Test",serviceExceptionHandler.getStatus());
    }
}
