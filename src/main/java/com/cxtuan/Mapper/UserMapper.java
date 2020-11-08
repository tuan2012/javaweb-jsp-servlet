package com.cxtuan.Mapper;

import com.cxtuan.Model.Role;
import com.cxtuan.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IMapper<User>{
    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        User user=new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFillname(rs.getString("fullname"));
        user.setStatus(rs.getInt("status"));
        try {
            Role role = new Role(rs.getString("name"), rs.getString("code"));
            user.setRole(role);
        }
        catch (Exception e) {}
        return user;
    }
}
