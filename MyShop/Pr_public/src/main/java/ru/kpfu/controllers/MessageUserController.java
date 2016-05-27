package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vlad.M on 04.04.2016.
 */
@Controller
public class MessageUserController {
    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private HttpServletRequest request;


    /**
     * MessageSource could be used but MessageSourceAccessor is more convinient.
     */
    private MessageSourceAccessor msa;

    @Autowired
    private void setMessageSourceAccessor(MessageSource ms){
        this.msa = new MessageSourceAccessor(ms);
    }

    @RequestMapping("/mestest")
    public String index(ModelMap map){
        map.put("message0", this.msa.getMessage("controller.message"));
        map.put("message1", this.msa.getMessage("controller.param.message", new Double[]{9.78}));
        return "MessageTest";
    }

    @RequestMapping("/change")
    public String change(@RequestParam String locale){
        // Check here for param format
        String[] localeData = locale.split("_");
        //localeResolver.setLocale(request, new Locale(localeData[0], localeData[1]));
        return "redirect:/" ;//+ MvcUriComponentsBuilder.fromMappingName("DC#mestest").build();
    }
}
