package com.cxtuan.Controller.user;

import com.cxtuan.Model.User;
import com.cxtuan.Service.Interface.IUserService;
import com.cxtuan.Utils.FormUtils;
import com.cxtuan.Utils.SessionUtils;
import com.cxtuan.contant.contant;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class login extends HttpServlet {
    @Inject
    private IUserService userService;
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req,resp);
        deleteSessionMessage(req,"alert","message");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String redirect=req.getParameter("redirect");
            User user= FormUtils.toModel(User.class,req);
            System.out.println(user.getUsername()+"4444444444456666565656");
            SessionUtils session=SessionUtils.getInstance();
            User newUser=userService.findUserByUserAndRole(user.getUsername(), user.getPassword());
            System.out.println("***********User"+newUser+user.getUsername()+user.getPassword());
            if(newUser!=null) {
                if (redirect != null) {
                    resp.sendRedirect(redirect);
                } else {
                    if (newUser.getRole().getCode().equals("ADMIN")) {
                        deleteSessionMessage(req, "alert", "message");
                        resp.sendRedirect("/admin/trangchu");
                    }

                    if (newUser.getRole().getCode().equals("USER")) {
                        deleteSessionMessage(req, "alert", "message");
                        resp.sendRedirect("/trangchu-user");
                    }
                }

                session.putSession(req, contant.MODEL,newUser);
            }else {
                ResourceBundle bundle=ResourceBundle.getBundle("message");
                resp.sendRedirect("/dang-nhap?redirect="+redirect);
                session.putSession(req,"message",bundle.getString("invalid"));
                session.putSession(req,"alert",bundle.getString("alert"));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    private void deleteSessionMessage(HttpServletRequest req,Object... key)
    {
        SessionUtils session=SessionUtils.getInstance();
        for(Object ob:key )
        {
            session.deleteSession(req, (String) ob);
        }
    }
}
