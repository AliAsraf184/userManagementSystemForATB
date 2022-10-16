package com.example.usermanagementsystemforatb.entity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    private String title;

    private String description;

    private String deadline;

    private String status;


    @ManyToOne
    @JoinColumn(name="task_id1")
    private User user;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="organization_id1")
    private Organization organization;








}
