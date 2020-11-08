package com.cxtuan.Model;

public class News extends Parent{
    private String title;
    private String thumnail;
    private String shortDescription;
    private String content;
    private int categoryId;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public News(String title, String shortDescription) {
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public News(String title, String thumnail, String shortDescription, String content, int categoryId) {
        this.title = title;
        this.thumnail = thumnail;
        this.shortDescription = shortDescription;
        this.content = content;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", thumnail='" + thumnail + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                ", id=" + id +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                ", createBy='" + createBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", page=" + page +
                ", numberOfPage=" + numberOfPage +
                ", countPage=" + countPage +
                ", sortName='" + sortName + '\'' +
                ", sortBy='" + sortBy + '\'' +
                ", result=" + result +
                ", type='" + type + '\'' +
                '}';
    }

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
