package com.example.usermanagementsystemforatb.repository;


import com.example.usermanagementsystemforatb.entity.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task,Long> {

}
