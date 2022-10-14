package com.example.usermanagementsystemforatb.repository.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "organization")
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long organizationId ;

    private String organizationName;

    private String phoneNumber;

    private String address;


    @OneToMany
    @JoinTable
                (
                        name="organization_and_user",
                        joinColumns={ @JoinColumn(name="ORGANIZATION_ID", referencedColumnName="organization_id") },
                        inverseJoinColumns={ @JoinColumn(name="USER_ID", referencedColumnName="user_id", unique=true) }
                )
    private List<User> userList;
}
