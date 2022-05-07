package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewsBetweenEmployees {

    private Integer userId;
    private String name;
    private String surname;
    private Integer createdTo;
    private String reviewName;
    private Date createdDate;
    private Date completedDate;
    private Integer reviewInvitationId;

    public ReviewsBetweenEmployees(Integer userId, String name, String surname, Integer createdTo, String reviewName, Date createdDate, Date completedDate) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.createdTo = createdTo;
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
    }

    public ReviewsBetweenEmployees() {
    }

}
