package com.springboot.assignmentdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="diagnosis_report")
    @Size(min=3,message ="Error Diagnosis Report is Required of min 3")
    private String diagnosisReport;
    @Column(name="prescription")
    @Size(min=3,message ="Error Prescription  is Required of min 3")
    private String prescription;
    @OneToOne
    @JoinColumn(name="customer_id")
    @ToString.Exclude
    private Customer customer;

    public Report(String diagnosisReport, String prescription) {
        this.diagnosisReport = diagnosisReport;
        this.prescription = prescription;
    }
}
