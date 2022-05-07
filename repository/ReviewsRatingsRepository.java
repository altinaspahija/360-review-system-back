package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.ReviewQuestionDetails;
import com.employeessystem.backend.model.ReviewsRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRatingsRepository extends JpaRepository<ReviewQuestionDetails,Integer> {

    @Query("select new com.employeessystem.backend.model.ReviewsRatings(requde.reviewId, re.reviewName,us.name, us.surname, re.createdDate, avg(rean.answer)) from ReviewQuestionDetails requde join ReviewAnswer rean on rean.reviewQuestionId = requde.reviewQuestionId join Employee us on us.userId = rean.employeeId join Review re on re.reviewId = requde.reviewId group by requde.reviewId, re.createdDate, re.reviewName, us.name,us.surname order by avg(rean.answer) desc")
    List<ReviewsRatings> findTopRatingReviews();

    @Query("select new com.employeessystem.backend.model.ReviewsRatings(requde.reviewId, re.reviewName,us.name, us.surname, re.createdDate, avg(rean.answer)) from ReviewQuestionDetails requde join ReviewAnswer rean on rean.reviewQuestionId = requde.reviewQuestionId join Employee us on us.userId = rean.employeeId join Review re on re.reviewId = requde.reviewId group by requde.reviewId, re.createdDate, re.reviewName, us.name,us.surname order by re.createdDate desc, avg(rean.answer) desc")
    List<ReviewsRatings> findTopRatingRecentReviews();

    @Query("select new com.employeessystem.backend.model.ReviewsRatings(re.createdDate, avg(rean.answer)) from ReviewQuestionDetails requde join ReviewAnswer rean on rean.reviewQuestionId = requde.reviewQuestionId join Review re on re.reviewId = requde.reviewId group by re.createdDate order by re.createdDate asc")
    List<ReviewsRatings> findAverageReviewsRating();

    @Query("select avg(rean.answer) from ReviewQuestionDetails requde join ReviewAnswer rean on rean.reviewQuestionId = requde.reviewQuestionId join Review re on re.reviewId = requde.reviewId")
    Double findAverageOverallRating();

}
