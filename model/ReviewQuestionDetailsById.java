package com.employeessystem.backend.model;

import lombok.Data;

@Data
public class ReviewQuestionDetailsById {

    private Integer reviewId;
    private Integer questionId;

    public ReviewQuestionDetailsById(Integer reviewId, Integer questionId) {

        this.reviewId = reviewId;
        this.questionId = questionId;
    }

}
