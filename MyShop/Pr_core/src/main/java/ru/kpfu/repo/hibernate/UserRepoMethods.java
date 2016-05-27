package ru.kpfu.repo.hibernate;

import ru.kpfu.entities.MyUser;

/**
 * Created by Vlad.M on 31.03.2016.
 */
public interface UserRepoMethods {
    void add(MyUser myUser);
    MyUser getUserByLogin(String login);
}
