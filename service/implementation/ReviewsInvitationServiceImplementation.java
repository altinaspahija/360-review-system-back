package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.ReviewInvitationNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.*;
import com.employeessystem.backend.repository.ReviewsInvitationRepository;
import com.employeessystem.backend.service.ReviewsInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsInvitationServiceImplementation implements ReviewsInvitationService {

    @Autowired
    ReviewsInvitationRepository reviewsInvitationRepository;

    @Override
    public Integer findOverallNumberOfRespondents() {
        return reviewsInvitationRepository.findOverallNumberOfRespondents();
    }

    @Override
    public List<ReviewsParticipation> findNumberOfRespondentsToEmployee(Integer employeeId) {
        return reviewsInvitationRepository.findNumberOfRespondentsToEmployee(employeeId);
    }

    @Override
    public List<ReviewsResponse> findNumberOfRespondsByEmployee(Integer employeeId) throws UserNotFoundException {
        return reviewsInvitationRepository.findNumberOfRespondsByEmployee(employeeId);
    }

    @Override
    public Integer findOverallNumberOfRespondentsToEmployee(Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationRepository.findOverallNumberOfRespondentsToEmployee(employeeId);
    }

    @Override
    public Integer findOverallNumberOfRespondsByEmployee(Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationRepository.findOverallNumberOfRespondsByEmployee(employeeId);
    }

    @Override
    public List<ReviewsParticipation> findReviewsNumberOfRespondentsToEmployee(Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationRepository.findReviewsNumberOfRespondentsToEmployee(employeeId);
    }

    @Override
    public List<ReviewsResponse> findReviewsNumberOfRespondsByEmployee(Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationRepository.findReviewsNumberOfRespondsByEmployee(employeeId);
    }

    @Override
    public List<ReviewInvitation> getReviewInvitations() throws ReviewInvitationNotFoundException {
        return reviewsInvitationRepository.findAll();
    }

    @Override
    public ReviewInvitation getReviewInvitationById(Long reviewInvitationId) throws ReviewInvitationNotFoundException{
        Optional<ReviewInvitation> optional = reviewsInvitationRepository.findById(reviewInvitationId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public ReviewInvitation createReviewInvitation(ReviewInvitation reviewInvitation) {
        return reviewsInvitationRepository.save(reviewInvitation);
    }

    @Override
    public boolean deleteById(Long reviewInvitationId) {
        Optional<ReviewInvitation> optional = reviewsInvitationRepository.findById(reviewInvitationId);
        if (optional.isEmpty()){
            return false;
        }
        ReviewInvitation tempReviewInvitation = optional.get();

        reviewsInvitationRepository.deleteById(tempReviewInvitation.getReviewInvitationId());
        return true;
    }

    @Override
    public List<ReviewsResponse> getReviewInvitationsByOpenStatusAndEmployee(Integer employeeId) throws UserNotFoundException, ReviewInvitationNotFoundException {
        return reviewsInvitationRepository.getReviewInvitationsByOpenStatusAndEmployee(employeeId);
    }

    @Override
    public List<ReviewsParticipation> findNumberOfRespondents() {
        return reviewsInvitationRepository.findNumberOfRespondents();
    }

    @Override
    public List<ReviewsParticipation> findNumberOfRespondentsOfRecentReview() {
        return reviewsInvitationRepository.findNumberOfRespondentsOfRecentReview();
    }

    @Override
    public List<ReviewsParticipation> findNumberOfInvitations() {
        return reviewsInvitationRepository.findNumberOfInvitations();
    }

    @Override
    public List<ReviewsParticipation> findNumberOfRecentInvitation() {
        return reviewsInvitationRepository.findNumberOfRecentInvitation();
    }

    @Override
    public Integer findOverallNumberOfInvitations() {
        return reviewsInvitationRepository.findOverallNumberOfInvitations();
    }

}
