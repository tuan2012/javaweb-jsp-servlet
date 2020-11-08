package com.cxtuan.Mapper;

import com.cxtuan.Model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements IMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs) throws SQLException {
        Category category=new Category(rs.getString("name"),rs.getString("code"));
        category.setId(rs.getInt("id"));
        return category;
    }
}
