package com.example.MyUsers.Service;

import com.example.MyUsers.Model.Customers;
import com.example.MyUsers.POJOS.CustomerRequest;
import com.example.MyUsers.POJOS.ValidateCustomerRequest;
import com.example.MyUsers.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;
    public ResponseEntity<Customers> addCustomer(CustomerRequest customerRequest) throws Exception{
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(customerRequest.getDob());
        Customers customers = new Customers();
        customers.setDob(date);
        customers.setName(customerRequest.getName());
        customers.setEmail(customerRequest.getEmail());
        customers.setCnic(customerRequest.getCnic());
        Customers customer = customerRepository.save(customers);
        return new ResponseEntity<Customers>(customer,HttpStatus.CREATED);
    }

    public ResponseEntity<Customers> getCustomerById(Integer id) throws Exception{
        Customers customer = customerRepository.findById(id).orElse(null);
        if(customer == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Customers>(customer, HttpStatus.OK);
    }

    public ResponseEntity deleteCustomerById(Integer id) throws Exception{

        if(customerRepository.findById(id).orElse(null) != null){
            customerRepository.deleteById(id);
        }else {
            return new ResponseEntity("Customer doesn't exists on this id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successfully deleted successfully on this id: "+id,HttpStatus.OK);
    }
    public ResponseEntity validateCustomerByIdAndCnic(ValidateCustomerRequest customerRequest) throws Exception{

        Customers customer = customerRepository.findByIdAndCnic(customerRequest.getId(), customerRequest.getCnic());
        if(customer != null) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
