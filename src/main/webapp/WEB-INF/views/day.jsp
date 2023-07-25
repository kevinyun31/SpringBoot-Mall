<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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

<div class="container mt-3">
    <h1>
        아침 점심 저녁
    </h1>

    <%
        String morning = (String)request.getAttribute("time");
        System.out.println("morning : "+morning);
    %>
    <%=morning%>
    <br>
<%--    위의 내용을 간단하게 만든 문법--%>
    ${time}

    <hr>
    <h1>시간 렌더링</h1>
    ${morning}
    ${afternoon}
    ${evening}

    ${list[0]}
    <%
        List<String> list = (ArrayList<String>)request.getAttribute("list");
        for(int i=0; i<list.size(); i++){
    %>
    <%=list.get(i)%>
    <%
        }
    %>

</div>

</body>
</html>