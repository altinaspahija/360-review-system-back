package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="review_answer")
public class ReviewAnswer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="review_answer_id", insertable = true)
  private Integer reviewAnswerId;

  @Column(name="answer", columnDefinition = "DECIMAL(10,1)")
  private Double answer;

  @Column(name="employee_id")
  private Integer employeeId ;

  @Column(name="review_question_id")
  private Integer reviewQuestionId;

  @OneToOne
  @JoinColumn(name = "employee_id", referencedColumnName = "user_id",insertable=false ,updatable = false)
  @JsonIgnore
  private Employee employee;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "review_question_id", referencedColumnName = "review_question_id",insertable=false ,updatable = false)
  @JsonIgnore
  private ReviewQuestionDetails reviewQuestionDetails;

}
