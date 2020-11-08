package com.cxtuan.Model;

import com.cxtuan.Model.News;
import java.util.*;

public class ExtendPaging {
    private long page;
    private long numberOfPage;
    private double countPage;
    private List<News>result;

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
}
