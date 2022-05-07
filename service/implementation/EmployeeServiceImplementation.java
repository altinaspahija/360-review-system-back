package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.dto.EmployeeDto;
import com.employeessystem.backend.dto.ReviewDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.exception.RoleNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.EmployeePositionDepartment;
import com.employeessystem.backend.model.Role;
import com.employeessystem.backend.repository.EmployeeRepository;
import com.employeessystem.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto addEmployee(EmployeeDto employeeDto) {
    Employee employee = EmployeeDto.getEmployee(employeeDto);
    employeeRepository.save(employee);
    return EmployeeDto.getEmployeeDto(employee);
  }

  @Override
  public EmployeeDto updateEmployeeByEmployeeId(Integer employeeId, EmployeeDto employeeDto) throws UserNotFoundException {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    if(optionalEmployee.isEmpty()) throw new UserNotFoundException();
    Employee employee = optionalEmployee.get();
    employee.setName(employeeDto.getName());
    employee.setSurname(employeeDto.getSurname());
    employee.setEmail(employeeDto.getEmail());
    employee.setPhoneNumber(employeeDto.getPhoneNumber());
    employee.setStartDate(employeeDto.getStartDate());

    employeeRepository.save(employee);
    return EmployeeDto.getEmployeeDto(employee);
  }

  @Override
  public boolean deleteEmployeeByEmployeeId(Integer employeeId) throws UserNotFoundException {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    if (optionalEmployee.isEmpty()){
      return false;
    }
    Employee tempEmployee = optionalEmployee.get();

    employeeRepository.deleteById(tempEmployee.getUserId());
    return true;
  }

  @Override
  public List<EmployeePositionDepartment> getManagers(Integer managerId) throws UserNotFoundException, RoleNotFoundException {
    Integer roleId = 2;
    return employeeRepository.getManagers(roleId);
  }

  @Override
  public List<EmployeePositionDepartment> getEmployeesByDepartment(String departmentTitle) throws DepartmentNotFoundException {
    return employeeRepository.getEmployeesByDepartment(departmentTitle);
  }

  @Override
  public List<EmployeePositionDepartment> getEmployeesByDepartmentForReview(String departmentTitle) throws DepartmentNotFoundException {
    return employeeRepository.getEmployeesByDepartmentForReview(departmentTitle);
  }

  @Override
  public List<EmployeePositionDepartment> getEmployees() throws UserNotFoundException {
    return employeeRepository.getEmployees();
  }

  @Override
  public List<EmployeePositionDepartment> getEmployeeDetailsByEmployeeId(Integer employeeId) throws UserNotFoundException {
    return employeeRepository.getEmployeeDetailsByEmployeeId(employeeId);
  }

  @Override
  public List<EmployeePositionDepartment> getEmployeesForReview() {
    return employeeRepository.getEmployeesForReview();
  }

  @Override
  public EmployeeDto getUserByUserId(Integer employeeId) throws UserNotFoundException {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    if (optionalEmployee.isEmpty()) throw new UserNotFoundException();
    Employee tempEmployee = optionalEmployee.get();
    return EmployeeDto.getEmployeeDto(tempEmployee);
  }

  @Override
  public List<Employee> getAllEmployees() throws UserNotFoundException {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeByEmployeeId(Integer EmployeeId) throws UserNotFoundException {
    Optional<Employee> optionalEmp = employeeRepository.findById(EmployeeId);
    if (optionalEmp.isPresent()) {
      return optionalEmp.get();
    }
    return null;
  }

  @Override
  public List<EmployeePositionDepartment> getManagersAndHRDetailsByEmployeeId(Integer employeeId) throws UserNotFoundException {
    return employeeRepository.getManagersAndHRDetailsByEmployeeId(employeeId);
  }

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public String getEmployeeRole(String username) throws RoleNotFoundException{
    return employeeRepository.getEmployeeRole(username);
  }

  @Override
  public String getEmployeeUserId(String username) throws UserNotFoundException{
    return employeeRepository.getEmployeeUserId(username);
  }

  @Override
  public String existsByUsernameAndPassword(String username, String password) {

    Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
    String originalString = password;
    String encodedString = encoder.encodeToString(originalString.getBytes());

    if (employeeRepository.existsByUsername(username)!=true&&employeeRepository.existsByPassword(encodedString)!=true)
    {
      return "Invalid credentials";
    }
    else if  (employeeRepository.existsByUsername(username)!=true&&employeeRepository.existsByPassword(encodedString)==true)
    {
      return "Username is Invalid";
    }
    else if (employeeRepository.existsByPassword(password)!=true&&employeeRepository.existsByUsername(encodedString)==true)
    {
      return "Password is Invalid";
    }
    else   {
      return "True";
    }
  }

  @Override
  public List<EmployeeDto> getAllUsers() throws UserNotFoundException {
    List<Employee> allEmployees = employeeRepository.findAll();
    List<EmployeeDto> employeeDtos = new ArrayList<>();
    if (allEmployees.isEmpty()) throw new UserNotFoundException();

    allEmployees.forEach(employee -> employeeDtos.add(EmployeeDto.getEmployeeDto(employee)));
    return employeeDtos;
 }

}
