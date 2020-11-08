package com.cxtuan.Model;


import java.sql.Timestamp;
import java.util.List;

public class Parent {
    protected int id;
    protected Timestamp createDate;
    protected Timestamp modifiedDate;
    protected String createBy;
    protected String modifiedBy;
    protected long page;
    protected long numberOfPage;
    protected double countPage;
    protected String sortName;
    protected String sortBy;
    protected List<News> result;
    protected String type;
    protected int[] listId;

    public int[] getListId() {
        return listId;
    }

    public void setListId(int[] listId) {
        this.listId = listId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(long numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public double getCountPage() {
        return countPage;
    }

    public void setCountPage(double countPage) {
        this.countPage = countPage;
    }

    public List<News> getResult() {
        return result;
    }

    public void setResult(List<News> result) {
        this.result = result;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
