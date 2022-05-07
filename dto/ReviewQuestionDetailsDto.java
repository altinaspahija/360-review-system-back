package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.ReviewQuestionDetails;
import lombok.Data;

@Data
public class ReviewQuestionDetailsDto {

  private int reviewQuestionId;
  private int reviewId;
  private int questionId;

  public static ReviewQuestionDetails getReviewQuestion(ReviewQuestionDetailsDto reviewQuestionDetailsDto){
    if(reviewQuestionDetailsDto ==null) return null;
    ReviewQuestionDetails reviewQuestionDetails = new ReviewQuestionDetails();
    reviewQuestionDetails.setReviewQuestionId(reviewQuestionDetailsDto.getReviewQuestionId());
    reviewQuestionDetails.setReviewId(reviewQuestionDetailsDto.getReviewId());
    reviewQuestionDetails.setQuestionId(reviewQuestionDetailsDto.getQuestionId());
    return reviewQuestionDetails;
  }

  public static ReviewQuestionDetailsDto getReviewQuestionDto(ReviewQuestionDetails reviewQuestionDetails){
    if(reviewQuestionDetails ==null) return null;
    ReviewQuestionDetailsDto reviewQuestionDetailsDto = new ReviewQuestionDetailsDto();
    reviewQuestionDetailsDto.setReviewQuestionId(reviewQuestionDetails.getReviewQuestionId());
    reviewQuestionDetailsDto.setReviewId(reviewQuestionDetails.getReviewId());
    reviewQuestionDetailsDto.setQuestionId(reviewQuestionDetails.getQuestionId());
    return reviewQuestionDetailsDto;
  }

}
