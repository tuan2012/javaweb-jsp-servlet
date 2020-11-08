package com.cxtuan.Service.impl;

import com.cxtuan.DAO.Interface.IUserDAO;
import com.cxtuan.Model.User;
import com.cxtuan.Service.Interface.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;
    @Override
    public User findUserByUserAndRole(String username, String password) {
        return userDAO.findUserByUserAndRole(username,password);
    }
}
