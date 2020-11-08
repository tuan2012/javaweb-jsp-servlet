package com.cxtuan.Controller.admin;

import com.cxtuan.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/admin/trangchu"})
public class home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User>userArrayList=new ArrayList<>();
        for(int i=0;i<5;i++) {
            User user = new User("Tuấn", "Châu Xuân");
            userArrayList.add(user);
        }
        req.setAttribute("listUsers",userArrayList);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/admin/home.jsp");
        requestDispatcher.forward(req,resp);
    }
}

