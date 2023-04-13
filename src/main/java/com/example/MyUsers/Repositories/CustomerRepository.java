package com.example.MyUsers.Repositories;


import com.example.MyUsers.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

    Customers findByIdAndCnic(Integer id, Long cnic);
}
