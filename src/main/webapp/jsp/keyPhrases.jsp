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
String[] detected = (String[]) request.getAttribute("detected");
if(detected == null){
	detected = new String[0];
}
%>
<body>
	<h1>KeyPhrases</h1>
	<p>parameter「<%= parameter %> 」のキーフレーズは<%= detected.length %>種類</p>
	<%for(String s : detected){ %>
	<p>「<%= s %>」</p>
	<%} %>

</body>
</html>