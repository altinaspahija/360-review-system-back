package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="review_question_details")
public class ReviewQuestionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_question_id", insertable = true)
    private Integer reviewQuestionId;

    @Column(name="review_id")
    private Integer reviewId;

    @Column(name="question_id")
    private Integer questionId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id", insertable=false ,updatable = false)
    @JsonIgnore
    Review review;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "question_id", insertable=false ,updatable = false)
    @JsonIgnore
    Question question;

}