package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeesReviewsRepository extends JpaRepository<Review,Integer> {

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.createdTo=:employeeId")
    List<EmployeesReviews> findAllReviewsForEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.reviewId=:reviewId")
    List<EmployeesReviews> findReviewForEmployee(Integer reviewId);

    @Query("select count(*) from Review re inner join Employee u on u.userId = re.createdTo where re.createdTo=:employeeId")
    Integer countAllReviewsForEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where ((concat(u.name, ' ' ,u.surname)) like %:employee%) and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsForEmployees(String employee);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where ((concat(u.name, ' ' ,u.surname)) like %:employee%) and re.status='Close'")
    List<EmployeesReviews> findClosedReviewsForEmployees(String employee);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.createdDate=:createdDate and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsByCreatedDate(Date createdDate);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.reviewName like %:reviewName% and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsByReviewName(String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.expirationDate=:expirationDate and re.status='Close'")
    List<EmployeesReviews> findClosedReviewsByExpiredDate(Date expirationDate);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.reviewName like %:reviewName% and re.status='Close'")
    List<EmployeesReviews> findClosedReviewsByReviewName(String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.createdDate=:createdDate and ((concat(u.name, ' ' ,u.surname)) like %:employee%)) and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsByEmployeeAndCreatedDate(String employee, Date createdDate);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.reviewName like %:reviewName% and ((concat(u.name, ' ' ,u.surname)) like %:employee%)) and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsByEmployeeAndReviewName(String employee, String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.reviewName like %:reviewName% and re.createdDate=:createdDate) and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsByCreatedDateAndReviewName(Date createdDate, String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.createdDate=:createdDate and ((concat(u.name, ' ' ,u.surname)) like %:employee%) and re.reviewName like %:reviewName%) and re.status='Open'")
    List<EmployeesReviews> findOpenReviewsByEmployeeAndCreatedDateAndReviewName(String employee, Date createdDate, String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.expirationDate=:expirationDate and ((concat(u.name, ' ' ,u.surname)) like %:employee%)) and re.status='Close'")
    List<EmployeesReviews> findClosedReviewsByEmployeeAndExpirationDate(String employee, Date expirationDate);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.reviewName like %:reviewName% and ((concat(u.name, ' ' ,u.surname)) like %:employee%)) and re.status='Close'")
    List<EmployeesReviews> findCloseReviewsByEmployeeAndReviewName(String employee, String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.reviewName like %:reviewName% and re.expirationDate=:expirationDate) and re.status='Close'")
    List<EmployeesReviews> findCloseReviewsByExpiredDateAndReviewName(Date expirationDate, String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where (re.expirationDate=:expirationDate and ((concat(u.name, ' ' ,u.surname)) like %:employee%) and re.reviewName like %:reviewName%) and re.status='Close'")
    List<EmployeesReviews> findClosedReviewsByEmployeeAndExpirationDateAndReviewName(String employee, Date expirationDate, String reviewName);

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.status='Open'")
    List <EmployeesReviews> findEmployeesAndOpenReviews();

    @Query("select new com.employeessystem.backend.model.EmployeesReviews (u.userId, re.reviewName, re.createdDate, re.expirationDate, re.status, u.name, u.surname) from Review re inner join Employee u on u.userId = re.createdTo where re.status='Close'")
    List <EmployeesReviews> findEmployeesAndCloseReviews();

}
