package com.employeessystem.backend.service;

import com.employeessystem.backend.dto.EmployeeDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.RoleNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.EmployeePositionDepartment;
import com.employeessystem.backend.service.implementation.EmployeeServiceImplementation;

import java.util.List;

public interface EmployeeService {

  EmployeeDto addEmployee(EmployeeDto employeeDto);
  EmployeeDto updateEmployeeByEmployeeId(Integer employeeId, EmployeeDto employeeDto) throws UserNotFoundException;
  boolean deleteEmployeeByEmployeeId(Integer employeeId) throws UserNotFoundException;
  List<EmployeePositionDepartment> getManagers(Integer roleId) throws UserNotFoundException, RoleNotFoundException;
  List<EmployeePositionDepartment> getEmployeesByDepartment(String departmentTitle) throws DepartmentNotFoundException;
  List<EmployeePositionDepartment> getEmployeesByDepartmentForReview(String departmentTitle) throws DepartmentNotFoundException;
  List<EmployeePositionDepartment> getEmployees() throws UserNotFoundException;
  List<EmployeePositionDepartment> getEmployeesForReview() throws UserNotFoundException;
  List<EmployeePositionDepartment> getEmployeeDetailsByEmployeeId(Integer employeeId) throws UserNotFoundException;
  List<EmployeeDto> getAllUsers() throws UserNotFoundException;
  EmployeeDto getUserByUserId(Integer EmployeeId) throws UserNotFoundException;
  List<Employee> getAllEmployees() throws UserNotFoundException;
  Employee getEmployeeByEmployeeId(Integer EmployeeId) throws UserNotFoundException;
  List<EmployeePositionDepartment> getManagersAndHRDetailsByEmployeeId(Integer employeeId) throws UserNotFoundException;
  String getEmployeeRole(String username) throws RoleNotFoundException;
  String getEmployeeUserId(String username) throws UserNotFoundException;
  String existsByUsernameAndPassword(String username, String password);
  Employee createEmployee(Employee employee);

}
