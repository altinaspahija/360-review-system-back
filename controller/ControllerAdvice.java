package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(UserNotFoundException ex){
    log.error("Requested Employee not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Employee not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(ReviewNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(ReviewNotFoundException ex){
    log.error("Requested Review not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Review not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(DepartmentNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(DepartmentNotFoundException ex){
    log.error("Requested Department not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Department not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(PositionNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(PositionNotFoundException ex){
    log.error("Requested Position not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Position not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(CategoryNotFoundException ex){
    log.error("Requested Category not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Category not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(QuestionNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(QuestionNotFoundException ex){
    log.error("Requested Question not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Question not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(TemplateReviewNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(TemplateReviewNotFoundException ex){
    log.error("Requested Template Review not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Template Review not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }


  @ExceptionHandler(ReviewAnswerNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(ReviewAnswerNotFoundException ex){
    log.error("Requested Review Answer not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Review Answer not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(ReviewQuestionDetailsNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(ReviewQuestionDetailsNotFoundException ex){
    log.error("Requested Review Question Details not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Review Question Details not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(ReviewInvitationNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(ReviewInvitationNotFoundException ex){
    log.error("Requested Review Invitation not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Review Invitation not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(RatingScaleNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(RatingScaleNotFoundException ex){
    log.error("Requested Rating Scale not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Rating Scale not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @ExceptionHandler(RatingReviewNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(RatingReviewNotFoundException ex){
    log.error("Requested Rating Review not found");
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message","Rating Review not found.");
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

}
