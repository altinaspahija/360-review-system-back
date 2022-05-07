package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.QuestionNotFoundException;
import com.employeessystem.backend.exception.ReviewInvitationNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.*;
import com.employeessystem.backend.repository.ReviewsInvitationRepository;
import com.employeessystem.backend.service.ReviewsInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReviewsInvitationController {

    @Autowired
    ReviewsInvitationService reviewsInvitationService;
    @Autowired
    ReviewsInvitationRepository reviewsInvitationRepository;

    //http://localhost:9090/numberOfRespondents GET
    @GetMapping("numberOfRespondents")
    public List<ReviewsParticipation> findNumberOfRespondents(){
        return reviewsInvitationService.findNumberOfRespondents();
    }

    //http://localhost:9090/numberOfRespondentsOfRecentReview GET
    @GetMapping("numberOfRespondentsOfRecentReview")
    public List<ReviewsParticipation> findNumberOfRespondentsOfRecentReview(){
        return reviewsInvitationService.findNumberOfRespondentsOfRecentReview();
    }

    //http://localhost:9090/overallNumberOfRespondents GET
    @GetMapping("overallNumberOfRespondents")
    public Integer findOverallNumberOfRespondents(){
        return reviewsInvitationService.findOverallNumberOfRespondents();
    }

    //http://localhost:9090/numberOfInvitations GET
    @GetMapping("numberOfInvitations")
    public List<ReviewsParticipation> findNumberOfInvitations(){
        return reviewsInvitationService.findNumberOfInvitations();
    }

    //http://localhost:9090/numberOfInvitationsOfRecentReview GET
    @GetMapping("numberOfInvitationsOfRecentReview")
    public List<ReviewsParticipation> findNumberOfRecentInvitation(){
        return reviewsInvitationService.findNumberOfRecentInvitation();
    }

    //http://localhost:9090/overallNumberOfInvitations GET
    @GetMapping("overallNumberOfInvitations")
    public Integer findOverallNumberOfInvitations(){
        return reviewsInvitationService.findOverallNumberOfInvitations();
    }

    //http://localhost:9090/numberOfRespondentsToEmployee GET
    @GetMapping("numberOfRespondentsToEmployee/{employeeId}")
    public List<ReviewsParticipation> findNumberOfRespondentsToEmployee(@PathVariable Integer employeeId) throws UserNotFoundException {
        return reviewsInvitationService.findNumberOfRespondentsToEmployee(employeeId);
    }

    //http://localhost:9090/numberOfRespondsByEmployee GET
    @GetMapping("numberOfRespondsByEmployee/{employeeId}")
    public List<ReviewsResponse> findNumberOfRespondsByEmployee(@PathVariable Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationService.findNumberOfRespondsByEmployee(employeeId);
    }

    //http://localhost:9090/overallNumberOfRespondentsToEmployee GET
    @GetMapping("overallNumberOfRespondentsToEmployee/{employeeId}")
    public Integer findOverallNumberOfRespondentsToEmployee(@PathVariable Integer employeeId) throws UserNotFoundException {
        return reviewsInvitationService.findOverallNumberOfRespondentsToEmployee(employeeId);
    }

    //http://localhost:9090/overallNumberOfRespondsByEmployee GET
    @GetMapping("overallNumberOfRespondsByEmployee/{employeeId}")
    public Integer findOverallNumberOfRespondsByEmployee(@PathVariable Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationService.findOverallNumberOfRespondsByEmployee(employeeId);
    }

    //http://localhost:9090/reviewsNumberOfRespondsByEmployee GET
    @GetMapping("reviewsNumberOfRespondsByEmployee/{employeeId}")
    public List<ReviewsResponse> findReviewsNumberOfRespondsByEmployee(@PathVariable Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationService.findReviewsNumberOfRespondsByEmployee(employeeId);
    }

    //http://localhost:9090/reviewInvitationsByOpenStatusAndEmployee GET
    @GetMapping("reviewInvitationsByOpenStatusAndEmployee/{employeeId}")
    public List<ReviewsResponse> getReviewInvitationsByOpenStatusAndEmployee(@PathVariable Integer employeeId) throws UserNotFoundException, ReviewInvitationNotFoundException{
        return reviewsInvitationService.getReviewInvitationsByOpenStatusAndEmployee(employeeId);
    }

    //http://localhost:9090/reviewsNumberOfRespondentsToEmployee GET
    @GetMapping("reviewsNumberOfRespondentsToEmployee/{employeeId}")
    public List<ReviewsParticipation> findReviewsNumberOfRespondentsToEmployee(@PathVariable Integer employeeId) throws UserNotFoundException{
        return reviewsInvitationService.findReviewsNumberOfRespondentsToEmployee(employeeId);
    }

    //http://localhost:9090/reviewInvitations GET
    @GetMapping(path = "/reviewInvitations", produces = "application/json")
    public ResponseEntity<List<ReviewInvitation>> getReviewInvitations() throws ReviewInvitationNotFoundException {
        return new ResponseEntity<>(reviewsInvitationService.getReviewInvitations(), HttpStatus.OK);
    }

    //http://localhost:9090/reviewInvitations GET
    @GetMapping(path = "/reviewInvitationById/{reviewInvitationId}", produces = "application/json")
    public ResponseEntity<ReviewInvitation> getReviewInvitation(@PathVariable(value = "reviewInvitationId") Long reviewInvitationId) throws ReviewInvitationNotFoundException{
        return new ResponseEntity<>(reviewsInvitationService.getReviewInvitationById(reviewInvitationId), HttpStatus.OK);
    }

    //http://localhost:9090/oneReviewInvitation POST
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/oneReviewInvitation")
    public ResponseEntity<ReviewInvitation> createReviewInvitation(@RequestBody ReviewInvitation reviewInvitation) {
        return new ResponseEntity<>(reviewsInvitationService.createReviewInvitation(reviewInvitation), HttpStatus.CREATED);
    }

    //http://localhost:9090/reviewInvitation DELETE
    @DeleteMapping("reviewInvitation/{reviewInvitationId}")
    public boolean deleteReviewInvitationId(@PathVariable Long reviewInvitationId) {
        return reviewsInvitationService.deleteById(reviewInvitationId);
    }

    //http://localhost:9090/reviewInvitation/update PUT
    @PutMapping("/reviewInvitation/update/{status}/{completedDate}/{reviewInvitationId}")
    public ResponseEntity<Integer> updateReviewInvitationStatusAndDate(@PathVariable String status, @PathVariable Date completedDate, @PathVariable Long reviewInvitationId) {
        return new ResponseEntity<Integer>(reviewsInvitationRepository.updateReviewInvitationStatusAndDate(status, completedDate, reviewInvitationId), HttpStatus.OK);
    }

}
