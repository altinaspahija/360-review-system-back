package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.model.ReviewInvitation;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Date;

@Data
public class ReviewInvitationDto {

    private Long reviewInvitationId;
    private String status;
    private String subject;
    private String message;
    private Date completedDate;
    private Integer reviewId;
    private Integer employeeId;

    public static ReviewInvitation getReviewInvitation(ReviewInvitationDto reviewInvitationDto) {
        if (reviewInvitationDto ==null) return null;
        ReviewInvitation reviewInvitation = new ReviewInvitation();
        reviewInvitation.setReviewId(reviewInvitationDto.getReviewId());
        reviewInvitation.setEmployeeId(reviewInvitationDto.getEmployeeId());
        reviewInvitation.setCompletedDate(reviewInvitationDto.getCompletedDate());
        reviewInvitation.setStatus(reviewInvitationDto.getStatus());
        reviewInvitation.setReviewInvitationId(reviewInvitationDto.getReviewInvitationId());
        reviewInvitation.setMessage(reviewInvitationDto.getMessage());
        reviewInvitation.setSubject(reviewInvitationDto.getSubject());
        return reviewInvitation;
    }

    public static ReviewInvitationDto getReviewInvitationDto(ReviewInvitation reviewInvitation) {
        if (reviewInvitation ==null) return null;
        ReviewInvitationDto reviewInvitationDto = new ReviewInvitationDto();
        reviewInvitationDto.setReviewInvitationId(reviewInvitation.getReviewInvitationId());
        reviewInvitationDto.setReviewId(reviewInvitationDto.getReviewId());
        reviewInvitation.setStatus(reviewInvitationDto.getStatus());
        reviewInvitation.setCompletedDate(reviewInvitationDto.getCompletedDate());
        reviewInvitation.setEmployeeId(reviewInvitationDto.getEmployeeId());
        reviewInvitationDto.setMessage(reviewInvitationDto.getMessage());
        reviewInvitationDto.setSubject(reviewInvitationDto.getSubject());
        return reviewInvitationDto;
    }

}
