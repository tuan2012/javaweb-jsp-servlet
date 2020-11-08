package com.cxtuan.Service.Interface;

import com.cxtuan.Model.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> findAll() throws SQLException, ClassNotFoundException;
    Category addCategory(Category category) throws IOException, SQLException, ClassNotFoundException;
    Category findOneById(int id);

}
