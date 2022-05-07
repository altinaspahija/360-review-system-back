package com.employeessystem.backend.model;

import lombok.Data;

@Data
public class FillReview {

    Integer userId;
    String name;
    String surname;
    String reviewName;
    Integer reviewQuestionId;
    Integer reviewId;
    Integer questionId;
    String question;
    Integer categoryId;
    String categoryDescription;
    Long reviewInvitationId;


    public FillReview(Long reviewInvitationId, Integer userId, String name, String surname, String reviewName, Integer reviewQuestionId, Integer reviewId, Integer questionId, String question, Integer categoryId, String categoryDescription) {
        this.reviewInvitationId = reviewInvitationId;
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.reviewName = reviewName;
        this.reviewQuestionId = reviewQuestionId;
        this.reviewId = reviewId;
        this.questionId = questionId;
        this.question = question;
        this.categoryId = categoryId;
        this.categoryDescription = categoryDescription;
    }

}
