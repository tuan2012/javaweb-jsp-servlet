package com.cxtuan.Controller.user;

import com.cxtuan.Service.Interface.INewsService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/news/*")
public class ItemsDetail extends HttpServlet {
    @Inject
    private INewsService newsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("news",newsService.findNewsById(req,resp).get(0));
        RequestDispatcher reqDispatcher=req.getRequestDispatcher("/views/user/detail.jsp");
        reqDispatcher.forward(req,resp);
    }
}
