package com.springboot.assignmentdemo.service;

import com.springboot.assignmentdemo.dao.CustomerRepository;
import com.springboot.assignmentdemo.dao.DoctorRepository;
import com.springboot.assignmentdemo.dao.ReportRepository;
import com.springboot.assignmentdemo.entity.Customer;
import com.springboot.assignmentdemo.entity.Doctor;
import com.springboot.assignmentdemo.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalManagementServiceImpl implements HospitalManagementService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer findCustomerById(int theId) {
        Optional<Customer> theCustomer = customerRepository.findById(theId);
        return theCustomer.get();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteCustomerById(int theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    public List<Report> findReports(int theId) {
        List<Report> reports=reportRepository.findReports(theId);
        return reports;
    }

    @Override
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
         return doctors;
    }

    @Override
    public Doctor findDoctorById(int theId) {
        Optional<Doctor> theDoctor = doctorRepository.findById(theId);
         return theDoctor.get();
    }

    @Override
    public void saveDoctor(Doctor theDoctor) {
      doctorRepository.save(theDoctor);
    }

    @Override
    public void deleteDoctorById(int theId) {
     doctorRepository.deleteById(theId);
    }

    @Override
    public List<Customer> findPatients(int theId) {
        List<Customer> customers=customerRepository.findPatients(theId);
        return customers;
    }

    @Override
    public List<Report> findAllReports() {
        List<Report> reports = reportRepository.findAll();
        return reports;
    }

    @Override
    public Report findReportById(int theId) {
        Optional<Report> theReport = reportRepository.findById(theId);

        return theReport.get();
    }

    @Override
    public Report saveReport(Report theReport) {
        reportRepository.save(theReport);
        return theReport;
    }

    @Override
    public void deleteReportById(int theId) {
    reportRepository.deleteById(theId);
    }

}
