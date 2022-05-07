package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.EmployeesReviewsRatings;
import com.employeessystem.backend.model.ReviewInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeesReviewsRatingsRepository extends JpaRepository<ReviewInvitation,Integer> {

    @Query("select new com.employeessystem.backend.model.EmployeesReviewsRatings(rein.employeeId,u.name,u.surname,re.createdTo, re.reviewName,re.createdDate,rein.completedDate, avg(rean.answer)) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId = rein.employeeId join ReviewAnswer rean on rean.employeeId = u.userId where re.createdTo =:employeeId and rein.status='Close' group by re.reviewName, re.createdDate, rein.employeeId, u.name, u.surname, re.createdTo, rein.completedDate order by re.createdDate")
    List<EmployeesReviewsRatings> findAverageRatingsToEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.EmployeesReviewsRatings(re.createdDate, avg(rean.answer)) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId = rein.employeeId join ReviewAnswer rean on rean.employeeId = u.userId where re.createdTo =:employeeId and rein.status='Close' group by re.createdDate order by re.createdDate asc")
    List<EmployeesReviewsRatings> findReviewsAverageRatingsToEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.EmployeesReviewsRatings(rein.employeeId,u.name,u.surname,re.createdTo, re.reviewName,re.createdDate,rein.completedDate, avg(rean.answer)) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId = rein.employeeId join ReviewAnswer  rean on rean.employeeId = u.userId where rein.employeeId =:employeeId and rein.status='Close' group by re.reviewName, re.createdDate, rein.employeeId, u.name, u.surname, re.createdTo, rein.completedDate order by re.createdDate")
    List<EmployeesReviewsRatings> findAverageRatingsByEmployee(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.EmployeesReviewsRatings(re.createdDate, avg(rean.answer)) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId = rein.employeeId join ReviewAnswer rean on rean.employeeId = u.userId where rein.employeeId =:employeeId and rein.status='Close' group by re.createdDate order by re.createdDate asc")
    List<EmployeesReviewsRatings> findReviewsAverageRatingsByEmployee(Integer employeeId);

    @Query("select avg(rean.answer) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId = rein.employeeId join ReviewAnswer  rean on rean.employeeId = u.userId where re.createdTo =:employeeId and rein.status='Close' group by re.createdTo")
    Double findAverageOverallRatingToEmployee(Integer employeeId);

    @Query("select avg(rean.answer) " +
            "from Review re join ReviewInvitation rein on rein.reviewId = re.reviewId join Employee u on u.userId = rein.employeeId join ReviewAnswer  rean on rean.employeeId = u.userId where rean.employeeId =:employeeId and rein.status='Close' group by rean.employeeId")
    Double findAverageOverallRatingByEmployee(Integer employeeId);

}
