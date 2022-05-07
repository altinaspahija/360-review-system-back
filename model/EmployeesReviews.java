package com.employeessystem.backend.model;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import java.util.Date;

@Data
public class EmployeesReviews {

    private Integer userId;
    private Integer reviewId;
    private String reviewName;
    private Date createdDate;
    private Date expirationDate;
    private String status;
    private String name;
    private String surname;

    public EmployeesReviews(Integer userId, String reviewName, Date createdDate, Date expirationDate, String status, String name, String surname) {
        this.userId = userId;
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.expirationDate = expirationDate;
        this.status = status;
        this.name = name;
        this.surname = surname;
    }

    public EmployeesReviews(Integer userId, Integer reviewId, String reviewName, Date createdDate, Date expirationDate, String status, String name, String surname) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.expirationDate = expirationDate;
        this.status = status;
        this.name = name;
        this.surname = surname;
    }

    public EmployeesReviews() {
    }

}
