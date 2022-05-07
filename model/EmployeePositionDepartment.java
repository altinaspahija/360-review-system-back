package com.employeessystem.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeePositionDepartment {

    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Date startDate;
    private String profileImage;
    private String positionTitle;
    private String departmentTitle;

    public EmployeePositionDepartment(Integer userId, String name, String surname, String email, String phoneNumber, Date startDate, String profileImage, String positionTitle, String departmentTitle) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.profileImage = profileImage;
        this.positionTitle = positionTitle;
        this.departmentTitle = departmentTitle;
    }

    public EmployeePositionDepartment(){

    }

}

