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
    <h1>Hello jsp</h1>
    <hr>
    <%
        String name = (String)request.getAttribute("price");
        System.out.println("name : "+name);
    %>
    <%=name%>

    ${price}

    <hr>
    <h1>과일 랜더링</h1>
    ${banana}
    ${ddalgi}
    ${chamwei}

    <h1>Lost렌더링</h1>
    ${lost[0]}

    <%
        List<String> list = (ArrayList<String>)request.getAttribute("lost");
        for(int i=0; i<list.size(); i++){
    %>
    <%=list.get(i)%>
    <%
        }
    %>

    <c:forEach var="f"  items="${lost}">
        ${f} <br>
    </c:forEach>
</div>

</body>
</html>