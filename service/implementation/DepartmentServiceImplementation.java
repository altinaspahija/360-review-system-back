package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.dto.DepartmentDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.model.Department;
import com.employeessystem.backend.model.DepartmentsByTitle;
import com.employeessystem.backend.repository.DepartmentRepository;
import com.employeessystem.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> getDepartments() throws DepartmentNotFoundException {
        List<Department> allDepartments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        if (allDepartments.isEmpty()) throw new DepartmentNotFoundException();

        allDepartments.forEach(department -> departmentDtos.add(DepartmentDto.getDepartmentDto(department)));
        return departmentDtos;
    }

    @Override
    public List<DepartmentsByTitle> getDepartmentsTitle() throws DepartmentNotFoundException {
     return departmentRepository.getDepartmentsTitles();
    }

}
