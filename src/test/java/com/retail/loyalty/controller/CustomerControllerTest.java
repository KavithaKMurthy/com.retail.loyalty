package com.retail.loyalty.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.loyalty.config.EndPoints;
import com.retail.loyalty.enums.Gender;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.service.CustomerAddressService;
import com.retail.loyalty.service.CustomerContactService;
import com.retail.loyalty.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private CustomerAddressService customerAddressService;

    @MockBean
    private CustomerContactService customerContactService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    long customerId;

    @Before
    public void setup()
    {
        customerId = 1231;

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
        customer.setDateOfBirth(new Date());
        customer.setGender(Gender.FEMALE);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createCustomerTest() throws Exception{
        when(customerService.createCustomer(customer)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(post("/" + EndPoints.addCustomer)
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(customer)))
                    .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerTest() throws Exception{
        when(customerService.updateCustomer(customerId,customer)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(put("/" + EndPoints.updateCustomer,customerId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerAddressTest() throws Exception{
        when(customerAddressService.updateCustomerAddress(customerId,customerAddress)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(put("/" + EndPoints.updateCustomerAddress,customerId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customerAddress)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerContactDetailsTest() throws Exception{
        when(customerContactService.updateCustomerContact(customerId,customerContactDetails)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(put("/" + EndPoints.updateCustomerContact,customerId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customerContactDetails)))
                .andExpect(status().isOk());
    }

}
