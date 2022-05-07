package com.employeessystem.backend.repository;

import com.employeessystem.backend.dto.ReviewDto;
import com.employeessystem.backend.exception.ReviewNotFoundException;
import com.employeessystem.backend.model.EmployeesReviews;
import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

  @Query("select count(*) from Review re where re.status='Open'")
  Integer countReviewsByOpenStatus();

  @Query("select count(*) from Review re where re.status='Close'")
  Integer countReviewsByCloseStatus();

  @Query("select count(*) from Review re where re.status='Open' and re.createdTo=:employeeId")
  Integer countReviewsByOpenStatusAndUserId(Integer employeeId);

  @Query("select count(*) from Review re where re.status='Close' and re.createdTo=:employeeId")
  Integer countReviewsByCloseStatusAndUserId(Integer employeeId);

  @Query("select count(*) from Review re where re.createdTo=:employeeId")
  Integer countAllReviewsByUserId(Integer employeeId);

  List <Review> findByCreatedTo(Integer createdTo);

  List<Review> findByReviewNameLike(String reviewName);

  List<Review> findByStatusLike(String status);

  List<Review> findByCreatedDate(Date createdDate);

  List<Review> findByExpirationDate(Date expirationDate);

  List<Review> findByReviewNameLikeAndStatusLike(String reviewName, String status);

  List<Review> findByReviewNameLikeAndExpirationDate(String reviewName, Date expirationDate);

  List<Review> findByReviewNameLikeAndCreatedDate(String reviewName, Date createdDate);

  List<Review> findByStatusLikeAndExpirationDate(String status, Date expirationDate);

  List<Review> findByStatusLikeAndCreatedDate(String status, Date createdDate);

  List<Review> findByCreatedDateAndExpirationDate(Date createdDate, Date expirationDate);

  List<Review> findByReviewNameLikeAndStatusLikeAndCreatedDate(String reviewName, String status, Date createdDate);

  List<Review> findByReviewNameLikeAndStatusLikeAndExpirationDate(String reviewName, String status,Date expirationDate);

  List<Review> findByStatusLikeAndCreatedDateAndExpirationDate(String status, Date createdDate, Date expirationDate);

  List<Review> findByReviewNameLikeAndStatusLikeAndCreatedDateAndExpirationDate(String reviewName, String status, Date createdDate, Date expirationDate);

  @Query("Select re.reviewId from Review re order by re.reviewId desc")
  List<Integer> getReviewIdsDesc();

}
