
<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 9/14/2020
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/lib.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<c:choose>
    <c:when test="${not empty messagePermission}">
        <div class="alert alert-danger d-flex justify-content-center mt-3 login_container" role="alert">
                ${messagePermission}
        </div>
    </c:when>
    <c:otherwise>
        <!-- Jumbotron Header -->
        <main>
            <!-- Trending Area Start -->
            <div class="trending-area fix">
                <div class="container">
                    <div class="trending-main">
                        <!-- Trending Tittle -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="trending-tittle">
                                    <strong>Trending now</strong>
                                    <!-- <p>Rem ipsum dolor sit amet, consectetur adipisicing elit.</p> -->
                                    <div class="trending-animated">
                                        <ul id="js-news" class="js-hidden">
                                            <li class="news-item">BLog về những sự kiện trong nước và nước ngoài.</li>
                                            <li class="news-item">Với những tin tức hấp dẫn.......</li>
                                            <li class="news-item">Không thể bỏ qua.</li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8">
                                <!-- Trending Top -->

                                <c:forEach var="item" begin="0" end="0" items="${listNews}">
                                    <div class="trending-top mb-30">
                                        <div class="trend-top-img">
                                            <img src="<c:url value="/public/user/assets/img/trending/trending_top.jpg"/>" alt="">
                                            <div class="trend-top-cap">
                                                <span>${item.category.name}</span>
                                                <h2><a href="/news/${item.title}?id=${item.id}">${item.title}</a></h2>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <!-- Trending Bottom -->
                                <div class="trending-bottom">
                                    <div class="row">

                                        <c:forEach var="item" begin="1"  items="${listNews}">
                                            <div class="col-lg-4">
                                                <div class="single-bottom mb-35">
                                                    <div class="trend-bottom-img mb-30">
                                                        <img src="<c:url value="/public/user/assets/img/trending/trending_bottom3.jpg"/>" alt="">
                                                    </div>
                                                    <div class="trend-bottom-cap">
                                                        <span class="color3">${item.getCategory().name}</span>
                                                        <h4><a href="/news/${item.title}?id=${item.id}">${item.title}</a></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- Riht content -->

                        </div>
                    </div>
                </div>
            </div>
            <!-- Trending Area End -->

            <!-- Whats New Start -->

            <!-- Whats New End -->
            <!--   Weekly2-News start -->

            <!-- End Weekly-News -->
            <!-- Start Youtube -->

            <!-- End Start youtube -->

            <!-- End pagination  -->
        </main>
    </c:otherwise>
</c:choose>





    <!-- /.row -->

</body>
</html>
