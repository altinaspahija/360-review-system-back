package com.employeessystem.backend.service;
import com.employeessystem.backend.dto.ReviewDto;
import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.Review;
import org.springframework.data.jpa.repository.Query;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ReviewService {

  ReviewDto getReviewByReviewId(Integer ReviewId) throws ReviewNotFoundException;
  List<ReviewDto> getReviews() throws ReviewNotFoundException;
  List<ReviewDto> findByCreatedTo(Integer createdTo) throws ReviewNotFoundException;
  List<ReviewDto> findByReviewNameLike(String reviewName) throws ReviewNotFoundException;
  List<ReviewDto> findByStatusLike(String status) throws ReviewNotFoundException;
  List<ReviewDto> findByCreatedDate(Date createdDate) throws ReviewNotFoundException;
  List<ReviewDto> findByExpirationDate(Date expirationDate) throws ReviewNotFoundException;
  List<ReviewDto> findByReviewNameLikeAndStatusLike(String reviewName, String status) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByReviewNameLikeAndExpirationDate(String reviewName, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByReviewNameLikeAndCreatedDate(String reviewName, Date createdDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByStatusLikeAndExpirationDate(String status, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByStatusLikeAndCreatedDate(String status, Date createdDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByCreatedDateAndExpirationDate(Date createdDate, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByReviewNameLikeAndStatusLikeAndCreatedDate(String reviewName, String status, Date createdDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByReviewNameLikeAndStatusLikeAndExpirationDate(String reviewName, String status,Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByStatusLikeAndCreatedDateAndExpirationDate(String status, Date createdDate, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
  List<ReviewDto> findByReviewNameLikeAndStatusLikeAndCreatedDateAndExpirationDate(String reviewName, String status, Date createdDate, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException;
  Integer countReviews();
  Integer countReviewsByOpenStatus();
  Integer countReviewsByCloseStatus();
  Review getReview(Integer reviewId) throws ReviewNotFoundException;
  Review createReview(Review review);
  List<Integer> getReviewIdsDesc() throws ReviewNotFoundException;
  Integer countReviewsByOpenStatusAndUserId(Integer employeeId);
  Integer countReviewsByCloseStatusAndUserId(Integer employeeId);
  Integer countAllReviewsByUserId(Integer employeeId);

}
