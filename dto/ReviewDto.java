package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Review;
import lombok.Data;

import java.sql.Date;

@Data
public class ReviewDto {

  private int reviewId;
  private String reviewName;
  private Date createdDate;
  private Date expirationDate;
  private String status;
  private int createdFrom;
  private int createdTo;

  public static Review getReview(ReviewDto reviewDto) {
    if (reviewDto ==null) return null;
    Review review = new Review();
    review.setReviewId(reviewDto.getReviewId());
    review.setReviewName(reviewDto.getReviewName());
    review.setCreatedDate(reviewDto.getCreatedDate());
    review.setExpirationDate(reviewDto.getExpirationDate());
    review.setStatus(reviewDto.getStatus());
    review.setCreatedFrom(reviewDto.getCreatedFrom());
    review.setCreatedTo(reviewDto.getCreatedTo());
    return review;
  }

  public static ReviewDto getReviewDto(Review review) {
    if (review ==null) return null;
    ReviewDto reviewDto = new ReviewDto();
    reviewDto.setReviewId(review.getReviewId());
    reviewDto.setReviewName(review.getReviewName());
    reviewDto.setCreatedDate(review.getCreatedDate());
    reviewDto.setExpirationDate(review.getExpirationDate());
    reviewDto.setStatus(review.getStatus());
    reviewDto.setCreatedFrom(review.getCreatedFrom());
    reviewDto.setCreatedTo(review.getCreatedTo());
    return reviewDto;
  }

}
