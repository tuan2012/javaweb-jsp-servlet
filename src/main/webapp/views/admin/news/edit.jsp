<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 9/29/2020
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/lib.jsp"%>
<c:url var="ajax" value="/api-admin-news"/>;
<c:url var="update" value="/admin/list-news"/>;
<html>

<head>
    <title>Edit</title>
</head>

<body>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>

                    <li>
                        <a href="#">Tables</a>
                    </li>
                    <li class="active">Simple &amp; Dynamic</li>
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
                        <span class="input-icon">

                            <i class="fa fa-plus-square bigger-150" aria-hidden="true"></i>

                        </span>
                        <span class="input-icon">
                            <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input"
                                autocomplete="off">
                            <i class="ace-icon fa fa-search nav-search-icon"></i>

                        </span>


                    </form>
                </div><!-- /.nav-search -->
            </div>

            <div class="page-content">
                <form id="formUpdateAndAdd">
                    <div class="form-group">
                        <label for="categoryId">category</label>
                        <select class="custom-select" id="categoryId" name="categoryId">
                            <option selected>Choose Category...</option>
                            <c:forEach var="item" items="${LISTMODEL}">
                                <c:choose>
                                    <c:when test="${item.code eq news.category.code}">
                                        <option value="${item.id}" selected>${item.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item.id}">${item.name}</option>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>

                        </select>

                    </div>
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input type="text" class="form-control" id="title" name="title" value="${news.title}"
                            aria-describedby="emailHelp" placeholder="Enter Title">

                    </div>
                    <div class="form-group">
                        <label for="thumnail">Title</label>
                        <input type="text" class="form-control" id="thumnail" name="thumnail" value="${news.thumnail}"
                               aria-describedby="emailHelp" placeholder="Enter Title">

                    </div>
                    <div class="form-group">
                        <label for="shortDescription">Short Description</label>
                        <input type="text" class="form-control" id="shortDescription" value="${news.shortDescription}"
                            name="shortDescription" placeholder="Short Description">
                    </div>
                    <div class="form-group">
                        <label for="textAria">Content</label>
                        <textarea id="textAria" style="" cols="30" rows="10">${news.content}</textarea>
<%--                        <input type="text" class="form-control" id="content" value="${news.content}" name="content"--%>
<%--                            placeholder="Content">--%>
                    </div>
                    <div class="form-group">
                        <input type="hidden" id="id" name="id" value="${news.id}">
                    </div>



                    <c:choose>
                        <c:when test="${empty news}">
                            <button class="btn btn-primary " id="btnAddAndUpdate">Plus News</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-primary" id="btnAddAndUpdate">Edit News</button>
                        </c:otherwise>
                    </c:choose>

                </form>
            </div>
        </div>
    </div>
    <script src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"/>" type="text/javascript"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            $(document).ready(function () {
                let ckeditor;
                ckeditor= CKEDITOR.replace('textAria');


                $('#btnAddAndUpdate').click((e) => {
                    e.preventDefault();
                    const formdata = $('#formUpdateAndAdd').serializeArray();
                    const listData = [];
                    const data={};
                    $.each(formdata, (i, v) => {
                        data[v.name] = v.value;
                    })
                    data['content']=ckeditor.getData();

                     listData.push(data);
                     console.log(JSON.stringify(listData))
                     const id=data['id'];
                    if(id!=="")
                    {
                        updateNews(data);
                    }
                    else{
                        addNews(listData);
                    }

                })
                const updateNews=(data)=>{
                    $.ajax({
                        url:'${ajax}',
                        contentType:'application/json',
                        type:'PUT',
                        data:JSON.stringify(data),
                        dataType:'json',
                        success:(result)=>{
                            window.location.href='${update}?type=LIST&page=1&numberOfPage=10&sortName=id&sortBy=desc';
                        },
                        error:(err)=>{
                            window.location.href='/admin/list-news?type=EDIT&id='+id;
                        }
                    })
                }
                const addNews=(data)=>{
                    $.ajax({
                        url:'${ajax}',
                        contentType:'application/json',
                        type:'POST',
                        data:JSON.stringify(data),
                        dataType: 'Json',
                        success:(result)=>{
                            window.location.href='${update}?type=LIST&page=1&numberOfPage=10&sortName=id&sortBy=desc';
                        },
                        error:(err)=>{
                            window.location.href='/admin/list-news?type=EDIT';
                        }
                    })
                }

            });
        });
    </script>
</body>

</html>