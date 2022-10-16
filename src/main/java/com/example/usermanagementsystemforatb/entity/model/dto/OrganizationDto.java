package com.example.usermanagementsystemforatb.entity.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrganizationDto {

    private Long id;

    private String organizationName;

    private String phoneNumber;

    private String address;
}
