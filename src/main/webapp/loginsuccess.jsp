<%@page import="test.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String msg=(String)request.getAttribute("msg");
    AdminBean aBean= (AdminBean)request.getAttribute("bean");
    out.println(msg+"<br>Welcome:"+aBean.getName());

%>
</body>
</html>