package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.RatingScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingScaleRepository extends JpaRepository<RatingScale,Integer> {

   @Query("select rese from RatingScale rese")
   List<RatingScale> getRatingScales();

}
