package com.cxtuan.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapper<T>{
    T mapRow(ResultSet rs) throws SQLException;
}
