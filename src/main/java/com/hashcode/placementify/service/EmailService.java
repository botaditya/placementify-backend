package com.hashcode.placementify.service;

import com.hashcode.placementify.model.EmailMessage;
import com.hashcode.placementify.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSuccessfulRegistrationEmail(Student student) {
        System.out.println("Sending Email for successful registration...");
        try {
            EmailMessage emailMessage = new EmailMessage();
            emailMessage.setSubjectText("Placementify | Student registration successful");
            emailMessage.setEmailBody("Hello "+student.getNameBySSC()+"\n\nWelcome to Placementify! You are now successfully registered with Placementify.\n" +
                    "\nYour application details are mentioned below : \n" +
                    "\nName: " + student.getNameBySSC() +
                    "\nEmail: "+ student.getEmailId() +
                    "\nPhone Number: " + student.getPhoneNumber() +
                    "\nApplication Id: "+ student.getApplicationId() +
                    "\n\n\n"+
                    "\nPlacementify is a system that comprises automation of manual activities in the Training and Placement Cell of DYPIMR." +
                    "\n\n\n\nNote: This is a system generated email and the System is under development. Please do not reply to this mail. The data provided by you is solely your responsibility.");
            emailMessage.setRecipientEmail(student.getEmailId());
            sendEmail(emailMessage);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sent");
    }


    void sendEmail(EmailMessage emailMessage) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailMessage.getRecipientEmail());
        msg.setBcc("pixelcoder24@gmail.com","sawantsayali1999@gmail.com");

        msg.setSubject(emailMessage.getSubjectText());

        msg.setText(emailMessage.getEmailBody());

        javaMailSender.send(msg);
    }
}
