package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.ReviewAnswerNotFoundException;
import com.employeessystem.backend.model.ReviewAnswer;

import java.util.List;

public interface ReviewAnswerService {

    List<ReviewAnswer> getReviewAnswers() throws ReviewAnswerNotFoundException;
    List<ReviewAnswer> getAnswers() throws ReviewAnswerNotFoundException;
    ReviewAnswer createReviewAnswer(ReviewAnswer reviewAnswer);

}
