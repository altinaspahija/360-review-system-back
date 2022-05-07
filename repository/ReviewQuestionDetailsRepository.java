package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.FillReview;
import com.employeessystem.backend.model.ReviewQuestionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.employeessystem.backend.model.ReviewQuestionDetailsById;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReviewQuestionDetailsRepository extends JpaRepository<ReviewQuestionDetails,Integer> {

    @Query(value = "Insert into ReviewQuestionDetails values (:reviewId, :questionId)",nativeQuery = true)
    Object postAllReviewQuestionDetailsByIds(Integer reviewId, Integer questionId);

    @Query("select new com.employeessystem.backend.model.FillReview (rein.reviewInvitationId, e.userId, e.name, e.surname, re.reviewName, requde.reviewQuestionId, re.reviewId, requde.questionId, qu.question, qu.categoryId, c.categoryDescription) from ReviewQuestionDetails requde join Question qu on qu.questionId = requde.questionId join CategoryQuestions c on c.categoryId = qu.categoryId join Review re on re.reviewId = requde.reviewId join Employee e on e.userId=re.createdTo join ReviewInvitation rein on rein.reviewId = re.reviewId where re.reviewId=:reviewId and c.categoryDescription=:categoryDescription")
    List<FillReview> getFillDataDetails(Integer reviewId, String categoryDescription);

    @Query("select new com.employeessystem.backend.model.FillReview (rein.reviewInvitationId, e.userId, e.name, e.surname, re.reviewName, requde.reviewQuestionId, re.reviewId, requde.questionId, qu.question, qu.categoryId, c.categoryDescription) from ReviewQuestionDetails requde join Question qu on qu.questionId = requde.questionId join CategoryQuestions c on c.categoryId = qu.categoryId join Review re on re.reviewId = requde.reviewId join Employee e on e.userId=re.createdTo join ReviewInvitation rein on rein.reviewId = re.reviewId where re.reviewId=:reviewId")
    List<FillReview> getAllFillDataDetails(Integer reviewId);

    @Query("select new com.employeessystem.backend.model.FillReview (rein.reviewInvitationId, e.userId, e.name, e.surname, re.reviewName, requde.reviewQuestionId, re.reviewId, requde.questionId, qu.question, qu.categoryId, c.categoryDescription) from ReviewQuestionDetails requde join Question qu on qu.questionId = requde.questionId join CategoryQuestions c on c.categoryId = qu.categoryId join Review re on re.reviewId = requde.reviewId join Employee e on e.userId=re.createdTo join ReviewInvitation rein on rein.reviewId = re.reviewId where re.reviewId=:reviewId and rein.employeeId=:employeeId")
    List<FillReview> getAllFillDataDetailsByReviewIdAndToEmployeeId(Integer reviewId, Integer employeeId);

    @Query("select requde from ReviewQuestionDetails requde where requde.reviewId=:reviewId and requde.questionId=:questionId")
    ReviewQuestionDetails getReviewQuestionByIds(Integer reviewId, Integer questionId);

}
