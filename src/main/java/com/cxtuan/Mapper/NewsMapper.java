package com.cxtuan.Mapper;

import com.cxtuan.Model.Category;
import com.cxtuan.Model.News;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements IMapper<News> {
    @Override
    public News mapRow(ResultSet rs) throws SQLException {
        News news=new News(rs.getString("title"),rs.getString("shortDescription"));
        news.setId(rs.getInt(1));
        news.setCategoryId(rs.getInt("categoryid"));
        news.setThumnail(rs.getString("thumbnail"));
        news.setContent(rs.getString("content"));
        news.setCreateDate(rs.getTimestamp("createddate"));
        news.setModifiedDate(rs.getTimestamp("modifieddate"));
        news.setCreateBy(rs.getString("createdby"));
        news.setModifiedBy(rs.getString("modifiedby"));
        Category category=new Category();
        try {
            category.setName(rs.getString("name"));
            category.setCode(rs.getString("code"));
            news.setCategory(category);
        }catch (Exception e){

        }
        return news;
    }
}
