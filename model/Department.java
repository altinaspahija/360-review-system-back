package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="department")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="department_id", insertable = true)
  private Integer departmentId;

  @Column(name="department_title")
  private String departmentTitle;


  @Column(name="manager_id")
  private Integer managerId;

  @OneToOne
  @JoinColumn(name = "manager_id", referencedColumnName = "user_id", insertable=false ,updatable = false)
  private Employee employee;

  public Department() {
  }

  public Department(String departmentTitle) {
    this.departmentTitle = departmentTitle;
  }

}
