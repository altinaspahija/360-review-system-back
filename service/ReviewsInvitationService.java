package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.ReviewInvitationNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.model.ReviewInvitation;
import com.employeessystem.backend.model.ReviewsParticipation;
import com.employeessystem.backend.model.ReviewsResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewsInvitationService {

    List<ReviewsParticipation> findNumberOfRespondents();
    List<ReviewsParticipation> findNumberOfRespondentsOfRecentReview();
    List<ReviewsParticipation> findNumberOfInvitations();
    List<ReviewsParticipation> findNumberOfRecentInvitation();
    Integer findOverallNumberOfInvitations();
    Integer findOverallNumberOfRespondents();
    List<ReviewsParticipation> findNumberOfRespondentsToEmployee(Integer employeeId) throws UserNotFoundException;
    List<ReviewsResponse> findNumberOfRespondsByEmployee(Integer employeeId) throws UserNotFoundException;
    Integer findOverallNumberOfRespondentsToEmployee(Integer employeeId) throws UserNotFoundException;
    Integer findOverallNumberOfRespondsByEmployee(Integer employeeId) throws UserNotFoundException;
    List<ReviewsParticipation> findReviewsNumberOfRespondentsToEmployee(Integer employeeId) throws UserNotFoundException;
    List<ReviewsResponse> findReviewsNumberOfRespondsByEmployee(Integer employeeId) throws UserNotFoundException;
    List<ReviewInvitation> getReviewInvitations() throws ReviewInvitationNotFoundException;
    ReviewInvitation getReviewInvitationById(Long reviewInvitationId) throws ReviewInvitationNotFoundException;
    ReviewInvitation createReviewInvitation(ReviewInvitation reviewInvitation);
    boolean deleteById(Long reviewInvitationId);
    List<ReviewsResponse> getReviewInvitationsByOpenStatusAndEmployee(Integer employeeId) throws UserNotFoundException, ReviewInvitationNotFoundException;

}
