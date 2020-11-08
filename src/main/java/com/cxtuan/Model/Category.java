package com.cxtuan.Model;

public class Category extends Parent{
    private String name;
    private String code;

    public Category() {
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category(String name, String code) {
        this.name = name;
        this.code = code;

    }
}
