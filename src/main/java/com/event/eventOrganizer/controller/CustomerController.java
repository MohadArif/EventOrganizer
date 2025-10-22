package com.event.eventOrganizer.controller;

import com.event.eventOrganizer.Service.CustomerService;
import com.event.eventOrganizer.request.CustomerRequest;
import com.event.eventOrganizer.response.CustomerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="User-API",description = "createUser fetchUser")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.createCustomer(customerRequest);
        return new ResponseEntity<>("mail has been sended to customer!!", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCustomerDetails(){
        List<CustomerResponse> allCustomerDetails = customerService.getAllCustomerDetails();
        return new ResponseEntity<>(allCustomerDetails,HttpStatus.OK);
    }
}





