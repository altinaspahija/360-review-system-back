package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.*;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.FillReview;
import com.employeessystem.backend.model.ReviewQuestionDetails;
import com.employeessystem.backend.model.ReviewQuestionDetailsById;
import com.employeessystem.backend.repository.ReviewQuestionDetailsRepository;
import com.employeessystem.backend.service.ReviewQuestionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewQuestionDetailsServiceImp implements ReviewQuestionDetailsService {

    @Autowired
    ReviewQuestionDetailsRepository reviewQuestionDetailsRepository;

    @Override
    public ReviewQuestionDetails getReviewQuestionDetailById(Integer id) throws ReviewQuestionDetailsNotFoundException {
        Optional<ReviewQuestionDetails> optional = reviewQuestionDetailsRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<ReviewQuestionDetails> getAllReviewQuestionDetails() throws ReviewQuestionDetailsNotFoundException{
        return reviewQuestionDetailsRepository.findAll();
    }

    @Override
    public ReviewQuestionDetails postAllReviewQuestionDetails(ReviewQuestionDetails reviewQuestionDetails) {
        return reviewQuestionDetailsRepository.save(reviewQuestionDetails);
    }

    @Override
    public Object postAllReviewQuestionDetailsByIds(int reviewId, int questionId) {
        return reviewQuestionDetailsRepository.postAllReviewQuestionDetailsByIds(reviewId,questionId);
    }

    @Override
    public List<FillReview> getFillDataDetails(Integer reviewId, String categoryDescription) throws ReviewNotFoundException, CategoryNotFoundException, InvalidParameterException {
        return reviewQuestionDetailsRepository.getFillDataDetails(reviewId, categoryDescription);
    }

    @Override
    public boolean deleteById(Integer reviewQuestionDetailsId) {
        Optional<ReviewQuestionDetails> optional = reviewQuestionDetailsRepository.findById(reviewQuestionDetailsId);
        if (optional.isEmpty()){
            return false;
        }
        ReviewQuestionDetails tempReviewQuestionDetails = optional.get();

        reviewQuestionDetailsRepository.deleteById(tempReviewQuestionDetails.getReviewQuestionId());
        return true;
    }

    @Override
    public ReviewQuestionDetails getReviewQuestionByIds(Integer reviewId, Integer questionId) throws ReviewNotFoundException, QuestionNotFoundException,InvalidParameterException{
        return reviewQuestionDetailsRepository.getReviewQuestionByIds(reviewId,questionId);
    }

    @Override
    public List<FillReview> getAllFillDataDetails(Integer reviewId) throws ReviewNotFoundException, InvalidParameterException {
        return reviewQuestionDetailsRepository.getAllFillDataDetails(reviewId);
    }

    @Override
    public List<FillReview> getAllFillDataDetailsByReviewIdAndToEmployeeId(Integer reviewId, Integer employeeId) throws ReviewNotFoundException, InvalidParameterException, UserNotFoundException {
        return reviewQuestionDetailsRepository.getAllFillDataDetailsByReviewIdAndToEmployeeId(reviewId, employeeId);
    }

}
