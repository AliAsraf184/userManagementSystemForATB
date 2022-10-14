package com.example.usermanagementsystemforatb.controller;


import com.example.usermanagementsystemforatb.repository.model.Organization;
import com.example.usermanagementsystemforatb.repository.model.Task;
import com.example.usermanagementsystemforatb.repository.model.User;
import com.example.usermanagementsystemforatb.service.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    OrganizationServiceImpl organizationService;



     @PostMapping("/organization/save")
    public String signUp(@RequestBody Organization organization){
        organizationService.saveOrganizationToDb(organization);
        return organizationService.createdefaultAdmin(organization,"admin");
     }

     @PutMapping("/organization/save/change-user-info/{userId}")
    public String changeInfo(@PathVariable(name = "userId") Long id, @RequestBody User changedUser){
         return  organizationService.changeUserInfo(id, changedUser);
     }

     @PostMapping("/manage-users/createUser")
    public void manageUsers(@RequestBody User admin , @RequestBody User user){
        organizationService.createUser(admin,user);

     }

     @PostMapping("/manage-tasks/create")
    public String manageTasks(@RequestBody User admin, @RequestBody Task task , @RequestBody List<User> users) throws MessagingException {
         return  organizationService.createTask(admin,task,users);
     }
     @PostMapping("/sendemail/{to}")
     public void sendEmailtoUser(@PathVariable(name = "to") String email) throws MessagingException {
         organizationService.sendEmail1(email);
     }
}
