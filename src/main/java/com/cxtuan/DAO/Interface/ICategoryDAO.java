package com.cxtuan.DAO.Interface;

import com.cxtuan.Model.Category;
import com.cxtuan.Model.News;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO  {
    List<Category> findAll();
    int addCategory(Category category) throws SQLException, ClassNotFoundException;
    Category findCategoryById(int id);
}
