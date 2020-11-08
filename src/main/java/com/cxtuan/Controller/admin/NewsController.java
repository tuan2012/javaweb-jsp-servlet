package com.cxtuan.Controller.admin;

import com.cxtuan.DAO.Interface.INewsDAO;
import com.cxtuan.Model.Category;
import com.cxtuan.Model.ExtendPaging;
import com.cxtuan.Model.News;
import com.cxtuan.Paging.Page;
import com.cxtuan.Paging.Pageable;
import com.cxtuan.Paging.Sort;
import com.cxtuan.Service.Interface.ICategoryService;
import com.cxtuan.Service.Interface.INewsService;
import com.cxtuan.Utils.FormUtils;
import com.cxtuan.contant.contant;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/admin/list-news"})
public class NewsController extends HttpServlet {
    @Inject
    private INewsService newsService;
    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News>result;
        String linkViews="";
        Pageable page=null;
        News news=null;
        try {

            news=FormUtils.toModel(News.class,req);
            if(news.getType().equals(contant.LIST)) {
                page = new Page(news.getPage(), news.getNumberOfPage(), new Sort(news.getSortName(), news.getSortBy()), newsService.countAllDocument());

                System.out.println(String.valueOf(page.getPager().getNumberOfPage()) + page.getPager().getOffset() + page.getSorter().getSortBy() + page.getSorter().getSortName());
                result = newsService.findAll(page);
                news.setCountPage(page.getPager().getCountPage());
                news.setResult(result);
                req.setAttribute("news", news);
                linkViews="/views/admin/news/listNews.jsp";

            }
            else if(news.getType().equals(contant.EDIT))
            {
                List<Category> categoryList=categoryService.findAll();
                if(news.getId()!=0){
                    news= newsService.findOneById(news.getId());

                    req.setAttribute("news", news);

                }
                linkViews="/views/admin/news/edit.jsp";
                req.setAttribute(contant.LISTMODEL,categoryList);
            }

            RequestDispatcher reqD = req.getRequestDispatcher(linkViews);
            reqD.forward(req, resp);
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
