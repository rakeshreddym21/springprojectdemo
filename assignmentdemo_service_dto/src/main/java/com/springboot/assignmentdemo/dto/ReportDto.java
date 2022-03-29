package com.springboot.assignmentdemo.dto;

import com.springboot.assignmentdemo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private int id;

    private String diagnosisReport;
    private String prescription;
    @ToString.Exclude
    private Customer customer;

    public ReportDto(String diagnosisReport, String prescription) {
        this.diagnosisReport = diagnosisReport;
        this.prescription = prescription;
        this.customer=customer;
    }
}
