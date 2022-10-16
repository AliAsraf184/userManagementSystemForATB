package com.example.usermanagementsystemforatb.controller;

import com.example.usermanagementsystemforatb.entity.model.User;
import com.example.usermanagementsystemforatb.entity.model.dto.UserDto;
import com.example.usermanagementsystemforatb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/manage-users/createUser")
    public void manageUsers(@RequestBody UserDto user, @RequestHeader(name = "user_id") Long userId){
        userService.createUser(userId,user);

    }
    @PutMapping("/organization/save/change-user-info")
    public String changeInfo(@RequestHeader(name = "userId") Long id, @RequestBody UserDto changedUserDto){
        return  userService.changeUserInfo(id, changedUserDto);
    }

}
