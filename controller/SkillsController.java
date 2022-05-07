package com.employeessystem.backend.controller;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.CategoriesByDesc;
import com.employeessystem.backend.model.Skills;
import com.employeessystem.backend.service.CategoryQuestionsService;
import com.employeessystem.backend.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    //http://localhost:9090/skillsByEmployeeId GET
    @GetMapping("skillsByEmployeeId/{employeeId}")
    public List<Skills> getSkillsByEmployeeId(@PathVariable Integer employeeId) throws UserNotFoundException {
        return skillsService.getSkillsByEmployeeId(employeeId);
    }

    //http://localhost:9090/skills GET
    @GetMapping("skills")
    public List<Skills> getSkills() throws CategoryNotFoundException{
        return skillsService.getSkills();
    }

    //http://localhost:9090/skillsByEmployee GET
    @GetMapping("skillsByEmployee")
    public List<Skills> getSkillsByEmployee(@RequestParam String employee) throws UserNotFoundException, InvalidParameterException {
        return skillsService.getSkillsByEmployee(employee);
    }

}
