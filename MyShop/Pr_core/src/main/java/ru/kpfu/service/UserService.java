package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyUser;
import ru.kpfu.repo.hibernate.UserRepoMethods;

/**
 * Created by Vlad.M on 31.03.2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepoMethods userRepository;

    @Transactional
    public void add(MyUser myUser) {
        userRepository.add(myUser);
    }

    public MyUser getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
