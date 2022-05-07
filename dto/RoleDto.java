package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Role;
import lombok.Data;

@Data
public class RoleDto {

  private int roleId;
  private String roleDescription;

  public static Role getRole(RoleDto roleDto){
    if(roleDto==null) return null;
    Role role = new Role();
    role.setRoleId(roleDto.getRoleId());
    role.setRoleDescription(roleDto.getRoleDescription());
    return role;
  }

  public static RoleDto getRoleDto(Role role){
    if(role==null) return null;
    RoleDto roleDto= new RoleDto();
    roleDto.setRoleId(role.getRoleId());
    roleDto.setRoleDescription(role.getRoleDescription());
    return roleDto;
  }

}
