package com.springboot.assignmentdemo.Controller;

import com.springboot.assignmentdemo.converter.ReportConverter;
import com.springboot.assignmentdemo.dto.ReportDto;
import com.springboot.assignmentdemo.entity.Report;
import com.springboot.assignmentdemo.service.HospitalManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {
        @Autowired
    private HospitalManagementServiceImpl hospital;
        @Autowired
        private ReportConverter reportConverter;

    @RequestMapping("/list")
    public String listReports(Model theModel) {
        List<Report> reportList = hospital.findAllReports();
        List<ReportDto> reports=reportConverter.entityToDto(reportList);
        theModel.addAttribute("reports", reports);
        return "reports/listReports";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Report report = new Report();
        ReportDto theReport=reportConverter.entityToDto(report);

        theModel.addAttribute("report",theReport );

        return "reports/reportForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("reportId") int theId,
                                    Model theModel) {


        Report report = hospital.findReportById(theId);
        theModel.addAttribute("report", report);
        return "reports/reportForm";
    }


    @PostMapping("/save")
    public String saveReport(@ModelAttribute("report") ReportDto theReport) {

        // save the employee
        Report report=reportConverter.dtoToEntity(theReport);

        hospital.saveReport(report);

        // use a redirect to prevent duplicate submissions
        return "redirect:/reports/list";
    }
    @PostMapping("/saveNa")
    public String saveReportNa(@ModelAttribute("report") ReportDto theReport) {

        Report report=reportConverter.dtoToEntity(theReport);

        hospital.saveReport(report);

        return "redirect:/doctors/listNa";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("reportId") int theId) {


        hospital.deleteReportById(theId);

        return "redirect:/reports/list";


    }
}
