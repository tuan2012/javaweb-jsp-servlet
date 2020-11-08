package com.cxtuan.Service.impl;

import com.cxtuan.DAO.Interface.INewsDAO;
import com.cxtuan.Model.News;
import com.cxtuan.Paging.Pageable;
import com.cxtuan.Service.Interface.INewsService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class NewsService implements INewsService {
    @Inject
    private INewsDAO newsDAO;

    public List<News> findAll(Pageable pageable) {
        return newsDAO.findAll(pageable);
    }

    @Override
    public List<News> findNewsByCategoryCode(HttpServletRequest req, HttpServletResponse res) {
        String path=req.getPathInfo();
        String partPath[]=path.split("/");
        return newsDAO.findByCategoryCode(partPath[1]);
    }

    @Override
    public List<News> findNewsById(HttpServletRequest req, HttpServletResponse res) {
        String id=req.getParameter("id");
        return newsDAO.findNewsById(Integer.parseInt(id));
    }

    @Override
    public News insert(News news) throws SQLException, ClassNotFoundException {
        int newId=newsDAO.addNew(news);
        System.out.println("-----------------+  "+newId);
        News news1=null;
        List<News>lists=newsDAO.findNewsById(newId);
        if (lists.size() > 0) {
            news1 = lists.get(0);
        }
        return news1;
    }

    @Override
    public News findOneById(int id) {
        return newsDAO.findNewsById(id).get(0);
    }

    @Override
    public Boolean findOneAndUpdate(News news) throws SQLException {

        return newsDAO.findOneAndUpdate(news);
    }

    @Override
    public Boolean findOneAndDelete(News news) throws SQLException {
        return newsDAO.findOneAndDelete(news);
    }

    @Override
    public long countAllDocument() throws SQLException {
        return newsDAO.countALlDocument();
    }

    @Override
    public List<News> findByLimit(long offset,long rowCount) {
        return newsDAO.findByLimit(offset,rowCount);
    }
}
