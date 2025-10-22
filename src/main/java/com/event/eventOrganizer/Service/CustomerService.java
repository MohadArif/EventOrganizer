package com.event.eventOrganizer.Service;

import com.event.eventOrganizer.request.CustomerRequest;
import com.event.eventOrganizer.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

     void createCustomer(CustomerRequest customerRequest);

     List<CustomerResponse> getAllCustomerDetails();
}
