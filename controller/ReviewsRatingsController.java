package com.employeessystem.backend.controller;

import com.employeessystem.backend.model.ReviewsRatings;
import com.employeessystem.backend.service.ReviewsRatingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReviewsRatingsController {

    @Autowired
    ReviewsRatingsService reviewsRatingsService;

    //http://localhost:9090/topAverageRatingReviews GET
    @GetMapping("topAverageRatingReviews")
    public List<ReviewsRatings> findTopRatingReviews(){
        return reviewsRatingsService.findTopRatingReviews();
    }

    //http://localhost:9090/topAverageRatingRecentReviews GET
    @GetMapping("topAverageRatingRecentReviews")
    public List<ReviewsRatings> findTopRatingRecentReviews(){
        return reviewsRatingsService.findTopRatingRecentReviews();
    }
    //http://localhost:9090/averageReviewsRating GET
    @GetMapping("averageReviewsRating")
    public List<ReviewsRatings> findAverageReviewsRating(){
        return reviewsRatingsService.findAverageReviewsRating();
    }

    //http://localhost:9090/averageOverallRating GET
    @GetMapping("averageOverallRating")
    public Double countReviews(){
        return reviewsRatingsService.findAverageOverallRating();
    }

}
