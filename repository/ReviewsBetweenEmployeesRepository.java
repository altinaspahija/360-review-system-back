package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.ReviewInvitation;
import com.employeessystem.backend.model.ReviewsBetweenEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsBetweenEmployeesRepository extends JpaRepository <ReviewInvitation, Integer> {

    @Query("select new com.employeessystem.backend.model.ReviewsBetweenEmployees (rein.employeeId,u.name,u.surname,re.createdTo, re.reviewName,re.createdDate,rein.completedDate) " +
            "from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId join Employee" +
            " u on u.userId=rein.employeeId where rein.employeeId=:employeeId and rein.status='Close'")
    List<ReviewsBetweenEmployees> findAllReviewsByEmployee(Integer employeeId);

    @Query("select count(*) from ReviewInvitation rein join Review re on re.reviewId = rein.reviewId join Employee" +
            " u on u.userId=rein.employeeId where rein.employeeId=:employeeId and rein.status='Close'")
    Integer countAllReviewsByEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.ReviewsBetweenEmployees (rein.employeeId,u.name,u.surname,re.createdTo, re.reviewName,re.createdDate,rein.completedDate) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId= rein.employeeId where re.createdTo =:employeeId and rein.status='Close'group by re.reviewName, re.createdDate, rein.employeeId, u.name, u.surname, re.createdTo, rein.completedDate ")
    List<ReviewsBetweenEmployees> findAllReviewsToEmployee(Integer employeeId);

    @Query("select count (*) from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId where re.createdTo =:employeeId and rein.status='Close'")
    Integer countAllReviewsToEmployee(Integer employeeId);

}
