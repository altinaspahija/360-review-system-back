package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.model.ReviewInvitation;
import com.employeessystem.backend.repository.ReviewsInvitationRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Optional;
import java.util.Properties;



@Service
public class EmailServiceImplementation {

    @Autowired
    ReviewsInvitationRepository reviewsInvitationRepository;

    public boolean sendEmail(String subject, String message, Integer employeeId, Integer reviewId, String email)
    {
        boolean foo = false;

        String senderEmail = ""; // your gmail email id
        String senderPassword = ""; // your gmail id password

        //Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        // Setup host and mail server
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            MimeMessageHelper helper = new MimeMessageHelper(msg, true); // create MimeMessageHelper class

            helper.setFrom(new InternetAddress(senderEmail)); // adding sender email id to helper object

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); //adding recipient to msg object

            helper.setSubject(subject); // adding subject to helper object

            MimeMultipart mimeMultipart = new MimeMultipart(); // create MimeMultipart object

            MimeBodyPart textMime = new MimeBodyPart(); // create first MimeBodyPart object textMime for containing the message

            MimeBodyPart messageBodyPart = new MimeBodyPart(); // create second MimeBodyPart object messageBodyPart for containing the html format data

            textMime.setText(message); // sets message to textMime object

            // create message within html format tag and assign to the content variable
            String content = "<br><br><a href='http://localhost:4200/fillReview/" + reviewId + "/" + employeeId + "'><button style='background-color:SteelBlue; color:white'>Give review</button></a>";

            // sets html format content to the messageBodyPart object
            messageBodyPart.setContent(content,"text/html; charset=utf-8");

            //The mimeMultipart adds textMime and messageBodypart to the
            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(messageBodyPart);

            msg.setContent(mimeMultipart); // Set the mimeMultipart the contents of the msg

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email was sent successfully");

            foo = true; // Set the "foo" variable to true after successfully sending emails

        }catch(Exception e){
            System.out.println("EmailService File Error"+ e);
        }
        return foo; //and return foo variable
    }

}
