package com.employeessystem.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="rating_review")
public class RatingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_review_id", insertable = true)
    private Integer ratingReviewId;

    @Column(name="rating_review_value")
    private Integer ratingReviewValue;

    @Column(name="rating_review_definition")
    private String ratingReviewDefinition;

}
