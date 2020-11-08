package com.cxtuan.Controller.user;

import com.cxtuan.Paging.Page;
import com.cxtuan.Paging.Pageable;
import com.cxtuan.Paging.Sort;
import com.cxtuan.Service.Interface.ICategoryService;
import com.cxtuan.Service.Interface.INewsService;
import com.cxtuan.Utils.SessionUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/trangchu-user","/category/*"})
public class Home extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private INewsService newsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listHome(req,resp);
    }



    private void listHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(req.getPathInfo());
            Pageable pageable=new Page(0,0,new Sort(null,null),0);
            req.setAttribute("categories",categoryService.findAll());
            if ((req.getPathInfo() == null)) {
                req.setAttribute("listNews", newsService.findAll(pageable));
            } else {
                req.setAttribute("listNews", newsService.findNewsByCategoryCode(req, resp));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/user/home.jsp");
        requestDispatcher.forward(req,resp);
        SessionUtils sessionUtils=SessionUtils.getInstance();
        sessionUtils.deleteSession(req,"messagePermission");

        }
    }

