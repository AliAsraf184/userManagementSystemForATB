package com.example.usermanagementsystemforatb.service;

import com.example.usermanagementsystemforatb.entity.model.Organization;
import com.example.usermanagementsystemforatb.entity.model.User;
import com.example.usermanagementsystemforatb.entity.model.dto.UserDto;

public interface UserService {
    String changeUserInfo(Long id, UserDto changedUserDto);
    void createUser(Long userId, UserDto userDto);
    String createdefaultAdmin(Organization organization, String userType);

}
