package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.EmployeesReviewsRatings;
import com.employeessystem.backend.model.ReviewsBetweenEmployees;
import com.employeessystem.backend.repository.EmployeesReviewsRatingsRepository;
import com.employeessystem.backend.repository.EmployeesReviewsRepository;
import com.employeessystem.backend.repository.ReviewsBetweenEmployeesRepository;
import com.employeessystem.backend.service.EmployeesReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.List;

@Service
public class EmployeesReviewsServiceImplementation implements EmployeesReviewsService {

    @Autowired
    EmployeesReviewsRepository employeesReviewsRepository;
    @Autowired
    ReviewsBetweenEmployeesRepository reviewsBetweenEmployeesRepository;
    @Autowired
    EmployeesReviewsRatingsRepository employeesReviewsRatingsRepository;

    @Override
    public List<EmployeesReviews> findEmployeesAndOpenReviews() throws UserNotFoundException, ReviewNotFoundException{
        return employeesReviewsRepository.findEmployeesAndOpenReviews();
    }

    @Override
    public List<EmployeesReviews> findEmployeesAndCloseReviews() throws UserNotFoundException, ReviewNotFoundException{
        return employeesReviewsRepository.findEmployeesAndCloseReviews();
    }

    @Override
    public List<EmployeesReviews> findClosedReviewsForEmployees(String employee) throws UserNotFoundException, ReviewNotFoundException {
        return employeesReviewsRepository.findClosedReviewsForEmployees(employee);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsForEmployees(String employee) throws UserNotFoundException, ReviewNotFoundException {
        return employeesReviewsRepository.findOpenReviewsForEmployees(employee);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsByEmployeeAndCreatedDate(String employee, Date createdDate) throws UserNotFoundException, InvalidParameterException {
        return  employeesReviewsRepository.findOpenReviewsByEmployeeAndCreatedDate(employee,createdDate);
    }

    @Override
    public List<EmployeesReviews> findClosedReviewsByEmployeeAndExpiredDate(String employee, Date expirationDate) throws UserNotFoundException, InvalidParameterException{
        return employeesReviewsRepository.findClosedReviewsByEmployeeAndExpirationDate(employee,expirationDate);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsByCreatedDate(Date createdDate) throws ReviewNotFoundException, InvalidParameterException{
        return employeesReviewsRepository.findOpenReviewsByCreatedDate(createdDate);
    }

    @Override
    public List<EmployeesReviews> findCloseReviewsByExpiredDate(Date expirationDate) throws ReviewNotFoundException, InvalidParameterException{
        return employeesReviewsRepository.findClosedReviewsByExpiredDate(expirationDate);
    }

    @Override
    public List<EmployeesReviews> findAllReviewsForEmployee(Integer userId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsRepository.findAllReviewsForEmployee(userId);
    }

    @Override
    public List<ReviewsBetweenEmployees> findAllReviewsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return reviewsBetweenEmployeesRepository.findAllReviewsByEmployee(employeeId);
    }

    @Override
    public List<ReviewsBetweenEmployees> findAllReviewsToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return reviewsBetweenEmployeesRepository.findAllReviewsToEmployee(employeeId);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsByReviewName(String reviewName) throws ReviewNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findOpenReviewsByReviewName(reviewName);
    }

    @Override
    public List<EmployeesReviews> findClosedReviewsByReviewName(String reviewName) throws ReviewNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findClosedReviewsByReviewName(reviewName);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsByEmployeeAndReviewName(String employee, String reviewName) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findOpenReviewsByEmployeeAndReviewName(employee,reviewName);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsByCreatedDateAndReviewName(Date createdDate, String reviewName) throws ReviewNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findOpenReviewsByCreatedDateAndReviewName(createdDate,reviewName);
    }

    @Override
    public List<EmployeesReviews> findOpenReviewsByEmployeeAndCreatedDateAndReviewName(String employee, Date createdDate, String reviewName) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findOpenReviewsByEmployeeAndCreatedDateAndReviewName(employee,createdDate,reviewName);
    }

    @Override
    public List<EmployeesReviews> findCloseReviewsByEmployeeAndReviewName(String employee, String reviewName) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findCloseReviewsByEmployeeAndReviewName(employee,reviewName);
    }

    @Override
    public List<EmployeesReviews> findCloseReviewsByExpiredDateAndReviewName(Date expirationDate, String reviewName) throws ReviewNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findCloseReviewsByExpiredDateAndReviewName(expirationDate,reviewName);
    }

    @Override
    public List<EmployeesReviews> findClosedReviewsByEmployeeAndExpirationDateAndReviewName(String employee, Date expirationDate, String reviewName) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        return employeesReviewsRepository.findClosedReviewsByEmployeeAndExpirationDateAndReviewName(employee,expirationDate,reviewName);
    }

    @Override
    public Integer countAllReviewsForEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException{
        return employeesReviewsRepository.countAllReviewsForEmployee(employeeId);
    }

    @Override
    public Integer countAllReviewsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException{
        return reviewsBetweenEmployeesRepository.countAllReviewsByEmployee(employeeId);
    }

    @Override
    public Integer countAllReviewsToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException{
        return reviewsBetweenEmployeesRepository.countAllReviewsToEmployee(employeeId);
    }

    @Override
    public List<EmployeesReviewsRatings> findAverageRatingsToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException{
        return employeesReviewsRatingsRepository.findAverageRatingsToEmployee(employeeId);
    }

    @Override
    public List<EmployeesReviewsRatings> findAverageRatingsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException{
        return employeesReviewsRatingsRepository.findAverageRatingsByEmployee(employeeId);
    }

    @Override
    public List<EmployeesReviewsRatings> findReviewsAverageRatingsByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsRatingsRepository.findReviewsAverageRatingsByEmployee(employeeId);
    }

    @Override
    public List<EmployeesReviewsRatings> findReviewsAverageRatingsToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsRatingsRepository.findReviewsAverageRatingsToEmployee(employeeId);
    }

    @Override
    public Double findAverageOverallRatingToEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsRatingsRepository.findAverageOverallRatingToEmployee(employeeId);
    }

    @Override
    public Double findAverageOverallRatingByEmployee(Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsRatingsRepository.findAverageOverallRatingByEmployee(employeeId);
    }

    @Override
    public List<EmployeesReviews> findReviewForEmployee(Integer reviewId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsRepository.findReviewForEmployee(reviewId);
    }

}
