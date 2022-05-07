package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.EmployeesReviewsRatings;
import com.employeessystem.backend.model.ReviewsBetweenEmployees;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.List;

public interface EmployeesReviewsService {

    List<EmployeesReviews> findEmployeesAndOpenReviews() throws UserNotFoundException,ReviewNotFoundException;
    List<EmployeesReviews> findEmployeesAndCloseReviews() throws UserNotFoundException,ReviewNotFoundException;
    List<EmployeesReviews> findClosedReviewsForEmployees(String employee) throws UserNotFoundException,ReviewNotFoundException;
    List<EmployeesReviews> findOpenReviewsForEmployees(String employee) throws UserNotFoundException, ReviewNotFoundException;
    List<EmployeesReviews>findOpenReviewsByEmployeeAndCreatedDate(String employee, Date createdDate) throws UserNotFoundException, InvalidParameterException;
    List<EmployeesReviews>findClosedReviewsByEmployeeAndExpiredDate(String employee,Date expirationDate) throws UserNotFoundException, InvalidParameterException;
    List<EmployeesReviews>findOpenReviewsByCreatedDate(Date createdDate) throws ReviewNotFoundException, InvalidParameterException;
    List<EmployeesReviews>findCloseReviewsByExpiredDate(Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
    List<EmployeesReviews>findAllReviewsForEmployee(Integer userId) throws ReviewNotFoundException, UserNotFoundException;
    List<ReviewsBetweenEmployees> findAllReviewsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException;
    List<ReviewsBetweenEmployees> findAllReviewsToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException;
    List<EmployeesReviews> findOpenReviewsByReviewName(String reviewName) throws ReviewNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findClosedReviewsByReviewName(String reviewName)  throws ReviewNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findOpenReviewsByEmployeeAndReviewName(String employee, String reviewName)  throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findOpenReviewsByCreatedDateAndReviewName(Date createdDate, String reviewName)  throws ReviewNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findOpenReviewsByEmployeeAndCreatedDateAndReviewName(String employee, Date createdDate, String reviewName)  throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findCloseReviewsByEmployeeAndReviewName(String employee, String reviewName)  throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findCloseReviewsByExpiredDateAndReviewName(Date expirationDate, String reviewName)  throws ReviewNotFoundException, InvalidParameterException;
    List<EmployeesReviews> findClosedReviewsByEmployeeAndExpirationDateAndReviewName(String employee, Date expirationDate, String reviewName)  throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException;
    Integer countAllReviewsForEmployee(Integer employeeId) throws UserNotFoundException, ReviewNotFoundException;
    Integer countAllReviewsByEmployee(Integer employeeId) throws UserNotFoundException, ReviewNotFoundException;
    Integer countAllReviewsToEmployee(Integer employeeId) throws UserNotFoundException, ReviewNotFoundException;
    List<EmployeesReviewsRatings> findAverageRatingsToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException;
    List<EmployeesReviewsRatings> findAverageRatingsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException;
    List<EmployeesReviewsRatings> findReviewsAverageRatingsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException;
    List<EmployeesReviewsRatings> findReviewsAverageRatingsToEmployee(Integer employeeId) throws  ReviewNotFoundException, UserNotFoundException;
    Double findAverageOverallRatingToEmployee(Integer employeeId) throws UserNotFoundException, ReviewNotFoundException;
    Double findAverageOverallRatingByEmployee(Integer employeeId) throws UserNotFoundException, ReviewNotFoundException;
    List<EmployeesReviews> findReviewForEmployee(Integer reviewId) throws UserNotFoundException, ReviewNotFoundException;

}
