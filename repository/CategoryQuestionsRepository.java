package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.CategoriesByDesc;
import com.employeessystem.backend.model.CategoryQuestions;
import com.employeessystem.backend.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryQuestionsRepository extends JpaRepository<CategoryQuestions,Integer> {

    @Query("select new com.employeessystem.backend.model.CategoriesByDesc(ca.categoryDescription) from CategoryQuestions ca")
    List<CategoriesByDesc> getCategories();

    @Query("select new com.employeessystem.backend.model.CategoriesByDesc(ca.categoryDescription,q.question) from CategoryQuestions ca join Question q on q.categoryId=ca.categoryId")
    List<CategoriesByDesc> getCategoriesAndQuestions();

    @Query("select new com.employeessystem.backend.model.CategoriesByDesc(ca.categoryDescription,q.question) from CategoryQuestions ca join Question q on q.categoryId=ca.categoryId where ca.categoryDescription=:categoryDescription")
    List<CategoriesByDesc> getCategoriesAndQuestionsByCategory(String categoryDescription);

    @Query("select new com.employeessystem.backend.model.CategoriesByDesc(ca.categoryDescription,q.question,q.questionId) from CategoryQuestions ca join Question q on q.categoryId=ca.categoryId where ca.categoryDescription=:categoryDescription")
    List<CategoriesByDesc> getCategoriesAndQuestionsDetailsByCategory(String categoryDescription);

    @Query("select new com.employeessystem.backend.model.Goals (re.createdDate,re.createdTo,ca.categoryDescription,avg(rean.answer)) from Review re " +
            "join ReviewQuestionDetails requ on requ.reviewId = re.reviewId join ReviewAnswer  rean on rean.reviewQuestionId = requ.reviewQuestionId join ReviewInvitation rein on rein.reviewId" +
            "=re.reviewId join Question q on q.questionId = requ.questionId join CategoryQuestions ca on ca.categoryId=q.categoryId where re.createdTo=:employeeId and ca.categoryDescription=:categoryTitle and rein.status='Close' and re.status='Close'" +
            "group by re.createdDate,re.createdTo,ca.categoryDescription order by re.createdDate asc")
    List<Goals> getRatingsByEmployeeAndCategory(Integer employeeId, String categoryTitle);

}
