package com.cxtuan.Paging;



public interface Pageable {
    Page getPager();
    Sort getSorter();
    Long getOffset();
}
