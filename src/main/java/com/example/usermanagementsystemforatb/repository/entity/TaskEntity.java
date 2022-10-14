package com.example.usermanagementsystemforatb.repository.entity;


import com.example.usermanagementsystemforatb.repository.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;


public interface TaskEntity extends JpaRepository<Task,Long> {

}
