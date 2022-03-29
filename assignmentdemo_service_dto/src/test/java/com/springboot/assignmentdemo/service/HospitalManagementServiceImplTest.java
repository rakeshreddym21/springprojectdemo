package com.springboot.assignmentdemo.service;

import com.springboot.assignmentdemo.dao.CustomerRepository;
import com.springboot.assignmentdemo.dao.DoctorRepository;
import com.springboot.assignmentdemo.dao.ReportRepository;
import com.springboot.assignmentdemo.entity.Customer;
import com.springboot.assignmentdemo.entity.Doctor;
import com.springboot.assignmentdemo.entity.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class HospitalManagementServiceImplTest {
    @Autowired
    private HospitalManagementServiceImpl hospital;

    @MockBean
    private ReportRepository reportRepository;
    @MockBean
    private CustomerRepository customerRepository;
    @MockBean
    private DoctorRepository doctorRepository;

    @Test
    void findAllCustomers() {
        when(customerRepository.findAll())
                .thenReturn(Stream.of(new Customer(0,"Rakesh", "Hyd",null), new Customer(1,"Jeevan", "VKB",null)).collect(Collectors.toList()));

        assertEquals(2, hospital.findAllCustomers().size());
    }

    @Test
    void findCustomerById() {
        Customer customer = new Customer(0, "Rakesh", "Reddy", null);

        when(customerRepository.findById(0)).thenReturn(Optional.of(customer));

        assertEquals(customer, hospital.findCustomerById(0));
    }

   @Test
    void saveCustomer() {
       Customer customer = new Customer(30, "Rakesh", "Reddy", null);
       hospital.saveCustomer(customer);
       verify(customerRepository).save(customer);
    }

    @Test
    void deleteCustomerById() {
        hospital.deleteCustomerById(30);
        verify(customerRepository).deleteById(30);
    }



   @Test
    void findAllDoctors() {
       when(doctorRepository.findAll())
               .thenReturn(Stream.of(new Doctor(0,"Rakesh", "Surgeon",null), new Doctor(1,"Jeevan", "Physician",null)).collect(Collectors.toList()));

       assertEquals(2, hospital.findAllDoctors().size());
    }

    @Test
    void findDoctorById() {
        Doctor doctor = new Doctor(0, "Rakesh", "Reddy", null);

        when(doctorRepository.findById(0)).thenReturn(Optional.of(doctor));

        assertEquals(doctor, hospital.findDoctorById(0));
    }

    @Test
    void saveDoctor() {
        Doctor doctor = new Doctor(0, "Rakesh", "Reddy", null);
        hospital.saveDoctor(doctor);
        verify(doctorRepository).save(doctor);
    }

    @Test
    void deleteDoctorById() {
        hospital.deleteDoctorById(30);
        verify(doctorRepository).deleteById(30);
    }

    @Test
    void findPatients() {
        hospital.findPatients(0);
        verify(customerRepository).findPatients(0);
    }
    @Test
    void findReports() {
        hospital.findReports(0);
        verify(reportRepository).findReports(0);
    }

    @Test
    void findAllReports() {
        when(reportRepository.findAll())
                .thenReturn(Stream.of(new Report("Covid", "Tablets"), new Report("Typhoids", "Tablets")).collect(Collectors.toList()));

        assertEquals(2, hospital.findAllReports().size());
    }

    @Test
    void findReportById() {
        Report report = new Report(0, "covid", "Hud", null);

        when(reportRepository.findById(0)).thenReturn(Optional.of(report));

        assertEquals(report, hospital.findReportById(0));
    }

    @Test
    void saveReport() {
        Report report = new Report(30,"Covid", "Tablets",null);
        hospital.saveReport(report);
        verify(reportRepository).save(report);
    }


    @Test
    void deleteReportById() {
        hospital.deleteReportById(30);
        verify(reportRepository).deleteById(30);
    }
}