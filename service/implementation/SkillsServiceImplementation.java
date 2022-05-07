package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.exception.UserNotFoundException;
import com.employeessystem.backend.model.Skills;
import com.employeessystem.backend.repository.SkillsRepository;
import com.employeessystem.backend.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class SkillsServiceImplementation implements SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public List<Skills> getSkillsByEmployeeId(Integer employeeId) throws UserNotFoundException {
        return skillsRepository.getSkillsByEmployeeId(employeeId);
    }

    @Override
    public List<Skills> getSkills() throws CategoryNotFoundException {
        return skillsRepository.getSkills();
    }

    @Override
    public List<Skills> getSkillsByEmployee(String employee) throws UserNotFoundException, InvalidParameterException {
        return skillsRepository.getSkillsByEmployee(employee);
    }

}
