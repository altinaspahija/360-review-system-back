package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Department;
import lombok.Data;

@Data
public class DepartmentDto {

  private int departmentId;
  private String departmentTitle;
  private int managerId;

  public static Department getDepartment(DepartmentDto departmentDto){
    if (departmentDto==null) return null;
    Department department = new Department();
    department.setDepartmentId(departmentDto.getDepartmentId());
    department.setDepartmentTitle(departmentDto.getDepartmentTitle());
    department.setManagerId(departmentDto.getManagerId());
    return department;
  }

  public static DepartmentDto getDepartmentDto(Department department){
    if (department==null) return null;
    DepartmentDto departmentDto = new DepartmentDto();
    departmentDto.setDepartmentId(department.getDepartmentId());
    departmentDto.setDepartmentTitle(department.getDepartmentTitle());
    departmentDto.setManagerId(department.getManagerId());
    return departmentDto;
  }

}
