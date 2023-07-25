<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Mall</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">쇼핑몰</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">상품목록</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/write">상품등록</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<div class="container mt-3" style="display: flex">

    <table class="table" style="flex: 1; min-width: 10px;">
        <thead>
        <tr>
            <th>판매자</th>
            <th>이름</th>
            <th>E-Mail</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${sellerList}">
            <tr>
                <td>${s.id}</td>
                <td><a href="/product/${s.id}">${s.name}</a> </td>
                <td>${s.email}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <br/>

    <table class="table" style="flex: 1; min-width: 800px;">
        <thead>
        <tr>
            <th>상품번호</th>
            <th>상품명</th>
            <th>상품가격</th>
            <th>상품재고</th>
            <th>상품설명</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${productList}">
            <tr>
                <td>${p.id}</td>
                <td><a href="/product/${p.id}">${p.name}</a> </td>
                <td>${p.price}원</td>
                <td>${p.qty}개</td>
                <td>${p.des}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>



</body>
</html>