package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.RatingReviewNotFoundException;
import com.employeessystem.backend.model.RatingReview;
import com.employeessystem.backend.repository.RatingReviewRepository;
import com.employeessystem.backend.service.RatingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingReviewServiceImplementation implements RatingReviewService {

    @Autowired
    RatingReviewRepository ratingReviewRepository;

    @Override
    public List<RatingReview> getRatingReviewValues() throws RatingReviewNotFoundException {
        return ratingReviewRepository.findAll();
    }

}
