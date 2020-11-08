package com.cxtuan.Controller.admin;

import com.cxtuan.Model.News;
import com.cxtuan.Service.Interface.INewsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/news-edit/*"})
public class NewEditController extends HttpServlet {
    @Inject
    private INewsService newsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getPathInfo();
        String partPath[]=path.split("/");
        News news=newsService.findOneById(Integer.parseInt(partPath[1]));

    }
}
