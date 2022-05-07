package com.employeessystem.backend.repository;

import com.employeessystem.backend.model.Department;
import com.employeessystem.backend.model.DepartmentsByTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @Query("select new com.employeessystem.backend.model.DepartmentsByTitle(d.departmentTitle) from Department d where d.departmentTitle <> 'HR'")
    List<DepartmentsByTitle> getDepartmentsTitles();

}
