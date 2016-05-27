package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.form.RegForm;
import ru.kpfu.service.UserService;

import javax.validation.Valid;

/**
 * Created by Vlad.M on 31.03.2016.
 */
@Controller
public class RegController {
    @Autowired
    private UserService service;
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String RegistrationPage(ModelMap map) {
        map.addAttribute("regForm", new RegForm());
        return "regpage";
    }


   @RequestMapping(value = "/reg", method = RequestMethod.POST)
   public String registrationForm(
           @Valid @ModelAttribute("regForm") RegForm form,BindingResult bindingResult, ModelMap map
//            RegistrationFormBean registrationFormBean, // TODO хотя работает и без этой аннотации, обычно её используют для переименования аргумента
           ) {
       if (bindingResult.hasErrors()) {
           System.out.println("ERROR!!!");
           return "regpage";
       }

       //map.addAttribute("session",request.getSession());
       service.add(form.makeUser());
       System.out.println("Complited!");
       return "catalog";
   }
}
