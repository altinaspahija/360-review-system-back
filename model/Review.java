package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="review_id", insertable = true)
  private Integer reviewId;

  @Column(name="review_name")
  private String reviewName;

  @Column(name="created_date")
  private Date createdDate;

  @Column(name="expiration_date")
  private Date expirationDate;

  @Column(name="status")
  private String status;

  @Column(name="created_from")
  private Integer createdFrom;

  @Column(name="created_to")
  private Integer createdTo;

  @OneToOne
  @JoinColumn(name = "created_from", referencedColumnName = "user_id",insertable=false ,updatable = false)
  @JsonIgnore
  private Employee created_from;

  @ManyToOne(fetch=FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JoinColumn(name = "created_to", referencedColumnName = "user_id",insertable=false ,updatable = false)
  @JsonIgnore
  private Employee created_to;

}
