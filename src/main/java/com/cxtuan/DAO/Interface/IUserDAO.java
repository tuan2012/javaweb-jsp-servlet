package com.cxtuan.DAO.Interface;

import com.cxtuan.Model.User;

public interface IUserDAO extends IParentDAO<User> {
    User findUserByUserAndRole(String username,String password);
}
