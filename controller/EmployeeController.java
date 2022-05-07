package com.employeessystem.backend.controller;

import com.employeessystem.backend.dto.EmployeeDto;
import com.employeessystem.backend.dto.PositionDto;
import com.employeessystem.backend.dto.RoleDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.PositionNotFoundException;
import com.employeessystem.backend.exception.RoleNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.EmployeePositionDepartment;
import com.employeessystem.backend.model.Role;
import com.employeessystem.backend.repository.EmployeeRepository;
import com.employeessystem.backend.repository.RoleRepository;

import com.employeessystem.backend.service.EmployeeService;
import com.employeessystem.backend.service.PositionService;
import com.employeessystem.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Column;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @Autowired
  RoleService roleService;

  @Autowired
  PositionService positionService;

  @Autowired
  EmployeeRepository employeeRepository;

  //http://localhost:9090/roles GET
  @GetMapping("roles")
  public List<RoleDto> getAllRoles() throws RoleNotFoundException {
    return roleService.getAllRoles();
  }

  //http://localhost:9090/positions GET
  @GetMapping("positions")
  public List<PositionDto> getAllPositions() throws PositionNotFoundException {
    return positionService.getAllPositions();
  }

  //http://localhost:9090/employee POST
  @PostMapping("employee")
  public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
    return employeeService.addEmployee(employeeDto);
  }

  //http://localhost:9090/employees PUT
  @PutMapping("employees/{employeeId}")
  public EmployeeDto updateEmployeeByEmployeeId(@PathVariable Integer employeeId, @RequestBody EmployeeDto employeeDto) throws UserNotFoundException {
    return employeeService.updateEmployeeByEmployeeId(employeeId, employeeDto);
  }

  //http://localhost:9090/employees/employeeId DELETE
  @DeleteMapping("employees/{employeeId}")
  public boolean deleteEmployeeByEmployeeId(@PathVariable Integer employeeId) throws UserNotFoundException {
    return employeeService.deleteEmployeeByEmployeeId(employeeId);
  }

  //http://localhost:9090/users GET
  @GetMapping("users")
  public List<EmployeeDto> getAllUsers() throws UserNotFoundException {
    return employeeService.getAllUsers();
  }

  //http://localhost:9090/users GET
  @GetMapping("users/{userId}")
  public EmployeeDto getUserByUserId(@PathVariable Integer userId) throws UserNotFoundException {
    EmployeeDto employee = employeeService.getUserByUserId(userId);
    if (employee == null) return null;
    else return employee;
  }

  //http://localhost:9090/employees GET
  @GetMapping("employees")
  public List<EmployeePositionDepartment> getEmployees() throws UserNotFoundException {
    return employeeService.getEmployees();
  }

  //http://localhost:9090/managers GET
  @GetMapping("/managers")
  public List<EmployeePositionDepartment> getManagers(Integer roleId) throws UserNotFoundException, RoleNotFoundException {
    return employeeService.getManagers(roleId);
  }

  //http://localhost:9090/employeesByDepartment GET
  @GetMapping("/employeesByDepartment/{departmentTitle}")
  public List<EmployeePositionDepartment> getEmployeesByDepartment(@PathVariable String departmentTitle) throws DepartmentNotFoundException {
    return employeeService.getEmployeesByDepartment(departmentTitle);
  }

  //http://localhost:9090/employeesByDepartmentForReview GET
  @GetMapping("/employeesByDepartmentForReview/{departmentTitle}")
  public List<EmployeePositionDepartment> getEmployeesByDepartmentForReview(@PathVariable String departmentTitle) throws DepartmentNotFoundException {
    return employeeService.getEmployeesByDepartmentForReview(departmentTitle);
  }

  //http://localhost:9090/employeesForReview GET
  @GetMapping("/employeesForReview")
  public List<EmployeePositionDepartment> getEmployeesByDepartmentForReview() throws UserNotFoundException{
    return employeeService.getEmployeesForReview();
  }

  //http://localhost:9090/employeeDetails GET
  @GetMapping("/employeeDetails/{employeeId}")
  public List<EmployeePositionDepartment> getEmployeeDetailsByEmployeeId(@PathVariable Integer employeeId) throws UserNotFoundException {
    return employeeService.getEmployeeDetailsByEmployeeId(employeeId);
  }

  //http://localhost:9090/managersAndHRDetails GET
  @GetMapping("/managersAndHRDetails/{employeeId}")
  public List<EmployeePositionDepartment> getManagersAndHRDetailsByEmployeeId(@PathVariable Integer employeeId) throws UserNotFoundException {
    return employeeService.getManagersAndHRDetailsByEmployeeId(employeeId);
  }

  //http://localhost:9090/getRole GET
  @GetMapping("/getRole")
  public String getRole(@RequestParam String username) throws RoleNotFoundException{
    return employeeService.getEmployeeRole(username);
  }

  //http://localhost:9090/getUserId GET
  @GetMapping("/getUserId")
  public String getUserId(@RequestParam String username) throws UserNotFoundException{
    return employeeService.getEmployeeUserId(username);
  }

  //http://localhost:9090/signIn GET
  @GetMapping("/signIn")
  public String existsByUsernameAndPassword(@RequestParam String username,@RequestParam String password) {
    return employeeService.existsByUsernameAndPassword(username,password);
  }

  //http://localhost:9090/employee GET
  @GetMapping(path = "/employee/{employeeId}", produces = "application/json")
  public ResponseEntity<Employee> getEmployee(@PathVariable(value = "employeeId") int employeeId) throws UserNotFoundException {
    return new ResponseEntity<>(employeeService.getEmployeeByEmployeeId(employeeId), HttpStatus.OK);
  }

  //http://localhost:9090/allEmployees GET
  @GetMapping(path = "/allEmployees", produces = "application/json")
  public ResponseEntity<List<Employee>> getAllEmployees() throws UserNotFoundException {
    return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
  }

  //http://localhost:9090/oneEmployee POST
  @PostMapping(consumes = "application/json", produces = "application/json", path = "/oneEmployee")
  public Employee createEmployee(
          @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("username") String username, @RequestParam("password") String password,
          @RequestParam("email") String email, @RequestParam(value="phoneNumber") String phoneNumber, @RequestParam("startDate") Date startDate,
          @RequestParam("positionId") Integer positionId, @RequestParam("roleId") Integer roleId)
  {
    Employee newEmployee = new Employee();

    Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
    String originalString = password;
    String encodedString = encoder.encodeToString(originalString.getBytes());

    newEmployee.setName(name);
    newEmployee.setSurname(surname);
    newEmployee.setUsername(username);
    newEmployee.setPassword(encodedString);
    newEmployee.setEmail(email);
    newEmployee.setPhoneNumber('+' + phoneNumber);
    newEmployee.setStartDate(startDate);
    newEmployee.setRoleId(roleId);
    newEmployee.setPositionId(positionId);

    return employeeRepository.save(newEmployee);
  }

}
