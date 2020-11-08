package com.cxtuan.Controller.user;

import com.cxtuan.Model.User;
import com.cxtuan.Utils.SessionUtils;
import com.cxtuan.contant.contant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionUtils session=SessionUtils.getInstance();
        //
        User user= (User) session.getValue(req,contant.MODEL);
        session.deleteSession(req, contant.MODEL);

        resp.sendRedirect("/dang-nhap");
    }
}
