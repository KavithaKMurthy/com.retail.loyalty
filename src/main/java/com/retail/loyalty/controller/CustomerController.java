package com.retail.loyalty.controller;

import com.retail.loyalty.config.EndPoints;
import com.retail.loyalty.exception.CustomerAddressException;
import com.retail.loyalty.exception.CustomerContactException;
import com.retail.loyalty.exception.CustomerException;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.response.CustomerResponse;
import com.retail.loyalty.service.CustomerAddressService;
import com.retail.loyalty.service.CustomerContactService;
import com.retail.loyalty.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "", hidden = true , tags = { "Customer" })
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerAddressService customerAddressService;

    @Autowired
    private CustomerContactService customerContactService;

    @ApiOperation(nickname = "Add Customer",value="Add new customer", notes="CustomerController",tags={"Customer"},authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method= RequestMethod.POST, path= EndPoints.addCustomer)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerException {
        CustomerResponse customerResponse ;
            customerResponse = customerService.createCustomer(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(nickname = "Add Customer",value="update existing customer", notes="CustomerController",tags={"Customer"},authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method= RequestMethod.PUT, path=EndPoints.updateCustomer)
    public ResponseEntity<?>  updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) throws CustomerException {
        CustomerResponse customerResponse ;
        customerResponse =  customerService.updateCustomer(customerId,customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(nickname = "Add Customer",value="update customer address", notes="CustomerController",tags={"Customer"},authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method= RequestMethod.PUT, path=EndPoints.updateCustomerAddress)
    public ResponseEntity<?>  updateCustomerAddress(@PathVariable long customerId,@RequestBody CustomerAddress customerAddress) throws CustomerAddressException {
        CustomerResponse customerResponse ;
        customerResponse =  customerAddressService.updateCustomerAddress(customerId,customerAddress);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(nickname = "Add Customer",value="update customer contact details", notes="CustomerController",tags={"Customer"},authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method= RequestMethod.PUT, path=EndPoints.updateCustomerContact)
    public ResponseEntity<?>  updateCustomerContactDetails(@PathVariable long customerId,@RequestBody CustomerContactDetails customerContactDetails) throws CustomerContactException {
        CustomerResponse customerResponse ;
        customerResponse =  customerContactService.updateCustomerContact(customerId,customerContactDetails);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }
}

