package com.example.usermanagementsystemforatb.entity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String userName;

    private String name;

    private String surname;

    private String email;

    private String password;
}
