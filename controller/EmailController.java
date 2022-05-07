package com.employeessystem.backend.controller;

import com.employeessystem.backend.model.ReviewInvitation;
import com.employeessystem.backend.service.implementation.EmailServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class EmailController {

    @Autowired
    private EmailServiceImplementation emailServiceImplementation;

    @PostMapping("/sendEmail/{email}")
    public ResponseEntity<?> sendEmailHtml(@RequestBody ReviewInvitation request, @PathVariable String email)
    {
        boolean result = this.emailServiceImplementation.sendEmail(request.getSubject(), request.getMessage(), request.getEmployeeId(), request.getReviewId(), email);

        if(result){
            return  ResponseEntity.ok("Email was sent successfully");

        }
        else{
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to be sent");
        }
    }

}
