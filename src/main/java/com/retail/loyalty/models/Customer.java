package com.retail.loyalty.models;

import com.retail.loyalty.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "customer")
public class Customer{

    @ApiModelProperty(hidden=true)
    @Id
    private long customerId;
    @ApiModelProperty(hidden=true)
    private String firstName;
    @ApiModelProperty(hidden=true)
    private String lastName;
    @ApiModelProperty(hidden=true)
    private int age;
    @ApiModelProperty(hidden=true)
    private Date dateOfBirth;
    @ApiModelProperty(hidden=true)
    private Gender gender;
    @ApiModelProperty(hidden=true)
    private CustomerAddress customerAddress;
    @ApiModelProperty(hidden=true)
    public CustomerContactDetails getCustomerContactDetails() {
        return customerContactDetails;
    }

    public void setCustomerContactDetails(CustomerContactDetails customerContactDetails) {
        this.customerContactDetails = customerContactDetails;
    }

    private CustomerContactDetails customerContactDetails;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if(gender == null)
            this.gender = Gender.UNKNOWN;
        else
            this.gender = gender;
    }
}
