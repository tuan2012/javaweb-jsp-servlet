package com.cxtuan.Service.Interface;

import com.cxtuan.Model.User;

public interface IUserService {
    User findUserByUserAndRole(String username,String password);
}
