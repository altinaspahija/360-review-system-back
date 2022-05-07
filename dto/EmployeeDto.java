package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Employee;
import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeDto {

  private int userId;
  private String name;
  private String surname;
  private String email;
  private String phoneNumber;
  private Date startDate;
  private int positionId;
  private int roleId;
  private String profileImage;

  public static Employee getEmployee(EmployeeDto employeeDto) {
    if (employeeDto ==null) return null;
    Employee employee = new Employee();
    employee.setUserId(employeeDto.getUserId());
    employee.setName(employeeDto.getName());
    employee.setSurname(employeeDto.getSurname());
    employee.setEmail(employeeDto.getEmail());
    employee.setPhoneNumber(employeeDto.getPhoneNumber());
    employee.setStartDate(employeeDto.getStartDate());
    employee.setPositionId(employeeDto.getPositionId());
    employee.setRoleId(employeeDto.getRoleId());
    employee.setProfileImage(employeeDto.getProfileImage());
    return employee;
  }

  public static EmployeeDto getEmployeeDto(Employee employee){
    if (employee ==null) return null;
    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setUserId(employee.getUserId());
    employeeDto.setName(employee.getName());
    employeeDto.setSurname(employee.getSurname());
    employeeDto.setEmail(employee.getEmail());
    employeeDto.setPhoneNumber(employee.getPhoneNumber());
    employeeDto.setStartDate(employee.getStartDate());
    employeeDto.setPositionId(employee.getPositionId());
    employeeDto.setRoleId(employee.getRoleId());
    employeeDto.setProfileImage(employee.getProfileImage());
    return employeeDto;
  }

}
