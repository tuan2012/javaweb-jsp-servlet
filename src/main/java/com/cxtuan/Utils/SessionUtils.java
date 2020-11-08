package com.cxtuan.Utils;

import javax.servlet.http.HttpServletRequest;

//Single TOn Patterm
public class SessionUtils {

    private static SessionUtils sessionUtils;

    private SessionUtils(){}
    public static SessionUtils getInstance()
    {
        if(sessionUtils==null)
            sessionUtils=new SessionUtils();
        return sessionUtils;
    }
    public  void putSession(HttpServletRequest req,String name,Object value)
    {
        req.getSession().setAttribute(name,value);
    }
    public Object getValue(HttpServletRequest req,String name)
    {
        return req.getSession().getAttribute(name);
    }
    public void deleteSession(HttpServletRequest req,String name)
    {
        req.getSession().removeAttribute(name);
    }
}
