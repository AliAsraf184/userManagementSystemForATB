package com.example.usermanagementsystemforatb.controller;

import com.example.usermanagementsystemforatb.entity.model.Task;
import com.example.usermanagementsystemforatb.entity.model.User;
import com.example.usermanagementsystemforatb.entity.model.dto.TaskDto;
import com.example.usermanagementsystemforatb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.mail.MessagingException;
import java.util.List;

public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/manage-tasks/create")
    public String manageTasks(@RequestHeader Long adminId, @RequestHeader Long userId , @RequestBody TaskDto taskDto) throws MessagingException {
        return  taskService.createTask(adminId,userId,taskDto);
    }

//    @PostMapping("/sendemail/{to}")
//    public void sendEmailtoUserAboutTask(@PathVariable(name = "to") String email) throws MessagingException {
//        taskService.sendEmail1(email);
//    }
}
