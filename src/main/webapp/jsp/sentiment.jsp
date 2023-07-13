<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sentiment</title>
</head>
<%
String parameter = (String) request.getAttribute("parameter");
Integer positive=(Integer)request.getAttribute("positive");
%>
<body>
	<h1>Sentiment</h1>
	<p>parameter「<%= parameter %> 」のSentimentは</p>
<UL>
		<LI>positive：<%= positive %>%
		<LI>neutral：<%= positive %>%
		<LI>negative：<%= positive %>%
	</UL>

</body>
</html>