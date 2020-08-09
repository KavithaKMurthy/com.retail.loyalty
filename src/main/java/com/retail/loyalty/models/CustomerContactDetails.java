package com.retail.loyalty.models;

public class CustomerContactDetails {
    private String mobilePhoneNumber;
    private String dayTimePhoneNumber;

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getDayTimePhoneNumber() {
        return dayTimePhoneNumber;
    }

    public void setDayTimePhoneNumber(String dayTimePhoneNumber) {
        this.dayTimePhoneNumber = dayTimePhoneNumber;
    }

    public String getEveningPhoneNumber() {
        return eveningPhoneNumber;
    }

    public void setEveningPhoneNumber(String eveningPhoneNumber) {
        this.eveningPhoneNumber = eveningPhoneNumber;
    }

    private String eveningPhoneNumber;

}
