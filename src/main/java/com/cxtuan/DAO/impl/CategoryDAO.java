package com.cxtuan.DAO.impl;

import com.cxtuan.DAO.Interface.ICategoryDAO;
import com.cxtuan.Mapper.CategoryMapper;
import com.cxtuan.Mapper.NewsMapper;
import com.cxtuan.Model.Category;
import com.cxtuan.Model.News;

import java.sql.SQLException;
import java.util.List;

public class CategoryDAO extends ParentDAO<Category> implements ICategoryDAO  {
    @Override
    public List<Category> findAll() {
        return findByParams("select*from category",new CategoryMapper());
    }

    @Override
    public int addCategory(Category category) throws SQLException, ClassNotFoundException {

       return insert("insert into category(name,code) values (?,?)",category.getName(),category.getCode());

    }

    @Override
    public Category findCategoryById(int id) {
        return findByParams("select* from category where id=?",new CategoryMapper(),id).get(0);
    }
}
