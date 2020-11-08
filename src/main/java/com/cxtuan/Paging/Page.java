package com.cxtuan.Paging;


public class Page implements Pageable {
    private Long page ;
    private Long numberOfPage;
    private Sort sort;
    private Long total;

    public Page(long page, long numberOfPage,Sort sort) {
        this.page = page;
        this.numberOfPage = numberOfPage;
        this.sort = sort;
    }

    public Page() {
    }

    public Page(long page, long numberOfPage, Sort sort, long total) {
        this.page = page;
        this.numberOfPage = numberOfPage;
        this.sort = sort;
        this.total=total;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public Long getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(long numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public double getCountPage() {
        return Math.ceil(1.0*total/this.getNumberOfPage());
    }

    public Long getPage() {
        return page;
    }

    public Sort getSort() {
        return sort;
    }

    @Override
    public Page getPager() {
        return new Page(page,numberOfPage,sort,total);
    }

    @Override
    public Sort getSorter() {
        return sort;
    }

    @Override
    public Long getOffset() {
         return (page-1)*numberOfPage;
    }

}
