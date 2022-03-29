package com.springboot.assignmentdemo.dao;

import com.springboot.assignmentdemo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Integer> {
    @Query(value = "select * from report where customer_id= :theId",nativeQuery = true)

    List<Report> findReports(@Param("theId")int theId);
}
