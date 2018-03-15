<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2018/3/8
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/emps/register.do" method="post">
    <input type="text" name="id" value="111">
    <input type="text" name="name" value="张三丰">
    <input type="text" name="sal" value="22">
    <input type="submit" value="保存"/>
</form>
<hr>
<form action="/student/add.do" method="post">
    <input type="text" name="id" value="111">
    <input type="text" name="name" value="张同学">
    <input type="text" name="age" value="18">
    <input type="text" name="cId" value="22">
    <input type="submit" value="保存"/>
</form>
</body>
</html>
