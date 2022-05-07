package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.*;
import com.employeessystem.backend.model.*;
import com.employeessystem.backend.service.ReviewQuestionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReviewQuestionDetailsController {

    @Autowired
    ReviewQuestionDetailsService reviewQuestionDetailsService;

    //http://localhost:9090/reviewQuestion GET
    @GetMapping(path = "/reviewQuestion/{id}", produces = "application/json")
    public ResponseEntity<ReviewQuestionDetails> getReviewQuestionDetailsById(@PathVariable(value = "id") int id) throws ReviewQuestionDetailsNotFoundException {
        return new ResponseEntity<>(reviewQuestionDetailsService.getReviewQuestionDetailById(id), HttpStatus.OK);
    }

    //http://localhost:9090/reviewQuestionDetails GET
    @GetMapping(path = "/reviewQuestionDetails", produces = "application/json")
    public ResponseEntity<List<ReviewQuestionDetails>> getReviewQuestionDetails() throws ReviewQuestionDetailsNotFoundException{
        return new ResponseEntity<>(reviewQuestionDetailsService.getAllReviewQuestionDetails(), HttpStatus.OK);
    }

    //http://localhost:9090/reviewQuestionDetails POST
    @PostMapping(path = "/reviewQuestionDetails", produces = "application/json")
    public ResponseEntity<ReviewQuestionDetails> postReviewQuestionDetails(@RequestBody ReviewQuestionDetails reviewQuestionDetails){
        return new ResponseEntity<>(reviewQuestionDetailsService.postAllReviewQuestionDetails(reviewQuestionDetails), HttpStatus.OK);
    }

    //http://localhost:9090/reviewQuestionDetailsByIds POST
    @PostMapping(path = "/reviewQuestionDetailsByIds", produces = "application/json")
    public ResponseEntity<Object> postReviewQuestionDetails(@RequestParam(value = "reviewId") int reviewId, @RequestParam(value = "questionId") int questionId){
        return new ResponseEntity<>(reviewQuestionDetailsService.postAllReviewQuestionDetailsByIds(reviewId, questionId), HttpStatus.OK);
    }

    //http://localhost:9090/getFillDataDetails GET
    @GetMapping("/getFillDataDetails")
    public List<FillReview> getFillDataDetails(@RequestParam(value = "reviewId") Integer reviewId, @RequestParam(value = "categoryDescription") String categoryDescription) throws ReviewNotFoundException, CategoryNotFoundException, InvalidParameterException {
        return reviewQuestionDetailsService.getFillDataDetails(reviewId, categoryDescription);
    }

    //http://localhost:9090/reviewQuestionDetail/{questionId} DELETE
    @DeleteMapping("reviewQuestionDetail/{reviewQuestionDetailsId}")
    public boolean deleteReviewQuestionDetailById(@PathVariable Integer reviewQuestionDetailsId) {
        return reviewQuestionDetailsService.deleteById(reviewQuestionDetailsId);
    }

    //http://localhost:9090/reviewQuestionByIds GET
    @GetMapping("reviewQuestionByIds")
    public ReviewQuestionDetails getReviewQuestionByIds(@RequestParam Integer reviewId, @RequestParam Integer questionId) throws ReviewNotFoundException,QuestionNotFoundException,InvalidParameterException{
        return reviewQuestionDetailsService.getReviewQuestionByIds(reviewId,questionId);
    }

    //http://localhost:9090/getAllFillDataDetails GET
    @GetMapping("/getAllFillDataDetails")
    public List<FillReview> getAllFillDataDetails(@RequestParam(value = "reviewId") Integer reviewId) throws ReviewNotFoundException, InvalidParameterException {
        return reviewQuestionDetailsService.getAllFillDataDetails(reviewId);
    }

    //http://localhost:9090/getAllFillDataDetailsByReviewIdAndEmployeeId GET
    @GetMapping("/getAllFillDataDetailsByReviewIdAndEmployeeId")
    public List<FillReview> getAllFillDataDetailsByReviewIdAndEmployeeId(@RequestParam(value = "reviewId") Integer reviewId, @RequestParam(value = "employeeId") Integer employeeId) throws ReviewNotFoundException, InvalidParameterException, UserNotFoundException {
        return reviewQuestionDetailsService.getAllFillDataDetailsByReviewIdAndToEmployeeId(reviewId, employeeId);
    }

}
