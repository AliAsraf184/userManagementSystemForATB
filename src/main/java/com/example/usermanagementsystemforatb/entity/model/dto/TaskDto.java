package com.example.usermanagementsystemforatb.entity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;

    private String title;

    private String description;

    private String deadline;

    private String status;
}
