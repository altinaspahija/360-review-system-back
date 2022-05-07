package com.employeessystem.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="role_id", insertable = true)
  private Integer roleId;

  @Column(name="role_description")
  private String roleDescription;

}
