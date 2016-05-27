package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyCategory;
import ru.kpfu.repo.hibernate.CategoryRepoMethods;

import java.util.List;

/**
 * Created by Vlad.M on 05.04.2016.
 */
@Service
public class CategoryService {
    @Autowired
    CategoryRepoMethods repo;

    public void addCategory(MyCategory category){
        repo.addCategory(category);
        return;
    }

    public void deleteCategory(Long cat_id){
        repo.deleteCategoryById(cat_id);
        return;
    }
    public void updateCategory(MyCategory category){
        repo.updateCategory(category);
        return;
    }
    @Transactional
    public MyCategory getCategory(Long cat_id){
        return repo.getCategoryById(cat_id);
    }
    @Transactional
    public List<MyCategory> getAllCategories(){
        return repo.getAllCategories();
    }
}
