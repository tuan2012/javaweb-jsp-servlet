package com.cxtuan.DAO.Interface;

import com.cxtuan.Mapper.IMapper;

import java.sql.SQLException;
import java.util.List;

public interface IParentDAO<T> {
   List<T> findByParams(String sql, IMapper<T> mapper, Object... paramester);
   int insert(String sql,Object... paramester ) throws SQLException, ClassNotFoundException;
   Boolean updateAndDelete(String sql,Object... paramster) throws SQLException;
   long CountDocument(String sql,Object... params) throws SQLException;
}
