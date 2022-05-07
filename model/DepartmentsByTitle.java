package com.employeessystem.backend.model;

import lombok.Data;

@Data
public class DepartmentsByTitle {

    private String departmentTitle;

    public DepartmentsByTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

}
