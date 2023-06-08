<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LanguageDetection</title>
</head>
<%
String parameter = (String) request.getAttribute("parameter");
String detected = (String) request.getAttribute("detected");
%>
<body>
	<h1>LanguageDetection</h1>
	parameter「<%= parameter %> 」は「<%= detected %>」
</body>
</html>