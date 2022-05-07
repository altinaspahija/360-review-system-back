package com.employeessystem.backend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.security.SecureRandom;
import java.sql.Date;

@Data
@Entity
@Table(name="users")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="user_id", insertable = true)
    private Integer userId;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="position_id")
    private Integer positionId;

    @Column(name="role_id")
    private Integer roleId;

    @Column(name="profile_image", nullable = true)
    private String profileImage;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", insertable=false ,updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Position position;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable=false ,updatable = false)
    private Role role;

}
