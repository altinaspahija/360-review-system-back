package com.employeessystem.backend.repository;


import com.employeessystem.backend.model.Position;
import com.employeessystem.backend.model.PositionByTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {

    @Query("select new com.employeessystem.backend.model.PositionByTitle(po.positionId, po.positionTitle) from Position po join Department de on de.departmentId=po.departmentId where de.departmentId=:departmentId")
    List<PositionByTitle> getPositionsTitles(Integer departmentId);

}
