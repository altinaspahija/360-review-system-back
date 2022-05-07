package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="review_invitation")
public class ReviewInvitation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="review_invitation_id", insertable = true)
  private Long reviewInvitationId;

  @Column(name="status")
  private String status;

  @Column(name="subject")
  private String subject;

  @Column(name="message")
  private String message;

  @Column(name="completed_date")
  private Date completedDate;

  @Column(name="review_id")
  private Integer reviewId;

  @Column(name="employee_id")
  private Integer employeeId;

  @ManyToOne
  @JoinColumn(name = "review_id", referencedColumnName = "review_id",insertable=false ,updatable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Review review;

  @ManyToOne
  @JoinColumn(name = "employee_Id", referencedColumnName = "user_id",insertable=false ,updatable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Employee employee;

}
