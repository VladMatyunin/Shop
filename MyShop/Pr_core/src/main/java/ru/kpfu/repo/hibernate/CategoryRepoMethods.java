package ru.kpfu.repo.hibernate;

import ru.kpfu.entities.MyCategory;

import java.util.List;

/**
 * Created by Vlad.M on 05.04.2016.
 */
public interface CategoryRepoMethods {
    void addCategory(MyCategory category);
    void deleteCategoryById(Long id);
    void updateCategory(MyCategory category);
    MyCategory getCategoryById(Long id);
    List<MyCategory> getAllCategories();
}
