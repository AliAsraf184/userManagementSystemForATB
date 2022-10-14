package com.example.usermanagementsystemforatb.service;

import com.example.usermanagementsystemforatb.repository.entity.OrganizationEntity;
import com.example.usermanagementsystemforatb.repository.entity.TaskEntity;
import com.example.usermanagementsystemforatb.repository.entity.UserEntity;
import com.example.usermanagementsystemforatb.repository.model.Organization;
import com.example.usermanagementsystemforatb.repository.model.Task;
import com.example.usermanagementsystemforatb.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;


@Service
public class OrganizationServiceImpl  implements  OrganizationService {

    @Autowired
    OrganizationEntity organizationEntity;
    @Autowired
    UserEntity userEntity;
    @Autowired
    TaskEntity taskEntity;


    JavaMailSender emailSender= new JavaMailSenderImpl();


    @Override
    public void saveOrganizationToDb(Organization organization) {

        organizationEntity.save(organization);

    }

    @Override
    public String createdefaultAdmin(Organization organization, String userType) {
        User user = new User();
        user.setOrganization(organization);
        user.setUserName("admin");
        user.setUserType(userType);
        user.setEmail("default");
        user.setPassword("admin");
        userEntity.save(user);
        String message = "Default admin user added. Please change default username, pasword and other info \n" +
                "username : " + user.getUserName() +
                "\n password : " + user.getPassword() +
                "\n email : " + user.getEmail();
        return message;
    }

    @Override
    public String changeUserInfo(Long id, User changedUser) {
        String message = null;
        if (changedUser.getPassword().length() < 6) {
            message = "Please enter 6 or more alphanumeric characters";
        } else {
            message= "Information was updated";
            User user = userEntity.getUserByUserId(id);
            user.setUserName(changedUser.getUserName());
            user.setEmail(changedUser.getEmail());
            user.setPassword(changedUser.getPassword());
            userEntity.save(user);
        }
        return message;
    }

    @Override
    public void createUser(User admin ,User user) {
        if(admin.getUserType().equals("admin")){
        User newUser= new User();
        newUser.setOrganization(admin.getOrganization());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setUserType("user");
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        userEntity.save(newUser);
        }
    }

    @Override
    public String createTask(User admin ,Task task, List<User> users) throws MessagingException {
        String message = null;
        if(admin.getUserType().equals("admin")){
        Task newTask = new Task();
        for (int i = 0; i < users.size(); i++) {
            newTask.setOrganizationId(String.valueOf(users.get(i).getOrganization().getOrganizationId()));
            newTask.setDeadline(task.getDeadline());
            newTask.setStatus(task.getStatus());
            newTask.setDescription(task.getDescription());
            newTask.setTitle(task.getTitle());
            taskEntity.save(newTask);
            message="Task was created";
            sendEmail(users.get(i),task,"Task created");
        }
    } else message="Only admins can create tasks";

        return message;
    }

    @Override
    public void sendEmail(User user, Task task, String subject) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
         //getorganization for name
        Organization organization=organizationEntity.getOrganizationByOrganizationId(task.getOrganizationId());
        helper.setFrom(organization.getOrganizationName());
        helper.setTo(user.getEmail());
        helper.setSubject(subject);
        helper.setText(task.toString());

        emailSender.send(message);
    }

    public void sendEmail1(String email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject("privet Vsem");
        emailSender.send(message);
    }
}