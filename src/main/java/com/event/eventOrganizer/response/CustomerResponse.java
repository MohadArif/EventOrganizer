package com.event.eventOrganizer.response;

import com.event.eventOrganizer.entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerResponse {

    private String customerName;

    private String email;

    private String phoneNumber;

    private String vanue;

    private String customerAddress;

    private String vanueLocation;

    public CustomerResponse(Customer customer) {
        this.customerName=customer.getCustomerName();
        this.email=customer.getEmail();
        this.phoneNumber=customer.getPhoneNumber();
        this.vanue=customer.getVanue();
        this.customerAddress=customer.getCustomerAddress();
        this.vanueLocation=customer.getVanueLocation();
    }
}
