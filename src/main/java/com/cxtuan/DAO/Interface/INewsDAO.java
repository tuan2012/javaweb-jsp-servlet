package com.cxtuan.DAO.Interface;
import java.sql.SQLException;
import java.util.*;
import com.cxtuan.Model.News;
import com.cxtuan.Paging.Pageable;

public interface INewsDAO  {
    List<News> findAll(Pageable pageable);
    List<News> findByCategoryCode(String code);
    List<News> findNewsById(int id);
    int addNew(News news) throws SQLException, ClassNotFoundException;
    Boolean findOneAndUpdate(News news) throws SQLException;
    Boolean findOneAndDelete(News news) throws SQLException;
    long countALlDocument() throws SQLException;
    List<News>findByLimit(long offset,long rowCount);
}
