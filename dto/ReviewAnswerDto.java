package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.ReviewAnswer;
import lombok.Data;

@Data
public class ReviewAnswerDto {

  private int reviewAnswerId;
  private int reviewQuestionId;
  private Double answer;
  private int employeeId;

  public static ReviewAnswer getReviewAnswer(ReviewAnswerDto reviewAnswerDto){
    if(reviewAnswerDto ==null) return null;
    ReviewAnswer reviewAnswer = new ReviewAnswer();
    reviewAnswer.setReviewAnswerId(reviewAnswer.getReviewAnswerId());
    reviewAnswer.setAnswer(reviewAnswerDto.getAnswer());
    reviewAnswer.setReviewQuestionId(reviewAnswerDto.getReviewQuestionId());
    reviewAnswer.setEmployeeId(reviewAnswerDto.getEmployeeId());
    return reviewAnswer;
  }

  public static ReviewAnswerDto getReviewAnswerDto(ReviewAnswer reviewAnswer){
    if(reviewAnswer ==null) return null;
    ReviewAnswerDto reviewAnswerDto = new ReviewAnswerDto();
    reviewAnswer.setReviewAnswerId(reviewAnswer.getReviewAnswerId());
    reviewAnswerDto.setAnswer(reviewAnswer.getAnswer());
    reviewAnswerDto.setReviewQuestionId(reviewAnswer.getReviewQuestionId());
    reviewAnswerDto.setEmployeeId(reviewAnswerDto.getEmployeeId());
    return reviewAnswerDto;
  }

}
