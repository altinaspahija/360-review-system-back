package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.RatingReviewNotFoundException;
import com.employeessystem.backend.exception.RatingScaleNotFoundException;
import com.employeessystem.backend.model.RatingReview;
import com.employeessystem.backend.service.RatingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RatingReviewController {

    @Autowired
    RatingReviewService ratingReviewService;

    //http://localhost:9090/ratingReviewValues GET
    @GetMapping("ratingReviewValues")
    public List<RatingReview> getRatingReviewValues() throws RatingReviewNotFoundException {
        return ratingReviewService.getRatingReviewValues();
    }

}
