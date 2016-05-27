package ru.kpfu.repo.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyUser;
import ru.kpfu.repo.hibernate.UserRepoMethods;

/**
 * Created by Vlad.M on 31.03.2016.
 */
@Repository
@Transactional
public class UserRepo implements UserRepoMethods{
    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }


    public void add(MyUser myUser) {
        curSession().save(myUser);
    }


    public MyUser getUserByLogin(String login) {
        return (MyUser) curSession().createCriteria(MyUser.class)
                .add(Restrictions.eq("mail", login)).uniqueResult();
    }
}
