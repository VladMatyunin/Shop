package ru.kpfu.repo.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyCategory;
import ru.kpfu.repo.hibernate.CategoryRepoMethods;

import java.util.List;

/**
 * Created by Vlad.M on 05.04.2016.
 */
@Repository
@Transactional
public class CategoryRepo implements CategoryRepoMethods {
    @Autowired
    SessionFactory sessionFactory;
    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addCategory(MyCategory category) {
         curSession().save(category);
    }

    public void deleteCategoryById(Long id) {

    }

    public void updateCategory(MyCategory category) {

    }

    public MyCategory getCategoryById(Long cat_id) {
        return (MyCategory) (curSession().load(MyCategory.class, cat_id));
    }
    public List<MyCategory> getAllCategories() {
        return (List<MyCategory>) curSession().createCriteria(MyCategory.class).list();
    }
}
