package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.Department;
import com.employeessystem.backend.model.ReviewAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewAnswerRepository extends JpaRepository<ReviewAnswer,Integer> {

    @Query("select rean from ReviewAnswer rean")
    List<ReviewAnswer> getAnswers();

}
