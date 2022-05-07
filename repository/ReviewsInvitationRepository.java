package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.QueryHint;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ReviewsInvitationRepository extends JpaRepository<ReviewInvitation, Long> {

    @Query("select new com.employeessystem.backend.model.ReviewsParticipation(re.createdDate, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status = 'Close' and rein.status = 'Close' group by re.createdDate order by re.createdDate asc")
    List<ReviewsParticipation> findNumberOfRespondents();

    //A list is returned - In angular first element should be retrieved
    @Query(value="select new com.employeessystem.backend.model.ReviewsParticipation(re.createdDate, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status = 'Close' and rein.status = 'Close' group by re.createdDate order by re.createdDate desc")
    List<ReviewsParticipation> findNumberOfRespondentsOfRecentReview();

    @Query("Select count(*) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status= 'Close' and rein.status = 'Close'")
    Integer findOverallNumberOfRespondents();

    @Query("select new com.employeessystem.backend.model.ReviewsParticipation(re.createdDate, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId group by re.createdDate order by re.createdDate asc")
    List<ReviewsParticipation> findNumberOfInvitations();

    //A list is returned - In angular first element should be retrieved
    @Query("select new com.employeessystem.backend.model.ReviewsParticipation(re.createdDate, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId group by re.createdDate order by re.createdDate desc")
    List<ReviewsParticipation> findNumberOfRecentInvitation();

    @Query("Select count(*) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId")
    Integer findOverallNumberOfInvitations();

    @Query("select new com.employeessystem.backend.model.ReviewsParticipation (re.reviewName, re.createdDate, re.createdTo, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status = 'Close' and rein.status='Close' and re.createdTo=:employeeId group by re.reviewName, re.createdDate, re.createdTo order by re.createdDate asc")
    List<ReviewsParticipation> findNumberOfRespondentsToEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.ReviewsResponse (re.reviewName, re.createdDate, rein.employeeId, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status = 'Close' and rein.status='Close' and rein.employeeId=:employeeId group by re.reviewName, re.createdDate, rein.employeeId order by re.createdDate asc")
    List<ReviewsResponse> findNumberOfRespondsByEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.ReviewsParticipation (re.createdDate, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status = 'Close' and rein.status= 'Close' and re.createdTo=:employeeId group by re.createdDate order by re.createdDate asc")
    List<ReviewsParticipation> findReviewsNumberOfRespondentsToEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.ReviewsResponse (re.createdDate, count(rein.reviewInvitationId)) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId where re.status = 'Close' and rein.status= 'Close' and rein.employeeId=:employeeId group by re.createdDate order by re.createdDate asc")
    List<ReviewsResponse> findReviewsNumberOfRespondsByEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.ReviewsResponse (re.reviewId, rein.reviewInvitationId, re.reviewName, re.createdDate, re.expirationDate, e.name, e.surname, rein.employeeId) from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee e on e.userId = re.createdTo where rein.status = 'Open' and re.status = 'Open' and rein.employeeId=:employeeId")
    List<ReviewsResponse> getReviewInvitationsByOpenStatusAndEmployee(Integer employeeId);

    @Query("select count(rein.reviewInvitationId) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId  where re.status = 'Close' and rein.status='Close' and re.createdTo=:employeeId group by re.createdTo")
    Integer findOverallNumberOfRespondentsToEmployee(Integer employeeId);

    @Query("select count(rein.reviewInvitationId) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId  where re.status = 'Close' and rein.status='Close' and rein.employeeId=:employeeId group by rein.employeeId")
    Integer findOverallNumberOfRespondsByEmployee(Integer employeeId);

    @Transactional
    @Modifying
    @Query("update ReviewInvitation set status = :status, completedDate= :completedDate where reviewInvitationId = :reviewInvitationId")
    Integer updateReviewInvitationStatusAndDate(String status, Date completedDate, Long reviewInvitationId);

}
