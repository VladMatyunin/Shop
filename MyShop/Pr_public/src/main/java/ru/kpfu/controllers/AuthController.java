package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vlad.M on 31.03.2016.
 */
@Controller
public class AuthController {
    @Autowired
    UserService service;
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value = "/auth")
    @PreAuthorize("isAnonymous()")
    public String authorize(){
        return "authPage";
    }


}
