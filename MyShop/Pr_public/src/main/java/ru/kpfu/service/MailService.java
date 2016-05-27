package ru.kpfu.service;

import org.springframework.stereotype.Component;
import ru.kpfu.entities.MyUser;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Vlad.M on 11.05.2016.
 */
@Component
public class MailService {
    public void sendMail(MyUser user){
        final String username = "vlad.matyunin96@gmail.com";
        final String password = "Respon212";
        System.out.println("_________________STARTED TO SEND");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getLogin()));
            message.setSubject("Testing Subject");
            message.setText("Dear " + user.getName()+","
                    + "\n\n Your order has been added!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
