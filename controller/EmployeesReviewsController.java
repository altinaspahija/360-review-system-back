package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.EmployeesReviewsRatings;
import com.employeessystem.backend.model.ReviewsBetweenEmployees;
import com.employeessystem.backend.service.EmployeesReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EmployeesReviewsController {

    @Autowired
    EmployeesReviewsService employeesReviewsService;

    //http://localhost:9090/reviews/employeesAndOpenReviews GET
    @GetMapping("reviews/employeesAndOpenReviews")
    public List<EmployeesReviews> findEmployeesAndOpenReviews() throws UserNotFoundException, ReviewNotFoundException {
        return employeesReviewsService.findEmployeesAndOpenReviews();
    }

    //http://localhost:9090/reviews/employeesAndOpenReviews GET
    @GetMapping("reviews/employeesAndCloseReviews")
    public List<EmployeesReviews> findEmployeesAndCloseReviews() throws UserNotFoundException, ReviewNotFoundException {
        return employeesReviewsService.findEmployeesAndCloseReviews();
    }

    //http://localhost:9090/reviews/closeReviewsByEmployee GET
    @GetMapping("reviews/closeReviewsByEmployee")
    public List<EmployeesReviews> findEmployeesOfCloseReviews(@RequestParam String employee) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException{
        return employeesReviewsService.findClosedReviewsForEmployees(employee);

    }
    //http://localhost:9090/reviews/openReviewsByEmployee GET
    @GetMapping("reviews/openReviewsByEmployee")
    public List<EmployeesReviews> findOpenReviewsForEmployees(@RequestParam String employee) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException{
        return employeesReviewsService.findOpenReviewsForEmployees(employee);
    }

    //http://localhost:9090/reviews/openReviewsByCreatedDate GET
    @GetMapping("reviews/openReviewsByCreatedDate")
    public List<EmployeesReviews> findOpenedReviewsByExpirationDate(@RequestParam Date createdDate) throws ReviewNotFoundException, InvalidParameterException {
        return employeesReviewsService.findOpenReviewsByCreatedDate(createdDate);
    }

    //http://localhost:9090/reviews/closeReviewsByExpirationDate GET
    @GetMapping("reviews/closeReviewsByExpirationDate")
    public List<EmployeesReviews> findClosedReviewsByExpirationDate(@RequestParam Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
        return employeesReviewsService.findCloseReviewsByExpiredDate(expirationDate);
    }


    //http://localhost:9090/reviews/openReviewsByEmployeeAndCreatedDate GET
    @GetMapping("reviews/openReviewsByEmployeeAndCreatedDate")
    public List<EmployeesReviews> findOpenReviewsByEmployeeOrCreatedDate(@RequestParam (required = false) String employee, @RequestParam (required = false) Date createdDate) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        if (employee==null&&createdDate==null) {
            throw new InvalidParameterException();
        }
        else if (employee==null&&createdDate!=null) {
            return employeesReviewsService.findOpenReviewsByCreatedDate(createdDate);
        }
        else if (employee!=null&&createdDate==null){
            return  employeesReviewsService.findOpenReviewsForEmployees(employee);
        }
        else
        {
            return employeesReviewsService.findOpenReviewsByEmployeeAndCreatedDate(employee, createdDate);
        }
    }

    //http://localhost:9090/reviews/closeReviewsByEmployeeAndExpirationDate GET
    @GetMapping("reviews/closeReviewsByEmployeeAndExpirationDate")
    public List<EmployeesReviews> findClosedReviewsByEmployeeOrCreatedDate(@RequestParam (required = false) String employee, @RequestParam (required = false) Date expirationDate) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        if (employee==null&&expirationDate==null) {
            throw new InvalidParameterException();
        }
        else if (employee==null&&expirationDate!=null) {
            return employeesReviewsService.findCloseReviewsByExpiredDate(expirationDate);
        }
        else if (employee!=null&&expirationDate==null){
            return  employeesReviewsService.findClosedReviewsForEmployees(employee);
        }
        else
        {
            return employeesReviewsService.findClosedReviewsByEmployeeAndExpiredDate(employee,expirationDate);
        }
    }

    //http://localhost:9090/reviews/openReviewsByEmployeeAndCreatedDateandReviewName GET
    @GetMapping("reviews/openReviewsByEmployeeAndCreatedDateAndReviewName")
    public List<EmployeesReviews> findOpenReviewsByEmployeeAndCreatedDateAndReviewName(@RequestParam (required = false) String employee, @RequestParam (required = false) Date createdDate, @RequestParam (required=false) String reviewName) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        if (employee==null&&createdDate==null&&reviewName==null) {
            throw new InvalidParameterException();
        }
        else if (employee==null&&createdDate!=null&&reviewName==null) {
            return employeesReviewsService.findOpenReviewsByCreatedDate(createdDate);
        }
        else if (employee!=null&&createdDate==null&&reviewName==null){
            return employeesReviewsService.findOpenReviewsForEmployees(employee);
        }
        else if(employee==null&&createdDate==null&&reviewName!=null){
            return employeesReviewsService.findOpenReviewsByReviewName(reviewName);
        }
        else if(employee!=null&&createdDate==null&&reviewName!=null){
            return employeesReviewsService.findOpenReviewsByEmployeeAndReviewName(employee,reviewName);
        }
        else if(employee==null&&createdDate!=null&&reviewName!=null){
            return employeesReviewsService.findOpenReviewsByCreatedDateAndReviewName(createdDate,reviewName);
        }
        else if(employee!=null&&createdDate!=null&&reviewName==null){
            return employeesReviewsService.findOpenReviewsByEmployeeAndCreatedDate(employee, createdDate);
        }
        else
        {
            return employeesReviewsService.findOpenReviewsByEmployeeAndCreatedDateAndReviewName(employee, createdDate,reviewName);
        }
    }

    //http://localhost:9090/reviews/closeReviewsByEmployeeAndExpirationDateAndReviewName GET
    @GetMapping("reviews/closeReviewsByEmployeeAndExpirationDateAndReviewName")
    public List<EmployeesReviews> findClosedReviewsByEmployeeAndCreatedDateAndReviewName(@RequestParam (required = false) String employee, @RequestParam (required = false) Date expirationDate, @RequestParam (required=false) String reviewName) throws ReviewNotFoundException, UserNotFoundException, InvalidParameterException {
        if (employee==null&&expirationDate==null&&reviewName==null) {
            throw new InvalidParameterException();
        }
        else if (employee==null&&expirationDate!=null&&reviewName==null) {
            return employeesReviewsService.findCloseReviewsByExpiredDate(expirationDate);
        }
        else if (employee!=null&&expirationDate==null&&reviewName==null){
            return  employeesReviewsService.findClosedReviewsForEmployees(employee);
        }
        else if (employee==null&&expirationDate==null&&reviewName!=null){
            return  employeesReviewsService.findClosedReviewsByReviewName(reviewName);
        }
        else if(employee!=null&&expirationDate==null&&reviewName!=null){
            return employeesReviewsService.findCloseReviewsByEmployeeAndReviewName(employee, reviewName);
        }
        else if(employee==null&&expirationDate!=null&&reviewName!=null){
            return employeesReviewsService.findCloseReviewsByExpiredDateAndReviewName(expirationDate,reviewName);
        }
        else if(employee!=null&&expirationDate!=null&&reviewName==null){
            return employeesReviewsService.findClosedReviewsByEmployeeAndExpiredDate(employee, expirationDate);
        }
        else {
            return employeesReviewsService.findClosedReviewsByEmployeeAndExpirationDateAndReviewName(employee,expirationDate,reviewName);
        }

    }

    //http://localhost:9090/reviews/reviewsForEmployee/{employeeId} GET
    @GetMapping("reviews/reviewsForEmployee/{employeeId}")
    public List<EmployeesReviews> findAllReviewsForEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findAllReviewsForEmployee(employeeId);
    }

    //http://localhost:9090/reviews/reviewForEmployee/{reviewId} GET
    @GetMapping("reviews/reviewForEmployee/{reviewId}")
    public List<EmployeesReviews> findReviewForEmployee(@PathVariable Integer reviewId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findReviewForEmployee(reviewId);
    }

    //http://localhost:9090/reviews/countAllReviewsForEmployee/{employeeId} GET
    @GetMapping("reviews/countAllReviewsForEmployee/{employeeId}")
    public Integer countAllReviewsForEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.countAllReviewsForEmployee(employeeId);
    }

    //http://localhost:9090/reviews/countAllReviewsByEmployee/{employeeId} GET
    @GetMapping("reviews/countAllReviewsByEmployee/{employeeId}")
    public Integer countAllReviewsByEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.countAllReviewsByEmployee(employeeId);
    }

    //http://localhost:9090/reviews/countAllReviewsToEmployee/{employeeId} GET
    @GetMapping("reviews/countAllReviewsToEmployee/{employeeId}")
    public Integer countAllReviewsToEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.countAllReviewsToEmployee(employeeId);
    }

    //http://localhost:9090/reviews/reviewsByEmployee/{employeeId} GET
    @GetMapping("reviews/reviewsByEmployee/{employeeId}")
    public List<ReviewsBetweenEmployees> findAllReviewsByEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findAllReviewsByEmployee(employeeId);
    }

    //http://localhost:9090/reviews/reviewsToEmployee/{employeeId} GET
    @GetMapping("reviews/reviewsToEmployee/{employeeId}")
    public List<ReviewsBetweenEmployees> findAllReviewsToEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findAllReviewsToEmployee(employeeId);
    }

    //http://localhost:9090/reviews/averageRatingsToEmployee/{employeeId} GET
    @GetMapping("reviews/averageRatingsToEmployee/{employeeId}")
    public List<EmployeesReviewsRatings> findAverageRatingsToEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findAverageRatingsToEmployee(employeeId);
    }

    //http://localhost:9090/reviews/averageRatingsByEmployee/{employeeId} GET
    @GetMapping("reviews/averageRatingsByEmployee/{employeeId}")
    public List<EmployeesReviewsRatings> findAverageRatingsByEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException,UserNotFoundException {
        return employeesReviewsService.findAverageRatingsByEmployee(employeeId);
    }

    //http://localhost:9090/reviews/averageOverallRatingToEmployee/{employeeId} GET
    @GetMapping("reviews/averageOverallRatingToEmployee/{employeeId}")
    public Double findAverageOverallRatingToEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException,UserNotFoundException {
        return employeesReviewsService.findAverageOverallRatingToEmployee(employeeId);
    }

    //http://localhost:9090/reviews/averageOverallRatingByEmployee/{employeeId} GET
    @GetMapping("reviews/averageOverallRatingByEmployee/{employeeId}")
    public Double findAverageOverallRatingByEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findAverageOverallRatingByEmployee(employeeId);
    }

    //http://localhost:9090/reviews/averageReviewsRatingsToEmployee/{employeeId}GET
    @GetMapping("reviews/averageReviewsRatingsToEmployee/{employeeId}")
    public List<EmployeesReviewsRatings> findReviewsAverageRatingsToEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findReviewsAverageRatingsToEmployee(employeeId);
    }

    //http://localhost:9090/reviews/averageReviewsRatingsByEmployee/{employeeId}GET
    @GetMapping("reviews/averageReviewsRatingsByEmployee/{employeeId}")
    public List<EmployeesReviewsRatings> findReviewsAverageRatingsByEmployee(@PathVariable Integer employeeId) throws ReviewNotFoundException, UserNotFoundException {
        return employeesReviewsService.findReviewsAverageRatingsByEmployee(employeeId);
    }

}
