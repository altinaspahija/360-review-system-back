package com.employeessystem.backend.repository;

import com.employeessystem.backend.dto.RoleDto;
import com.employeessystem.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
