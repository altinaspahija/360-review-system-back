package com.employeessystem.backend.controller;

import com.employeessystem.backend.dto.DepartmentDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.model.DepartmentsByTitle;
import com.employeessystem.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //http://localhost:9090/departments GET
    @GetMapping("departments")
    public List<DepartmentDto> getDepartments() throws DepartmentNotFoundException {
        return departmentService.getDepartments();
    }

    //http://localhost:9090/departmentsTitles GET
    @GetMapping("departmentsTitles")
    public List<DepartmentsByTitle> getDepartmentsTitle() throws DepartmentNotFoundException {
        return departmentService.getDepartmentsTitle();
    }

}
