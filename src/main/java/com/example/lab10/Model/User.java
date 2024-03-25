package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should be not Empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(min = 4, message = "Length must be more than 4 characters.")
    private String name;
    @NotEmpty(message = "Email should be not Empty")
    @Column(columnDefinition = "varchar(25) not null unique")
    @Email
    private String email;
    @NotNull
    private Integer password;
    @NotNull
    @Min(21)
    @Column(columnDefinition = "int not null check(age>21)")
    private Integer age;
    @NotEmpty(message = "role should be not Empty")
    @Column(columnDefinition = "varchar(20) not null check(role = 'job_seeker' or role = 'employer')")
    private String role;
}