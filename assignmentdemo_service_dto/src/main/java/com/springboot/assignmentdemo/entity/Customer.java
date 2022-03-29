package com.springboot.assignmentdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="customer_name")
    @Size(min=3,message ="Error Customer Name is Required of min 3")
    private String customerName;
    @Size(min=3,message ="It is invalid and min 3 char required")
    @Column(name="customer_address")
    private String customerAddress;
    @OneToOne(mappedBy = "customer",cascade =CascadeType.ALL)//Performs all cascade types except for removal i.e., deletion
    private  Report report;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor  doctor;

    public Customer(String customerName, String customerAddress) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public Customer(int id, String customerName, String customerAddress, Doctor doctor) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.doctor = doctor;
    }
}
