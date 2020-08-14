package com.retail.loyalty.config;

public interface  EndPoints {
    public static final String baseUrl="api/v1";
    public static final String addCustomer= baseUrl + "/customer";
    public static final String updateCustomer=baseUrl +"/customer/{customerId}";
    public static final String updateCustomerAddress=baseUrl + "/customer/address/{customerId}";
    public static final String updateCustomerContact=baseUrl + "/customer/contact/{customerId}";
}
