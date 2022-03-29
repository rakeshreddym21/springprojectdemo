package com.springboot.assignmentdemo.dao;

import com.springboot.assignmentdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where doctor_id= :doctorId",nativeQuery = true)
    List<Customer> findPatients(@Param("doctorId")int doctorId);
}
