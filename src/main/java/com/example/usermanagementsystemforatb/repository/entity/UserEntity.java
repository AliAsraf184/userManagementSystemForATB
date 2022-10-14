package com.example.usermanagementsystemforatb.repository.entity;

import com.example.usermanagementsystemforatb.repository.model.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntity extends JpaRepository<User,Long> {

    User getUserByUserId(Long id);

}
