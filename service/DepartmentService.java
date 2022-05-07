package com.employeessystem.backend.service;

import com.employeessystem.backend.dto.DepartmentDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.model.DepartmentsByTitle;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getDepartments() throws DepartmentNotFoundException;
    List<DepartmentsByTitle> getDepartmentsTitle() throws DepartmentNotFoundException;

}
