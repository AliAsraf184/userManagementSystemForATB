package com.example.usermanagementsystemforatb.repository;

import com.example.usermanagementsystemforatb.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    User getUserByUserId(Long id);



}
