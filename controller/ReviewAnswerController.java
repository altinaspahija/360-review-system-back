package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.ReviewAnswerNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.model.ReviewAnswer;
import com.employeessystem.backend.service.ReviewAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReviewAnswerController {

    @Autowired
    ReviewAnswerService reviewAnswerService;

    //http://localhost:9090/allReviewAnswers GET
    @GetMapping(path = "/allReviewAnswers", produces = "application/json")
    public ResponseEntity<List<ReviewAnswer>> getAllReviewAnswers() throws ReviewAnswerNotFoundException {
        return new ResponseEntity<>(reviewAnswerService.getReviewAnswers(), HttpStatus.OK);
    }

    //http://localhost:9090/allAnswers GET
    @GetMapping(path = "/allAnswers", produces = "application/json")
    public ResponseEntity<List<ReviewAnswer>> getAnswers() throws ReviewAnswerNotFoundException{
        return new ResponseEntity<>(reviewAnswerService.getAnswers(), HttpStatus.OK);
    }

    //http://localhost:9090/oneReviewAnswer POST
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/oneReviewAnswer")
    public ResponseEntity<ReviewAnswer> createReviewAnswer(@RequestBody ReviewAnswer reviewAnswer) {
        return new ResponseEntity<>(reviewAnswerService.createReviewAnswer(reviewAnswer), HttpStatus.CREATED);
    }

}
