package com.springboot.assignmentdemo.converter;

import com.springboot.assignmentdemo.dto.ReportDto;
import com.springboot.assignmentdemo.entity.Report;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportConverter {
    public ReportDto entityToDto(Report report)
    {
        ReportDto reportDto=new ReportDto();
        reportDto.setId(report.getId());
        reportDto.setDiagnosisReport(report.getDiagnosisReport());
        reportDto.setPrescription(report.getPrescription());
        reportDto.setCustomer(report.getCustomer());
        return reportDto;
    }
    public Report dtoToEntity(ReportDto reportDto)
    {
        Report report=new Report();
        report.setId(reportDto.getId());
        report.setDiagnosisReport(reportDto.getDiagnosisReport());
        report.setPrescription(reportDto.getPrescription());
        report.setCustomer(reportDto.getCustomer());
        return report;
    }
    public List<ReportDto> entityToDto(List<Report> reports)
    {
        return reports.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
    public List<Report> dtoToEntity(List<ReportDto> reportDtos)
    {
        return reportDtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }

}
