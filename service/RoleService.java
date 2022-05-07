package com.employeessystem.backend.service;

import com.employeessystem.backend.dto.RoleDto;
import com.employeessystem.backend.exception.RoleNotFoundException;
import com.employeessystem.backend.model.Role;

import java.util.List;

public interface RoleService {

    List<RoleDto> getAllRoles() throws RoleNotFoundException;

}
