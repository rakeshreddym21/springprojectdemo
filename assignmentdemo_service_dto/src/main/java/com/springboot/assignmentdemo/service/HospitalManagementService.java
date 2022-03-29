package com.springboot.assignmentdemo.service;

import com.springboot.assignmentdemo.entity.Customer;
import com.springboot.assignmentdemo.entity.Doctor;
import com.springboot.assignmentdemo.entity.Report;

import java.util.List;

public interface HospitalManagementService {
    List<Customer> findAllCustomers();

    Customer findCustomerById(int theId);

    void saveCustomer(Customer theCustomer);

    void deleteCustomerById(int theId);

    List<Report> findReports(int theId);

    List<Doctor> findAllDoctors();

    Doctor findDoctorById(int theId);

    void saveDoctor(Doctor theDoctor);

    void deleteDoctorById(int theId);

    List<Customer> findPatients(int theId);

    List<Report> findAllReports();

    Report findReportById(int theId);

    Report saveReport(Report theReport);

    void deleteReportById(int theId);
}
