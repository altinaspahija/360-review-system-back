package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.dto.DepartmentDto;
import com.employeessystem.backend.dto.RoleDto;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.RoleNotFoundException;
import com.employeessystem.backend.model.Department;
import com.employeessystem.backend.model.Employee;
import com.employeessystem.backend.model.Role;
import com.employeessystem.backend.repository.RoleRepository;
import com.employeessystem.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDto> getAllRoles() throws RoleNotFoundException {
        List<Role> allRoles = roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        if(allRoles.isEmpty()) throw new RoleNotFoundException();

        allRoles.forEach(role-> roleDtos.add(RoleDto.getRoleDto(role)));
        return roleDtos;
    }

}
