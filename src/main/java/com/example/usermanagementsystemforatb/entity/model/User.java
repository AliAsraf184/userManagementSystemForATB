package com.example.usermanagementsystemforatb.entity.model;


import com.example.usermanagementsystemforatb.entity.model.Organization;
import com.example.usermanagementsystemforatb.entity.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long userId;

    private String userName;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String userType;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="organization_id")
    private Organization organization;

    @OneToMany
    @JoinTable(
            name="user_and_tasks",
            joinColumns={ @JoinColumn(name="USER_ID", referencedColumnName="user_id") },
            inverseJoinColumns={ @JoinColumn(name="TASK_ID", referencedColumnName="task_id", unique=true) }
    )
    private List<Task> task;




}
