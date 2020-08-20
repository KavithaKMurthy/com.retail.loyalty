package com.retail.loyalty.models;

import com.retail.loyalty.enums.Gender;
import io.swagger.annotations.ApiModelProperty;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import java.util.Date;

@Document(collection = "customer")
public class Customer{

    @Transient
    public static final String SEQUENCE_NAME = "customers_sequence";

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long customerId;
    private String firstName;
    
    private String lastName;
    
    private int age;
    
    private Date dateOfBirth;
    
    private Gender gender;
    
    private CustomerAddress customerAddress;
    
    public CustomerContactDetails getCustomerContactDetails() {
        return customerContactDetails;
    }

    public void setCustomerContactDetails(CustomerContactDetails customerContactDetails) {
        this.customerContactDetails = customerContactDetails;
    }

    private CustomerContactDetails customerContactDetails;

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
