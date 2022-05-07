package com.employeessystem.backend.controller;

import com.employeessystem.backend.dto.ReviewDto;
import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ReviewController {

  @Autowired
   private ReviewService reviewService;

  //http://localhost:9090/reviews GET
  @GetMapping("reviews/{reviewId}")
  public ReviewDto getReviewByReviewId(@PathVariable Integer reviewId) throws ReviewNotFoundException {
    ReviewDto review = reviewService.getReviewByReviewId(reviewId);
    if (review == null) return null;
    else return review;
  }

  //http://localhost:9090/review GET
  @GetMapping(path = "/review/{reviewId}", produces = "application/json")
  public ResponseEntity<Review> getReview(@PathVariable(value = "reviewId") int reviewId) throws ReviewNotFoundException {
    return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
  }

  //http://localhost:9090/oneReview POST
  @PostMapping(consumes = "application/json", produces = "application/json", path = "/oneReview")
  public ResponseEntity<Review> createReview(@RequestBody Review review) {
    return new ResponseEntity<>(reviewService.createReview(review), HttpStatus.CREATED);
  }

  //http://localhost:9090/reviews GET
  @GetMapping("reviews")
  public List<ReviewDto> getReviews() throws ReviewNotFoundException {
    return reviewService.getReviews();
  }

  //http://localhost:9090/getReviewsIdsDesc GET
  @GetMapping("getReviewsIdsDesc")
  public List<Integer> getReviewsIdsDesc() throws ReviewNotFoundException {
    return reviewService.getReviewIdsDesc();
  }

  //http://localhost:9090/reviews/count GET
  @GetMapping("reviews/count")
  public int countReviews(){
    return reviewService.countReviews();
  }

  //http://localhost:9090/reviews/countByOpenStatus GET
  @GetMapping("reviews/countByOpenStatus")
  public int countReviewsByOpenStatus(boolean status){
    return reviewService.countReviewsByOpenStatus();
  }

  //http://localhost:9090/reviews/countByCloseStatus GET
  @GetMapping("reviews/countByCloseStatus")
  public int countReviewsByCloseStatus(boolean status){
    return reviewService.countReviewsByCloseStatus();
  }

  //http://localhost:9090/reviews/countByOpenStatusAndUserIdGET
  @GetMapping("reviews/countByOpenStatusAndUserId")
  public int countReviewsByOpenStatusAndUserId(boolean status, @RequestParam Integer employeeId){
    return reviewService.countReviewsByOpenStatusAndUserId(employeeId);
  }

  //http://localhost:9090/reviews/countByCloseStatusAndUserId GET
  @GetMapping("reviews/countByCloseStatusAndUserId")
  public int countReviewsByCloseStatusAndUserId(boolean status, @RequestParam Integer employeeId){
    return reviewService.countReviewsByCloseStatusAndUserId(employeeId);
  }

  //http://localhost:9090/reviews/countAllReviewsByUserId GET
  @GetMapping("reviews/countAllReviewsByUserId")
  public int countAllReviewsByUserId(@RequestParam Integer employeeId){
    return reviewService.countAllReviewsByUserId(employeeId);
  }

  //http://localhost:9090/reviews/reviewsNameLike GET
  @GetMapping("reviews/reviewsNameLike")
  public List<ReviewDto> getReviewsByName(@RequestParam String reviewName) throws ReviewNotFoundException,InvalidParameterException {
    return reviewService.findByReviewNameLike("%"+reviewName+"%");
  }

  //http://localhost:9090/reviews/reviewsStatusLike GET
  @GetMapping("reviews/reviewsStatusLike")
  public List<ReviewDto> getReviewsByStatus(@RequestParam String status) throws ReviewNotFoundException,InvalidParameterException {
    return reviewService.findByStatusLike("%"+status+"%");
  }

  //http://localhost:9090/reviews/reviewsCreatedTo GET
  @GetMapping("reviews/reviewsCreatedTo")
  public List<ReviewDto> getReviewsByCreatedTo(@RequestParam Integer createdTo) throws ReviewNotFoundException,InvalidParameterException {
    return reviewService.findByCreatedTo(createdTo);
  }

  //http://localhost:9090/reviews/reviewsCreatedDate GET
  @GetMapping("reviews/reviewsCreatedDate")
  public List<ReviewDto> getReviewsByCreatedDate(@RequestParam Date createdDate) throws ReviewNotFoundException,InvalidParameterException {
    return reviewService.findByCreatedDate(createdDate);
  }

  //http://localhost:9090/reviews/reviewsExpirationDate GET
  @GetMapping("reviews/reviewsExpirationDate")
  public List<ReviewDto> getReviewsByExpirationDate(@RequestParam Date expirationDate) throws ReviewNotFoundException,InvalidParameterException {
    return reviewService.findByExpirationDate(expirationDate);
  }

  //http://localhost:9090/reviews/filterReviews GET
  @GetMapping("reviews/filterReviews")
  public List<ReviewDto> filterAllReviews(@RequestParam (required=false) String reviewName,@RequestParam (required=false) String status, @RequestParam (required=false) Date createdDate, @RequestParam (required=false) Date expirationDate) throws ReviewNotFoundException,InvalidParameterException {
    if (reviewName==null&&status==null&&createdDate==null&&expirationDate==null) {
      throw new InvalidParameterException();
    }
    else if (reviewName!=null&&status==null&&createdDate==null&&expirationDate==null){
      return reviewService.findByReviewNameLike("%"+reviewName+"%");
    }
    else if (reviewName==null&&status!=null&&createdDate==null&&expirationDate==null){
      return reviewService.findByStatusLike("%"+status+"%");
    }
    else if (reviewName==null&&status==null&&createdDate!=null&&expirationDate==null){
      return reviewService.findByCreatedDate(createdDate);
    }
    else if (reviewName==null&&status==null&&createdDate==null&&expirationDate!=null){
      return reviewService.findByExpirationDate(expirationDate);
    }
    else if (reviewName!=null&&status!=null&&createdDate==null&&expirationDate==null){
      return reviewService.findByReviewNameLikeAndStatusLike("%"+reviewName+"%","%"+status+"%");
    }
    else if (reviewName!=null&&status==null&&createdDate==null&&expirationDate!=null)
    {
      return reviewService.findByReviewNameLikeAndExpirationDate("%"+reviewName+"%",expirationDate);
    }
    else if (reviewName!=null&&status==null&&createdDate!=null&&expirationDate==null)
    {
      return reviewService.findByReviewNameLikeAndCreatedDate("%"+reviewName+"%",createdDate);
    }
    else if (reviewName==null&&status!=null&&createdDate==null&&expirationDate!=null)
    {
      return reviewService.findByStatusLikeAndExpirationDate("%"+status+"%",expirationDate);
    }
    else if (reviewName==null&&status!=null&&createdDate!=null&&expirationDate==null)
    {
      return reviewService.findByStatusLikeAndCreatedDate("%"+status+"%",createdDate);
    }
    else if (reviewName==null&&status==null&&createdDate!=null&&expirationDate!=null)
    {
      return reviewService.findByCreatedDateAndExpirationDate(createdDate,expirationDate);
    }
    else if (reviewName!=null&&status!=null&&createdDate!=null&&expirationDate==null)
    {
      return reviewService.findByReviewNameLikeAndStatusLikeAndCreatedDate("%"+reviewName+"%","%"+status+"%",createdDate);
    }
    else if (reviewName!=null&&status!=null&&createdDate==null&&expirationDate!=null)
    {
      return reviewService.findByReviewNameLikeAndStatusLikeAndExpirationDate("%"+reviewName+"%","%"+status+"%",expirationDate);
    }
    else if (reviewName==null&&status!=null&&createdDate!=null&&expirationDate!=null)
    {
      return reviewService.findByStatusLikeAndCreatedDateAndExpirationDate("%"+status+"%",createdDate,expirationDate);
    }
    else {
      return reviewService.findByReviewNameLikeAndStatusLikeAndCreatedDateAndExpirationDate("%"+reviewName+"%", "%"+status+"%", createdDate, expirationDate);
  }
  }

}
