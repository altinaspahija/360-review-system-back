package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.ReviewAnswerNotFoundException;
import com.employeessystem.backend.model.ReviewAnswer;
import com.employeessystem.backend.repository.ReviewAnswerRepository;
import com.employeessystem.backend.service.ReviewAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewAnswerServiceImplementation implements ReviewAnswerService {

    @Autowired
    ReviewAnswerRepository reviewAnswerRepository;

    @Override
    public List<ReviewAnswer> getReviewAnswers() throws ReviewAnswerNotFoundException {
        return reviewAnswerRepository.findAll();
    }

    @Override
    public List<ReviewAnswer> getAnswers() throws ReviewAnswerNotFoundException{
        return reviewAnswerRepository.getAnswers();
    }

    @Override
    public ReviewAnswer createReviewAnswer(ReviewAnswer reviewAnswer) {
        return reviewAnswerRepository.save(reviewAnswer);
    }

}
