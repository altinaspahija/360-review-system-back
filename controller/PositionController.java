package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.model.DepartmentsByTitle;
import com.employeessystem.backend.model.PositionByTitle;
import com.employeessystem.backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PositionController {

    @Autowired
    PositionService positionService;

    //http://localhost:9090/positionsTitles GET
    @GetMapping("positionsTitles/{departmentId}")
    public List<PositionByTitle> getPositionsTitles(@PathVariable Integer departmentId) throws DepartmentNotFoundException {
        return positionService.getPositionsTitles(departmentId);
    }

}
