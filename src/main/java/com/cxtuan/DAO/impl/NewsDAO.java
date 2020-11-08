package com.cxtuan.DAO.impl;

import com.cxtuan.DAO.Interface.INewsDAO;
import com.cxtuan.Mapper.NewsMapper;
import com.cxtuan.Model.News;
import com.cxtuan.Paging.Pageable;

import java.sql.SQLException;
import java.util.List;

public class NewsDAO extends ParentDAO<News> implements INewsDAO {

    @Override
    public List<News> findAll(Pageable pageable) {
        StringBuilder sql=new StringBuilder("select*from news n inner join category ct on n.categoryid=ct.id");

        if(pageable.getSorter().getSortName()!=null&&pageable.getSorter().getSortBy()!=null) {
            sql.append(" ORDER BY n."+pageable.getSorter().getSortName()+" "+pageable.getSorter().getSortBy());
        }
        if(pageable.getPager().getPage()!=0&&pageable.getPager().getNumberOfPage() !=0) {
            sql.append(" limit "+pageable.getPager().getOffset()+","+pageable.getPager().getNumberOfPage());
        }
        System.out.println(sql);
        return findByParams(sql.toString(),new NewsMapper());
    }

    @Override
    public List<News> findByCategoryCode(String code){
        return findByParams("select * from news n  inner join category ct on ct.id=n.categoryid where ct.code=?",new NewsMapper(),code);
    }

    @Override
    public List<News> findNewsById(int id) {
        return findByParams("select *from news n inner join category ct on n.categoryid=ct.id where n.id=?",new NewsMapper(),id);
    }

    @Override
    public int addNew(News news) throws SQLException, ClassNotFoundException {
        return insert("insert into news(title,thumbnail,shortdescription,categoryid,content,createddate,modifieddate,createdby) values(?,?,?,?,?,?,?,?)",news.getTitle(),news.getThumnail(),news.getShortDescription(),news.getCategoryId(),news.getContent(),news.getCreateDate(),news.getModifiedDate(),news.getCreateBy());
    }

    @Override
    public Boolean findOneAndUpdate(News news) throws SQLException {
        //return updateAndDelete("update news set title=?,shortdescription=? where id=?",news.getTitle(),news.getShortDescription(),news.getId());
        System.out.println("DAO*************"+news.toString());
        return updateAndDelete("update news set title=?,thumbnail=?,content=?,shortdescription=?,categoryid=?,modifieddate=?, modifiedby=? where id=? ",news.getTitle(),news.getThumnail(),news.getContent(),news.getShortDescription(),news.getCategoryId(),news.getModifiedDate(),news.getModifiedBy(),news.getId());
        //return updateAndDelete("update news set title=?,thumbnail=?,content=?,shortdescription=? where id=? ",news.getTitle(),news.getThumnail(),news.getContent(),news.getShortDescription(),news.getId());
    }

    @Override
    public Boolean findOneAndDelete(News news) throws SQLException {
        return updateAndDelete("delete from news where id=?",news.getId());
    }

    @Override
    public long countALlDocument() throws SQLException {
        return CountDocument("select count(*) from news");
    }

    @Override
    public List<News> findByLimit(long offset, long rowCount) {
        return findByParams("select *from news limit ?,?",new NewsMapper(),offset,rowCount);
    }


}
