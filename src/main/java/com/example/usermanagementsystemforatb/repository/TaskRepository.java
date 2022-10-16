package com.example.usermanagementsystemforatb.repository;


import com.example.usermanagementsystemforatb.entity.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Long> {
}
