package com.example.usermanagementsystemforatb.controller;


import com.example.usermanagementsystemforatb.entity.model.Organization;
import com.example.usermanagementsystemforatb.service.OrganizationService;
import com.example.usermanagementsystemforatb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    OrganizationService organizationService;

    @Autowired
    UserService userService;



     @PostMapping("/organization/save")
    public String signUp(@RequestBody Organization organization){
        organizationService.saveOrganizationToDb(organization);
        return userService.createdefaultAdmin(organization,"admin");
     }



}
