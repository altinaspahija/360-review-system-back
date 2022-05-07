package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.*;
import com.employeessystem.backend.model.FillReview;
import com.employeessystem.backend.model.ReviewQuestionDetails;
import com.employeessystem.backend.model.ReviewQuestionDetailsById;

import java.security.InvalidParameterException;
import java.util.List;

public interface ReviewQuestionDetailsService {

    ReviewQuestionDetails getReviewQuestionDetailById(Integer id) throws ReviewQuestionDetailsNotFoundException;
    List<ReviewQuestionDetails> getAllReviewQuestionDetails() throws ReviewQuestionDetailsNotFoundException;
    ReviewQuestionDetails postAllReviewQuestionDetails(ReviewQuestionDetails reviewQuestionDetails);
    Object postAllReviewQuestionDetailsByIds(int reviewId, int questionId);
    List<FillReview> getFillDataDetails(Integer reviewId, String categoryDescription) throws ReviewNotFoundException, CategoryNotFoundException, InvalidParameterException;
    boolean deleteById(Integer reviewQuestionDetailsId);
    ReviewQuestionDetails getReviewQuestionByIds(Integer reviewId, Integer questionId) throws ReviewNotFoundException, QuestionNotFoundException,InvalidParameterException;
    List<FillReview> getAllFillDataDetails(Integer reviewId) throws ReviewNotFoundException, InvalidParameterException ;
    List<FillReview> getAllFillDataDetailsByReviewIdAndToEmployeeId(Integer reviewId, Integer employeeId) throws ReviewNotFoundException, InvalidParameterException, UserNotFoundException;

}
