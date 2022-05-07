package com.employeessystem.backend.service;

import com.employeessystem.backend.model.ReviewsRatings;

import java.util.List;

public interface ReviewsRatingsService {

    List<ReviewsRatings> findTopRatingReviews();
    List<ReviewsRatings> findTopRatingRecentReviews();
    List<ReviewsRatings> findAverageReviewsRating();
    Double findAverageOverallRating();

}
