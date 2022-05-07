package com.employeessystem.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Data
@Entity
@Table(name="question")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="question_id", insertable = true)
  private Integer questionId;

  @Column(name="question")
  private String question;

  @Column(name="category_id")
  private Integer categoryId;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="category_id", referencedColumnName="category_id", insertable=false ,updatable = false)
  @JsonIgnore
  private CategoryQuestions categoryQuestions;

}
