package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewsParticipation {

    private String reviewName;
    private Date createdDate;
    private Long reviewInvitationId;
    private Integer employeeId;

    public ReviewsParticipation(Date createdDate, Long reviewInvitationId) {
        this.createdDate = createdDate;
        this.reviewInvitationId = reviewInvitationId;
    }

    public ReviewsParticipation(String reviewName, Date createdDate, Integer employeeId, Long reviewInvitationId) {
        this.reviewName = reviewName;
        this.createdDate = createdDate;
        this.employeeId = employeeId;
        this.reviewInvitationId = reviewInvitationId;
    }

    public ReviewsParticipation() {
    }

}
