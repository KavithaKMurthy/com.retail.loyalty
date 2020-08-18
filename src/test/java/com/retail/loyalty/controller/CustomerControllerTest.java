package com.retail.loyalty.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.loyalty.config.EndPoints;
import com.retail.loyalty.enums.Gender;
import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.response.CustomerResponse;
import com.retail.loyalty.security.JwtAuthenticationEntryPoint;
import com.retail.loyalty.security.JwtTokenUtil;
import com.retail.loyalty.security.JwtUserDetailsService;
import com.retail.loyalty.security.WebSecurityConfig;
import com.retail.loyalty.security.filter.JwtRequestFilter;
import com.retail.loyalty.security.request.JwtRequest;
import com.retail.loyalty.service.CustomerAddressService;
import com.retail.loyalty.service.CustomerContactService;
import com.retail.loyalty.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import sun.text.resources.iw.FormatData_iw_IL;

import javax.servlet.FilterChain;
import java.util.Collection;
import java.util.Date;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest({CustomerController.class, JwtAuthenticationController.class, JwtUserDetailsService.class, JwtTokenUtil.class})
public class CustomerControllerTest {

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

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @MockBean
    private AuthenticationManager authenticationManager;

    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    long customerId;
    JwtRequest userDetails ;

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

        userDetails = new JwtRequest();
        userDetails.setUsername("javainuse");
        userDetails.setPassword("password");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain).build();

    }

    @Test
    public void createCustomerTest() throws Exception {
        String accessToken = obtainAccessToken(userDetails);
        when(customerService.createCustomer(customer)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(post("/" + EndPoints.addCustomer)
                    .contentType("application/json")
                    .header("Authorization", "Bearer " + accessToken)
                    .content(objectMapper.writeValueAsString(customer)))
                    .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerTest() throws Exception{
        String accessToken = obtainAccessToken(userDetails);
        when(customerService.updateCustomer(customerId,customer)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(put("/" + EndPoints.updateCustomer,customerId)
                .contentType("application/json")
                .header("Authorization", "Bearer " + accessToken)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerAddressTest() throws Exception{
        String accessToken = obtainAccessToken(userDetails);
        when(customerAddressService.addCustomerAddress(customerId,customerAddress)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(put("/" + EndPoints.updateCustomerAddress,customerId)
                .contentType("application/json")
                .header("Authorization", "Bearer " + accessToken)
                .content(objectMapper.writeValueAsString(customerAddress)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerContactDetailsTest() throws Exception{
        when(customerContactService.addCustomerContact(customerId,customerContactDetails)).thenReturn(new CustomerResponse());

        this.mockMvc.perform(put("/" + EndPoints.updateCustomerContact,customerId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customerContactDetails)))
                .andExpect(status().isOk());
    }

    private String obtainAccessToken(JwtRequest userDetails) throws Exception {
        ResultActions result
              =
                this.mockMvc.perform(post("/authenticate")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDetails)))
                .andExpect(status().isOk());

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("token").toString();

    }
}
