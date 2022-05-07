package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeesReviewsRatings {

    private Integer userId;
    private String name;
    private String surname;
    private Integer createdTo;
    private String reviewName;
    private Date createdDate;
    private Date completedDate;
    private Double answer;

    public static Double round(Double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public Double getAnswer() {
        return round(answer,1);
    }

    public EmployeesReviewsRatings(Integer userId, String name, String surname, Integer createdTo, String reviewName, Date createdDate, Date completedDate, Double answer) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.createdTo = createdTo;
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.answer = answer;
    }

    public EmployeesReviewsRatings(Date createdDate, Double answer) {
        this.createdDate = createdDate;
        this.answer = answer;
    }

    public EmployeesReviewsRatings() {
    }

}
