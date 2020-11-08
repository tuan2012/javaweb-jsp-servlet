<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nttuan
  Date: 12/09/2020
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
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
                        <c:url var="paramEdit" value="/admin/list-news">
                            <c:param name="type" value="EDIT"/>
                        </c:url>
                        <a href="${paramEdit}" class="btn btn-xs btn-info">
                            <i class="fa-plus-square fa  bigger-120"></i>
                        </a>
                        <a id="trash" class="btn btn-xs btn-danger">
                            <i  class="fa-trash fa  bigger-120"></i>
                        </a>
                        <span class="input-icon">
                            <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input"
                                autocomplete="off">
                            <i class="ace-icon fa fa-search nav-search-icon"></i>

                        </span>


                    </form>
                </div><!-- /.nav-search -->
            </div>

            <div class="page-content">
                <form action="/admin/list-news" id="pageSubmit" method="GET">
                    <input id="page" value="" name="page" type="hidden">
                    <input id="numberOfPage" value="" name="numberOfPage" type="hidden">
                    <input id="sortName" value="" name="sortName" type="hidden">
                    <input id="sortBy" value="" name="sortBy" type="hidden">
                    <input id="type" value="list" name="type" type="hidden">
                </form>
                    <div class="row">
                        <div class="col-xs-12">

                            <table id="simple-table" class="table  table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th><input class="form-check-input" type="checkbox" id="checkAll"></th>
                                        <th>id</th>
                                        <th>Bài viết</th>
                                        <th>Ngày tạo</th>
                                        <th>Người tạo</th>
                                        <th>Sửa đổi lần cuối</th>
                                        <th>Người chỉnh sửa</th>
                                        <th>Hành động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${news.result}">

                                        <tr class="">
                                            <td><input class="form-check-input" type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <td>${item.id}</td>
                                            <td>
                                                <c:url var="paramDetail" value="/news/">
                                                    <c:param name="title" value="${item.title}"/>
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a href="${paramDetail}">${item.title}</a>
                                            </td>

                                            <td>${item.createDate}</td>
                                            <td>${item.createBy}</td>
                                            <td>${item.modifiedDate}</td>
                                            <td>${item.modifiedBy}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <c:url var="paramEdit" value="/admin/list-news">
                                                        <c:param name="type" value="EDIT"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a href="${paramEdit}" class="btn btn-xs btn-info">
                                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                    </a>
                                                    <a class="btn btn-xs btn-danger">
                                                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                    </a>
                                                </div>
<%--                                                <div class="hidden-md hidden-lg">--%>
<%--                                                    <div class="inline pos-rel">--%>
<%--                                                        <button class="btn btn-minier btn-primary dropdown-toggle"--%>
<%--                                                            data-toggle="dropdown" data-position="auto">--%>
<%--                                                            <i class="ace-icon fa fa-cog icon-only bigger-110"></i>--%>
<%--                                                        </button>--%>
<%--                                                        <ul--%>
<%--                                                            class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">--%>
<%--                                                            <li>--%>
<%--                                                                <a href="/trangchu-user" class="tooltip-info" data-rel="tooltip"--%>
<%--                                                                    title="" data-original-title="View">--%>
<%--                                                                    <span class="blue">--%>
<%--                                                                        <i--%>
<%--                                                                            class="ace-icon fa fa-search-plus bigger-120"></i>--%>
<%--                                                                    </span>--%>
<%--                                                                </a>--%>
<%--                                                            </li>--%>

<%--                                                            <li>--%>
<%--                                                                <a href="#" class="tooltip-success" data-rel="tooltip"--%>
<%--                                                                    title="" data-original-title="Edit">--%>
<%--                                                                    <span class="green">--%>
<%--                                                                        <i--%>
<%--                                                                            class="ace-icon fa fa-pencil-square-o bigger-120"></i>--%>
<%--                                                                    </span>--%>
<%--                                                                </a>--%>
<%--                                                            </li>--%>

<%--                                                            <li>--%>
<%--                                                                <a href="#" class="tooltip-error" data-rel="tooltip"--%>
<%--                                                                    title="" data-original-title="Delete">--%>
<%--                                                                    <span class="red">--%>
<%--                                                                        <i--%>
<%--                                                                            class="ace-icon fa fa-trash-o bigger-120"></i>--%>
<%--                                                                    </span>--%>
<%--                                                                </a>--%>
<%--                                                            </li>--%>
<%--                                                        </ul>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <nav aria-label="Page navigation" class="center">
                                <ul class="pagination" id="pagination"></ul>
                            </nav>

                        </div>
                    </div><!-- /.row -->

            </div><!-- /.page-content -->
        </div>
    </div>
    <script>

        document.addEventListener('DOMContentLoaded', () => {

            $('#trash').click(e=>{
                const data={};
                // const listId=$('tbody input[type=checkbox]:checked').map(()=>{
                //
                //     console.log($(this).val());
                // })
                //data['listId']=listId;
                const d=$('tbody input[type=checkbox]:checked').val();

                console.log(d)

            })
            const deleteId=(data)=>{
                $.ajax({
                    url:'${ajax}',
                    contentType:'application/json',
                    type:'DELETE',
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

            const startPage=${news.page};
            $(function () {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: ${news.countPage},
                    visiblePages: 5,
                    startPage: startPage,
                    onPageClick: function (event, page) {
                        //console.info(page + ' (from options)');
                        if(page!==startPage) {
                            $('#page').val(page);
                            $('#numberOfPage').val(10);
                            $('#sortName').val('id');
                            $('#sortBy').val('desc');
                            $('#type').val('LIST');
                            $('#pageSubmit').submit();
                        }
                    }
                }).on('page', function (event, page) {
                    console.info(page + ' (from event listening)');
                });
            });
        });
    </script>
</body>

</html>