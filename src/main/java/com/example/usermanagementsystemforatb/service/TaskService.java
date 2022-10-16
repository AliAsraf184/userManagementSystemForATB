package com.example.usermanagementsystemforatb.service;

import com.example.usermanagementsystemforatb.entity.model.Task;
import com.example.usermanagementsystemforatb.entity.model.User;
import com.example.usermanagementsystemforatb.entity.model.dto.TaskDto;

import javax.mail.MessagingException;
import java.util.List;

public interface TaskService {
    String createTask(Long adminId, Long UserId , TaskDto taskDto) throws MessagingException;

    //    void sendEmail(User user, Task task,String subject) throws MessagingException;
//    void sendEmail1(String email) throws MessagingException;
}
