package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="position")
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="position_id", insertable = true)
  private Integer positionId;

  @Column(name="position_title")
  private String positionTitle;

  @Column(name="department_id")
  private Integer departmentId;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable=false ,updatable = false)
  @JsonIgnore
  private Department department;

}
