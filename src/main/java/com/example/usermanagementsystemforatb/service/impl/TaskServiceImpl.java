package com.example.usermanagementsystemforatb.service.impl;


import com.example.usermanagementsystemforatb.entity.model.Task;
import com.example.usermanagementsystemforatb.entity.model.User;
import com.example.usermanagementsystemforatb.entity.model.dto.TaskDto;
import com.example.usermanagementsystemforatb.repository.TaskRepository;
import com.example.usermanagementsystemforatb.repository.UserRepository;
import com.example.usermanagementsystemforatb.service.TaskService;
import com.sun.media.sound.ModelMappedInstrument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper;


    // mentiqi problem
    @Override
    public String createTask(Long adminId ,Long userId, TaskDto taskDto) throws MessagingException { //admin , users den id gotur
        String message = null;
        User admin = userRepository.getUserByUserId(adminId);
        if(admin.getUserType().equals("admin")){
            Task newTask = new Task();
                taskRepository.save(newTask);
                message="Task was created";
             //   sendEmail(users.get(i),task,"Task created");
            }
        else message="Only admins can create tasks";

        return message;
    }

//    @Override
//    public void sendEmail(User user, Task task, String subject) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(message, true);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        //getorganization for name
//        Organization organization=organizationEntity.getOrganizationByOrganizationId(task.getOrganizationId());
//        helper.setFrom(organization.getOrganizationName());
//        helper.setTo(user.getEmail());
//        helper.setSubject(subject);
//        helper.setText(task.toString());
//
//        emailSender.send(message);
//    }
//
//    public void sendEmail1(String email) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper= new MimeMessageHelper(message, true);
//        helper.setTo(email);
//        helper.setSubject("privet Vsem");
//        emailSender.send(message);
//    }
}
