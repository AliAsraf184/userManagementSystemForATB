package com.example.usermanagementsystemforatb.service;

import com.example.usermanagementsystemforatb.repository.model.Organization;
import com.example.usermanagementsystemforatb.repository.model.Task;
import com.example.usermanagementsystemforatb.repository.model.User;

import javax.mail.MessagingException;
import java.util.List;

public interface OrganizationService {
     void saveOrganizationToDb(Organization organization);
     String createdefaultAdmin(Organization organization, String userType);
     String changeUserInfo(Long id,User changedUser);
     void createUser(User admin,User user);
     String createTask(User admin,Task task , List<User> users) throws MessagingException;
     void sendEmail(User user, Task task,String subject) throws MessagingException;
     void sendEmail1(String email) throws MessagingException;
}
