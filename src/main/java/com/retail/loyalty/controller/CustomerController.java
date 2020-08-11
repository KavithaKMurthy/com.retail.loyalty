package com.retail.loyalty.controller;

import com.retail.loyalty.config.EndPoints;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.service.CustomerAddressService;
import com.retail.loyalty.service.CustomerContactService;
import com.retail.loyalty.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerAddressService customerAddressService;

    @Autowired
    private CustomerContactService customerContactService;

    @ApiOperation(nickname = "Add Customer",value="Add new customer", notes="CustomerController",tags={"StoreOperations"})
    @RequestMapping(method= RequestMethod.POST, path= EndPoints.addCustomer)
    public boolean addCustomer(@RequestBody Customer customer) throws Exception {
        boolean status = customerService.createCustomer(customer);
        return status;
    }

    @ApiOperation(nickname = "Add Customer",value="update existing customer", notes="CustomerController",tags={"StoreOperations"})
    @RequestMapping(method= RequestMethod.PUT, path=EndPoints.updateCustomer)
    public boolean updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) throws Exception {
        boolean status = customerService.updateCustomer(customerId,customer);
        return status;
    }

    @ApiOperation(nickname = "Add Customer",value="update customer address", notes="CustomerController",tags={"StoreCustomerSupport"})
    @RequestMapping(method= RequestMethod.PUT, path=EndPoints.updateCustomerAddress)
    public boolean updateCustomerAddress(@PathVariable long customerId,@RequestBody CustomerAddress customerAddress) throws Exception {
        boolean status = customerAddressService.updateCustomerAddress(customerId,customerAddress);
        return status;
    }

    @ApiOperation(nickname = "Add Customer",value="update customer contact details", notes="CustomerController",tags={"CustomerWebApplication"})
    @RequestMapping(method= RequestMethod.PUT, path=EndPoints.updateCustomerContact)
    public boolean updateCustomerContactDetails(@PathVariable long customerId,@RequestBody CustomerContactDetails customerContactDetails) throws Exception {
        boolean status = customerContactService.updateCustomerContact(customerId,customerContactDetails);
        return status;
    }
}

