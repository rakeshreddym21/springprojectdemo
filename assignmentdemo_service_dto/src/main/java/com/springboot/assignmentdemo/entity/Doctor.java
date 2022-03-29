package com.springboot.assignmentdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Size(min=3,message ="It is invalid and min 3 char required")
    @Column(name="doctor_name")
    private String doctorName;
    @Size(min=3,message ="It is invalid and min 3 char required")
    @Column(name="doctor_specialization")
    private String specialization;
   @OneToMany(mappedBy = "doctor",cascade =CascadeType.ALL)
    @ToString.Exclude
    private List<Customer> customers;

    public Doctor(String doctorName, String specialization) {
        this.doctorName = doctorName;
        this.specialization = specialization;
    }
}
