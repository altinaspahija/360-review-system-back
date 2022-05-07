package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Skills;
import org.apache.catalina.User;

import java.security.InvalidParameterException;
import java.util.List;

public interface SkillsService {

    List<Skills> getSkillsByEmployeeId(Integer employeeId) throws UserNotFoundException;
    List<Skills> getSkills() throws CategoryNotFoundException;
    List<Skills> getSkillsByEmployee(String employee) throws UserNotFoundException, InvalidParameterException;

}
