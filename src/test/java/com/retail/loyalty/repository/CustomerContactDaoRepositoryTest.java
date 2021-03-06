package com.retail.loyalty.repository;

import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.models.CustomerContactDetails;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerContactDaoRepositoryTest {

    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MongoOperations mongoOperations;

    @Autowired
    private CustomerContactDaoRepository customerContactDaoRepository;

    @Before
    public void setup()
    {
        customerId=123l;
        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setEveningPhoneNumber("+918095713751");
        customerContactDetails.setDayTimePhoneNumber("+918095713751");
        customerContactDetails.setMobilePhoneNumber("+918095713751");
    }

    @Test
    public void addCustomerContactTest() throws CustomerContactException {
        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        customerContactDaoRepository.addCustomerContact(customerId,customerContactDetails);
    }

    @Test
    public void addCustomerContactTestWithException() throws CustomerContactException {

        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerContactDaoRepository.addCustomerContact(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerContactException.class);

    }

    @Test
    public void updateCustomerContactTest() throws CustomerContactException {
        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);

        customerContactDaoRepository.updateCustomerContact(customerId,customerContactDetails);
    }

    @Test
    public void updateCustomerContactTestWithException() throws CustomerContactException {

        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerContactDaoRepository.updateCustomerContact(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerContactException.class);

    }
}
