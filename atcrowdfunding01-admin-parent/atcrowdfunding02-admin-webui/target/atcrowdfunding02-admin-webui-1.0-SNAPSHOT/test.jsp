<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/18
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="WEB-INF/include-head.jsp"%>
<script type="text/javascript">

    $(function () {
        $("#asyncBtn").click(function () {

            console.log("ajax函数之前");
            $.ajax({
                "url":"test/ajax.html",
                "type":"post",
                "dataType":"text",
                "success":function(response){
                    console.log("ajax函数内部的success函数" + response);
                }
            });

            console.log("ajax函数之后");
        });
    });
</script>
<body>
<form action="test/ajax.html" method="post">
    <button name="asyncBtn" value="">提交</button>
</form>

http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/
</body>
</html>
