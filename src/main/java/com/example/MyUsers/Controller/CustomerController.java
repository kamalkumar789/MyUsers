package com.example.MyUsers.Controller;

import com.example.MyUsers.Model.Customers;
import com.example.MyUsers.POJOS.CustomerRequest;
import com.example.MyUsers.POJOS.ValidateCustomerRequest;
import com.example.MyUsers.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers/add")
    public ResponseEntity<Customers> addCustomer(@RequestBody CustomerRequest customerRequest) throws Exception{
        return customerService.addCustomer(customerRequest);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Integer id) throws Exception{
        return customerService.deleteCustomerById(id);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) throws Exception{
        return customerService.getCustomerById(id);
    }

    @GetMapping("/validate/customer")
    public ResponseEntity validateCustomerByIdAndCnic(@RequestBody ValidateCustomerRequest customerRequest) throws Exception{
        return customerService.validateCustomerByIdAndCnic(customerRequest);
    }
}
