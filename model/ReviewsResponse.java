package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewsResponse {

    private Integer reviewId;
    private String reviewName;
    private Date createdDate;
    private Date expirationDate;
    private String name;
    private String surname;
    private Integer employeeId;
    private Long reviewInvitationId;

    public ReviewsResponse(String reviewName, Date createdDate, Integer employeeId, Long reviewInvitationId) {
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.employeeId = employeeId;
        this.reviewInvitationId = reviewInvitationId;
    }

    public ReviewsResponse(Date createdDate, Long reviewInvitationId) {
        this.createdDate = createdDate;
        this.reviewInvitationId = reviewInvitationId;
    }

    public ReviewsResponse(Integer reviewId, Long reviewInvitationId, String reviewName, Date createdDate, Date expirationDate, String name, String surname, Integer employeeId) {
        this.reviewId = reviewId;
        this.reviewInvitationId = reviewInvitationId;
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.expirationDate = expirationDate;
        this.name = name;
        this.surname = surname;
        this.employeeId = employeeId;
    }

}
