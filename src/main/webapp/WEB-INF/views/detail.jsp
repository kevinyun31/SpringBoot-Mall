<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div class="container mt-3">
    <form action="/seller/update" method="post" enctype="application/x-www-form-urlencoded">
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" value="${s.id}" name="id">
        </div>
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" value="${s.name}" name="name">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" value="${s.email}" name="email">
        </div>

    </form>

    <form action="/product/update" method="post" enctype="application/x-www-form-urlencoded">
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" value="${p.id}" name="id">
        </div>
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" value="${p.name}" name="name">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" value="${p.price}" name="price">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" value="${p.qty}" name="qty">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" value="${p.des}" name="des">
        </div>
        <button type="submit" class="btn btn-primary">상품수정</button>

    </form>

    <form action="/product/delete" method="post">
        <input type="hidden" class="form-control" value="${p.id}" name="id">
        <button type="submit" class="btn btn-danger">상품삭제</button>
    </form>


</div>


</body>
</html>