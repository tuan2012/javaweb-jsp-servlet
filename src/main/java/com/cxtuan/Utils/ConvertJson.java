package com.cxtuan.Utils;

import com.cxtuan.Model.News;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

public class ConvertJson {
    private String json;

    public ConvertJson(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public static ConvertJson convert(BufferedReader bf) throws IOException {
        StringBuilder builder=new StringBuilder();
        String temp;
        while((temp=bf.readLine())!=null)
        {
            builder.append(temp);
        }
        return new ConvertJson(builder.toString());
    }
    public <T> T mapToModel(Class<T> tClass) throws JsonProcessingException {
        return  new ObjectMapper().readValue(json,tClass);
    }

    public static void mapToJoson(Object objects, OutputStream os) throws IOException {
        new ObjectMapper().writeValue(os,objects);
    }
}
