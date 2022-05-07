package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.RatingReview;
import com.employeessystem.backend.model.RatingScale;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class RatingReviewDto {

    private Integer ratingReviewId;
    private Integer ratingReviewValue;
    private String ratingReviewDefinition;

    public static RatingReview getRatingReview(RatingReviewDto ratingReviewDto){
        if (ratingReviewDto ==null) return null;
        RatingReview ratingReview = new RatingReview();
        ratingReview.setRatingReviewId(ratingReviewDto.getRatingReviewId());
        ratingReview.setRatingReviewValue(ratingReviewDto.getRatingReviewValue());
        ratingReview.setRatingReviewDefinition(ratingReviewDto.getRatingReviewDefinition());
        return ratingReview;
    }

    public static RatingReviewDto getRatingReviewDto(RatingReview ratingReview){
        if (ratingReview==null) return null;
        RatingReviewDto ratingReviewDto = new RatingReviewDto();
        ratingReviewDto.setRatingReviewId(ratingReview.getRatingReviewId());
        ratingReviewDto.setRatingReviewValue(ratingReview.getRatingReviewValue());
        ratingReviewDto.setRatingReviewDefinition(ratingReview.getRatingReviewDefinition());
        return ratingReviewDto;
    }

}
