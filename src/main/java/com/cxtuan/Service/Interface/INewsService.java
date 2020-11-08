package com.cxtuan.Service.Interface;

import com.cxtuan.Model.Category;
import com.cxtuan.Model.News;
import com.cxtuan.Paging.Pageable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.*;
public interface INewsService {
    List<News> findAll(Pageable  pageable);
    List<News> findNewsByCategoryCode(HttpServletRequest req, HttpServletResponse res);
    List<News> findNewsById(HttpServletRequest req, HttpServletResponse res);
    News insert(News news) throws SQLException, ClassNotFoundException;
    News findOneById(int id);
    Boolean findOneAndUpdate(News news) throws SQLException;
    Boolean findOneAndDelete(News news) throws SQLException;
    long countAllDocument() throws SQLException;
    List<News>findByLimit(long offset,long rowCount);
}
