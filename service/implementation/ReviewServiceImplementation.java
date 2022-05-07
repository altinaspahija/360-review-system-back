package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.dto.ReviewDto;
import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.repository.ReviewRepository;
import com.employeessystem.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Override
  public ReviewDto getReviewByReviewId(Integer reviewId) throws ReviewNotFoundException {
    Optional<Review> optionalReview = reviewRepository.findById(reviewId);
    if (optionalReview.isEmpty()) throw new ReviewNotFoundException();
    Review tempReview = optionalReview.get();
    return ReviewDto.getReviewDto(tempReview);
  }

  @Override
  public List<ReviewDto> getReviews() throws ReviewNotFoundException {
    List<Review> allReviews = reviewRepository.findAll();
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (allReviews.isEmpty()) throw new ReviewNotFoundException();

    allReviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByCreatedTo(Integer createdTo) throws ReviewNotFoundException {
    List<Review> reviews = reviewRepository.findByCreatedTo(createdTo);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLike(String reviewName) throws ReviewNotFoundException {
    List<Review> reviews = reviewRepository.findByReviewNameLike(reviewName);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByStatusLike(String status) throws ReviewNotFoundException {
    List<Review> reviews = reviewRepository.findByStatusLike(status);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByCreatedDate(Date createdDate) throws ReviewNotFoundException {
    List<Review> reviews = reviewRepository.findByCreatedDate(createdDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByExpirationDate(Date expirationDate) throws ReviewNotFoundException {
    List<Review> reviews = reviewRepository.findByExpirationDate(expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLikeAndStatusLike(String reviewName, String status) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByReviewNameLikeAndStatusLike(reviewName,status);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLikeAndExpirationDate(String reviewName, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByReviewNameLikeAndExpirationDate(reviewName,expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLikeAndCreatedDate(String reviewName, Date createdDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByReviewNameLikeAndCreatedDate(reviewName,createdDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByStatusLikeAndExpirationDate(String status, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByStatusLikeAndExpirationDate(status,expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByStatusLikeAndCreatedDate(String status, Date createdDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByStatusLikeAndCreatedDate(status,createdDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByCreatedDateAndExpirationDate(Date createdDate, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByCreatedDateAndExpirationDate(createdDate,expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLikeAndStatusLikeAndCreatedDate(String reviewName, String status, Date createdDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByReviewNameLikeAndStatusLikeAndCreatedDate(reviewName,status,createdDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLikeAndStatusLikeAndExpirationDate(String reviewName, String status, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByReviewNameLikeAndStatusLikeAndExpirationDate(reviewName,status,expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByStatusLikeAndCreatedDateAndExpirationDate(String status, Date createdDate, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByStatusLikeAndCreatedDateAndExpirationDate(status,createdDate,expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
  public List<ReviewDto> findByReviewNameLikeAndStatusLikeAndCreatedDateAndExpirationDate(String reviewName, String status, Date createdDate, Date expirationDate) throws ReviewNotFoundException, InvalidParameterException {
    List<Review> reviews = reviewRepository.findByReviewNameLikeAndStatusLikeAndCreatedDateAndExpirationDate(reviewName, status,createdDate,expirationDate);
    List<ReviewDto> reviewDtos = new ArrayList<>();
    if (reviews.isEmpty()) throw new ReviewNotFoundException();

    reviews.forEach(review -> reviewDtos.add(ReviewDto.getReviewDto(review)));
    return reviewDtos;
  }

  @Override
   public Integer countReviews(){
   List<Review> reviews = reviewRepository.findAll();
   Integer count = reviews.size();
    return count;
   }

  @Override
  public Integer countReviewsByOpenStatus() {
    Integer countByOpenStatus= reviewRepository.countReviewsByOpenStatus();
    return countByOpenStatus;
  }

  @Override
  public Integer countReviewsByCloseStatus() {
    Integer countByCloseStatus= reviewRepository.countReviewsByCloseStatus();
    return countByCloseStatus;
  }

  @Override
  public Review getReview(Integer reviewId) throws ReviewNotFoundException {
    Optional<Review> optional = reviewRepository.findById(reviewId);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  @Override
  public Review createReview(Review review) {
    return reviewRepository.save(review);
  }

  @Override
  public List<Integer> getReviewIdsDesc() {
    return reviewRepository.getReviewIdsDesc();
  }

  @Override
  public Integer countReviewsByOpenStatusAndUserId(Integer employeeId) {
    return reviewRepository.countReviewsByOpenStatusAndUserId(employeeId);
  }

  @Override
  public Integer countReviewsByCloseStatusAndUserId(Integer employeeId) {
    return reviewRepository.countReviewsByCloseStatusAndUserId(employeeId);
  }

  @Override
  public Integer countAllReviewsByUserId(Integer employeeId) {
    return reviewRepository.countAllReviewsByUserId(employeeId);
  }

}
