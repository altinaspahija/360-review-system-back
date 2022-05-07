package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.model.ReviewsRatings;
import com.employeessystem.backend.repository.ReviewsRatingsRepository;
import com.employeessystem.backend.service.ReviewsRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsRatingsServiceImplementation implements ReviewsRatingsService {

    @Autowired
    ReviewsRatingsRepository reviewsRatingsRepository;

    @Override
    public List<ReviewsRatings> findTopRatingReviews() {
        return reviewsRatingsRepository.findTopRatingReviews();
    }

    @Override
    public List<ReviewsRatings> findTopRatingRecentReviews() {
        return reviewsRatingsRepository.findTopRatingRecentReviews();
    }

    @Override
    public List<ReviewsRatings> findAverageReviewsRating() {
        return reviewsRatingsRepository.findAverageReviewsRating();
    }

    @Override
    public Double findAverageOverallRating() {
        return reviewsRatingsRepository.findAverageOverallRating();
    }

}
