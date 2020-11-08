package com.cxtuan.Service.impl;

import com.cxtuan.DAO.Interface.ICategoryDAO;
import com.cxtuan.Model.Category;
import com.cxtuan.Service.Interface.ICategoryService;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category addCategory(Category category) throws IOException, SQLException, ClassNotFoundException {

            Category categoryNew=null;
            int id = categoryDAO.addCategory(category);
            categoryNew = categoryDAO.findCategoryById(id);
            return categoryNew;
    }

    @Override
    public Category findOneById(int id) {
        return categoryDAO.findCategoryById(id);
    }

}
