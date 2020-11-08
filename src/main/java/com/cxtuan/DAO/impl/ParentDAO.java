package com.cxtuan.DAO.impl;

import com.cxtuan.DAO.Interface.IParentDAO;
import com.cxtuan.Mapper.IMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ParentDAO <T> implements IParentDAO<T>{
    static ResourceBundle bundle=ResourceBundle.getBundle("db");
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(bundle.getString("driver"));
        return DriverManager.getConnection(bundle.getString("url"),bundle.getString("username"),bundle.getString("password"));
    }
    @Override
    public List<T> findByParams(String sql, IMapper<T> mapper, Object... paramester) {
        //return null;
        List<T>results=new ArrayList<>();
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        try {
            connection = getConnection();
            preparedStatement=connection.prepareStatement(sql);
            //setParams
            setParam(preparedStatement,paramester);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                results.add(mapper.mapRow(rs));
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(connection!=null)
                    connection.close();
                if(preparedStatement!=null)
                    preparedStatement.close();
            }catch (Exception e){
                return null;
            }

        }
        return results;
    }

    @Override
    public int insert(String sql, Object... paramester) throws SQLException, ClassNotFoundException {
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        int id=-1;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            setParam(preparedStatement, paramester);
            //preparedStatement.executeUpdate();
            preparedStatement.execute();
            ResultSet rs=preparedStatement.getGeneratedKeys();
            while(rs.next())
            {
                id=rs.getInt(1);
            }
            connection.commit();

        }catch (Exception e)
        {
            connection.rollback();

        }finally {
            if(connection!=null)
                connection.close();
            if(preparedStatement!=null)
                preparedStatement.close();
        }
        return id;
    }

    @Override
    public Boolean updateAndDelete(String sql, Object... paramster) throws SQLException {
        Connection connection =null;
        Boolean flag=true;
        PreparedStatement preparedStatement=null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParam(preparedStatement, paramster);
            preparedStatement.execute();
            connection.commit();

        }catch (Exception e)
        {
            connection.rollback();
            flag=false;
        }finally {
            if(connection!=null)
                connection.close();
            if(preparedStatement!=null)
                preparedStatement.close();
        }
        return flag;

    }

    @Override
    public long CountDocument(String sql, Object... params) throws SQLException {
        long count=0;
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setParam(preparedStatement, params);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
                count=rs.getLong(1);
        }catch (Exception e){
            count=0;
        }finally {
            if(connection!=null)
                connection.close();
            if(preparedStatement!=null)
                preparedStatement.close();
        }
        return count;
    }

    private void setParam(PreparedStatement preparedStatement, Object... paramester) throws SQLException {
        for(int i=0;i<paramester.length;i++)
        {
            if(paramester[i] instanceof String)
                preparedStatement.setString(i+1,(String)paramester[i]);
            else if(paramester[i] instanceof Integer)
                preparedStatement.setInt(i+1, (Integer) paramester[i]);
            else if(paramester[i] instanceof Timestamp)
                preparedStatement.setTimestamp(i+1, (Timestamp) paramester[i]);
            else if(paramester[i] instanceof Long)
                preparedStatement.setLong(i+1, (Long) paramester[i]);

        }
    }
}
