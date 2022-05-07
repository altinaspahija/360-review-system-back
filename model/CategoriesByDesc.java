package com.employeessystem.backend.model;

import lombok.Data;

@Data
public class CategoriesByDesc {

    private String categoryDescription;
    private String question;
    private Integer questionId;

    public CategoriesByDesc(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public CategoriesByDesc(String categoryDescription, String question) {
        this.categoryDescription = categoryDescription;
        this.question = question;
    }

    public CategoriesByDesc(String categoryDescription, String question, Integer questionId) {
        this.categoryDescription = categoryDescription;
        this.question = question;
        this.questionId = questionId;
    }

}
