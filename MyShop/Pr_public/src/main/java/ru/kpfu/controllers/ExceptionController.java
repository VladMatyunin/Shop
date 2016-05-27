package ru.kpfu.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.exception.NotFoundException;

/**
 * Created by Vlad.M on 05.04.2016.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleCustomException(NotFoundException ex) {
        ModelAndView model = new ModelAndView("staticExceptionView");
        model.addObject("errCode", "NOT FOUND");
        return model;

    }
}
