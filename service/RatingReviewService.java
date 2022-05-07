package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.RatingReviewNotFoundException;
import com.employeessystem.backend.model.RatingReview;

import java.util.List;

public interface RatingReviewService {

    List<RatingReview> getRatingReviewValues() throws RatingReviewNotFoundException;

}
