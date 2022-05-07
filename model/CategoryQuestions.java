package com.employeessystem.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="category_questions")
public class CategoryQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id", insertable = true)
    private Integer categoryId;

    @Column(name="category_description")
    private String categoryDescription;

}
