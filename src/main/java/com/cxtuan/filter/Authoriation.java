package com.cxtuan.filter;

import com.cxtuan.Model.News;
import com.cxtuan.Model.User;
import com.cxtuan.Paging.Page;
import com.cxtuan.Utils.FormUtils;
import com.cxtuan.Utils.SessionUtils;
import com.cxtuan.contant.contant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
@WebFilter(urlPatterns = "/*")
public class Authoriation implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        ResourceBundle bundle=ResourceBundle.getBundle("message");
        HttpServletResponse res= (HttpServletResponse) servletResponse;
        SessionUtils session=SessionUtils.getInstance();
        String pathAll=req.getRequestURI();


        User user= (User) session.getValue(req,contant.MODEL);
        if(pathAll.startsWith("/admin"))
        {
            if(user!=null)
            {
                if(user.getRole().getCode().equals(contant.ADMIN))
                    filterChain.doFilter(servletRequest,servletResponse);
                else{

                    res.sendRedirect("/trangchu-user");
                    session.putSession(req,"messagePermission",bundle.getString("messagePermission"));
                }
            }
            else{

                res.sendRedirect("/dang-nhap?redirect="+pathAll);

            }
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
