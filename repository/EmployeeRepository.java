package com.employeessystem.backend.repository;

import com.employeessystem.backend.dto.EmployeeDto;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.EmployeePositionDepartment;
import com.employeessystem.backend.model.Position;

import com.employeessystem.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer> {

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId =:roleId order by d.departmentId")
    List<EmployeePositionDepartment> getManagers(Integer roleId);

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId not in (1,2) and d.departmentTitle=:departmentTitle order by e.startDate")
    List<EmployeePositionDepartment> getEmployeesByDepartment(String departmentTitle);

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId <> 1 and d.departmentTitle=:departmentTitle order by e.startDate")
    List<EmployeePositionDepartment> getEmployeesByDepartmentForReview(String departmentTitle);

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId <> 1 order by e.name")
    List<EmployeePositionDepartment> getEmployeesForReview();

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId not in (1,2) order by d.departmentId")
    List<EmployeePositionDepartment> getEmployees();

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId not in (1,2) and e.userId =:employeeId order by d.departmentId")
    List<EmployeePositionDepartment> getEmployeeDetailsByEmployeeId(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.EmployeePositionDepartment(e.userId, e.name, e.surname, e.email, e.phoneNumber, e.startDate, e.profileImage, p.positionTitle, d.departmentTitle) from Employee e inner join e.position p inner join  p.department d where e.roleId in (1,2) and e.userId =:employeeId order by d.departmentId")
    List<EmployeePositionDepartment> getManagersAndHRDetailsByEmployeeId(Integer employeeId);

    @Query("select r.roleDescription from Employee e join Role r on e.roleId = r.roleId where e.username=:username")
    String getEmployeeRole(String username);

    @Query("select e.userId from Employee e where e.username=:username")
    String getEmployeeUserId(String username);

    boolean existsByUsername(String username);

    boolean existsByPassword(String password);

}




