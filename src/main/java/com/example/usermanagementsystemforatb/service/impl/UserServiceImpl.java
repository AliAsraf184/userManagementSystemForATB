package com.example.usermanagementsystemforatb.service.impl;

import com.example.usermanagementsystemforatb.entity.model.Organization;
import com.example.usermanagementsystemforatb.entity.model.User;
import com.example.usermanagementsystemforatb.entity.model.dto.UserDto;
import com.example.usermanagementsystemforatb.repository.UserRepository;
import com.example.usermanagementsystemforatb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper= new ModelMapper();

    @Override
    public String changeUserInfo(Long id, UserDto changedUserDto) {
        String message = null;
        if (changedUserDto.getPassword().length() < 6) {
            message = "Please enter 6 or more alphanumeric characters";
        } else {
            message= "Information was updated";
            User user = userRepository.getUserByUserId(id);
            user = modelMapper.map(changedUserDto,User.class);
            userRepository.save(user);
        }
        return message;
    }

    @Override
    public void createUser(Long userId , UserDto userDto) {


           if( userRepository.getUserByUserId(userId).getUserType().equals("admin")){
           User user = modelMapper.map(userDto,User.class);
           userRepository.save(user);
        }


    }
    @Override
    public String createdefaultAdmin(Organization organization, String userType) {
        User user = new User();
        user.setOrganization(organization);
        user.setUserName("admin");
        user.setUserType(userType);
        user.setEmail("default");
        user.setPassword("admin");
        userRepository.save(user);
        String message = "Default admin user added. Please change default username, pasword and other info \n" +
                "username : " + user.getUserName() +
                "\n password : " + user.getPassword() +
                "\n email : " + user.getEmail();
        return message;
    }
}
