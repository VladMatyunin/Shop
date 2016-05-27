package ru.kpfu.aspect.myaspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.entities.MyUser;
import ru.kpfu.service.MailService;
import ru.kpfu.service.UserService;

/**
 * Created by Vlad.M on 16.05.2016.
 */
@Aspect
public class Mailing {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Pointcut("@annotation(ru.kpfu.aspect.MailingAsp)")
    public void sendResponseMethod() {
    }

    @After("sendResponseMethod()")
    public void sendMail() {
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        mailService.sendMail(user);
    }
}
