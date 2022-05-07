package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.Review;
import com.employeessystem.backend.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SkillsRepository extends JpaRepository<Review,Integer> {

    @Query("select new com.employeessystem.backend.model.Skills(re.reviewName,re.createdTo,u.name,u.surname,re.createdDate,ca.categoryDescription,avg(rean.answer))" +
            "from Review re join ReviewQuestionDetails requ on requ.reviewId = re.reviewId join ReviewAnswer rean on rean.reviewQuestionId = requ.reviewQuestionId join " +
            "ReviewInvitation rein on rein.reviewId = re.reviewId join Question q on q.questionId=requ.questionId join CategoryQuestions ca on ca.categoryId=q.categoryId join " +
            "Employee u on u.userId=re.createdTo where re.createdTo=:employeeId and rein.status='Close' and re.status='Close' and re.status = 'Close' group by re.reviewName,re.createdTo, u.name, u.surname, re.createdDate, ca.categoryDescription order by re.createdDate desc")
    List<Skills> getSkillsByEmployeeId(Integer employeeId);

    @Query("select new com.employeessystem.backend.model.Skills(re.reviewName,re.createdTo,u.name,u.surname,re.createdDate,ca.categoryDescription,avg(rean.answer))" +
            "from Review re join ReviewQuestionDetails requ on requ.reviewId = re.reviewId join ReviewAnswer rean on rean.reviewQuestionId = requ.reviewQuestionId join " +
            "ReviewInvitation rein on rein.reviewId = re.reviewId join Question q on q.questionId=requ.questionId join CategoryQuestions ca on ca.categoryId=q.categoryId join " +
            "Employee u on u.userId=re.createdTo where rein.status='Close' and re.status='Close' and re.status = 'Close' group by re.reviewName,re.createdTo, u.name, u.surname, re.createdDate, ca.categoryDescription order by re.createdDate desc")
    List<Skills> getSkills();

    @Query("select new com.employeessystem.backend.model.Skills(re.reviewName,re.createdTo,u.name,u.surname,re.createdDate,ca.categoryDescription,avg(rean.answer))" +
            "from Review re join ReviewQuestionDetails requ on requ.reviewId = re.reviewId join ReviewAnswer rean on rean.reviewQuestionId = requ.reviewQuestionId join " +
            "ReviewInvitation rein on rein.reviewId = re.reviewId join Question q on q.questionId=requ.questionId join CategoryQuestions ca on ca.categoryId=q.categoryId join " +
            "Employee u on u.userId=re.createdTo where ((concat(u.name, ' ' ,u.surname)) like %:employee%) and rein.status='Close' and re.status='Close' and re.status = 'Close' group by re.reviewName,re.createdTo, u.name, u.surname, re.createdDate, ca.categoryDescription order by re.createdDate desc")
    List<Skills> getSkillsByEmployee(String employee);

}
