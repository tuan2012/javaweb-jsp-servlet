package com.cxtuan.Controller.admin.api;

import com.cxtuan.Model.Category;
import com.cxtuan.Model.News;
import com.cxtuan.Model.User;
import com.cxtuan.Service.Interface.ICategoryService;
import com.cxtuan.Service.Interface.INewsService;
import com.cxtuan.Utils.ConvertJson;
import com.cxtuan.Utils.SessionUtils;
import com.cxtuan.contant.contant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.*;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsApi extends HttpServlet {
    @Inject
    private INewsService newsService;
    @Inject
    private ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        SessionUtils sessionUtils=SessionUtils.getInstance();
        //Lay mang du lieu json
        List<News> result=new ArrayList<>();
        ConvertJson convertJson =ConvertJson.convert(req.getReader());

        List<News> listNews=new ObjectMapper().readValue(convertJson.getJson(),new TypeReference<List<News>>(){});

        System.out.println(listNews.size());
        try {
            for(News news:listNews) {
                news.setCreateDate(new Timestamp(new Date().getTime()));
                news.setModifiedDate(new Timestamp(new Date().getTime()));
                news.setCreateBy(((User)sessionUtils.getValue(req, contant.MODEL)).getUsername());
                Category category=categoryService.findOneById(news.getCategoryId());
                news.setCategory(category);
                News news1 = newsService.insert(news);
                result.add(news1);
            }
            ConvertJson.mapToJoson(result,resp.getOutputStream());
            //resp.getWriter().println(news1.getShortDescription());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        News news=ConvertJson.convert(req.getReader()).mapToModel(News.class);
        try {
            News Result=newsService.findOneById(news.getId());
            Boolean flag=newsService.findOneAndDelete(news);
            if (flag) {
                ConvertJson.mapToJoson(Result, resp.getOutputStream());
            } else {
                ConvertJson.mapToJoson(new News(), resp.getOutputStream());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        SessionUtils session=SessionUtils.getInstance();
       News news=ConvertJson.convert(req.getReader()).mapToModel(News.class);
       news.setModifiedDate(new Timestamp(new Date().getTime()));
       news.setModifiedBy(((User)session.getValue(req,contant.MODEL)).getUsername());

        try {
            Boolean flag=newsService.findOneAndUpdate(news);
            if (flag) {
                News Result=newsService.findOneById(news.getId());
                ConvertJson.mapToJoson(Result, resp.getOutputStream());
            } else {
                ConvertJson.mapToJoson(new News(), resp.getOutputStream());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
