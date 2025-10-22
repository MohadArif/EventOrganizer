package com.event.eventOrganizer.serviceImpl;

import com.event.eventOrganizer.Service.CustomerService;
import com.event.eventOrganizer.entity.Customer;
import com.event.eventOrganizer.mailService.CustomeMailSender;
import com.event.eventOrganizer.repository.CustomerRepository;
import com.event.eventOrganizer.request.CustomerRequest;
import com.event.eventOrganizer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomeMailSender mailSender;

    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setCustomerAddress(customerRequest.getCustomerAddress());
        customer.setVanue(customerRequest.getVanue());
        customer.setVanueLocation(customerRequest.getVanueLocation());
        mailSender.sendMail(customer.getEmail(),"regarding event appoiment!!","thank you"+customer.getCustomerName()+"for connecting us.Our team member will connect you very soon..");
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomerDetails() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream().map(CustomerResponse::new).collect(Collectors.toList());
    }
}
