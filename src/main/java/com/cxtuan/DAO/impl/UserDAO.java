package com.cxtuan.DAO.impl;

import java.util.*;
import com.cxtuan.DAO.Interface.IUserDAO;
import com.cxtuan.Mapper.UserMapper;
import com.cxtuan.Model.User;

public class UserDAO extends ParentDAO<User> implements IUserDAO  {
    @Override
    public User findUserByUserAndRole(String username, String password) {
        String sql="select * from user u inner join role r on u.roleid=r.id where u.username=? and u.password=? and u.status=1";
        List<User>list=findByParams(sql,new UserMapper(),username,password);
        return list.isEmpty()?null: list.get(0);
    }
}
