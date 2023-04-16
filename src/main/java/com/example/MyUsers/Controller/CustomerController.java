package com.example.MyUsers.Controller;

import com.example.MyUsers.Model.Customers;
import com.example.MyUsers.POJOS.CustomerRequest;
import com.example.MyUsers.POJOS.CustomerValidateResp;
import com.example.MyUsers.POJOS.ValidateCustomerRequest;
import com.example.MyUsers.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myusers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers/add")
    public ResponseEntity<Customers> addCustomer(@RequestBody CustomerRequest customerRequest) throws Exception{
        log.info("In Customer Controller");
        log.info("In addCustomer function");
        return customerService.addCustomer(customerRequest);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Integer id) throws Exception{
        log.info("In Customer Controller");
        log.info("In deleteCustomerById function");
        return customerService.deleteCustomerById(id);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) throws Exception{
        log.info("In Customer Controller");
        log.info("In getCustomerById function");
        return customerService.getCustomerById(id);
    }

    @PostMapping("/validate/customer")
    public CustomerValidateResp validateCustomerByIdAndCnic(@RequestBody ValidateCustomerRequest customerRequest) throws Exception{
        log.info("In Customer Controller");
        log.info("In validateCustomerByIdAndCnic function");
        return customerService.validateCustomerByIdAndCnic(customerRequest);
    }
}
