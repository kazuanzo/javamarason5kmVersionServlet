<%@page import="javamarathon5km.domain.BaseballTeam"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>球団名</div>  
	<pre>${team.teamName}</pre>
	<div>本拠地</div>
	<pre>${team.headquarters}</pre>
	<div>発足</div>
	<pre>${team.inauguration}</pre>
	<div>歴史</div>
	<pre>${team.history}</pre>
	<a href="BaseballTeamListServlet">戻る</a> 
</body>
</html>