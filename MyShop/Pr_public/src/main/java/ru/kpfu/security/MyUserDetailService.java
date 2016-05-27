package ru.kpfu.security;

import ru.kpfu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.entities.MyUser;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MyUser userInfo = userService.getUserByLogin(login);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new MyUserDetail(userInfo);
    }

}
