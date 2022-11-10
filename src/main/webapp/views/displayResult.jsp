<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#table {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#table td, #table th {
  border: 1px solid #ddd;
  padding: 8px;
}

#table tr:nth-child(even){background-color: #f2f2f2;}

#table tr:hover {background-color: #ddd;}

#table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
body {
 background-color: #C0C0C0;  
}
</style>
<title>Voting App</title>
</head>
<body>
<div align="right">
<a href="loginPage">Log out</a><br></div>
<div align="center">
<h1><b>Admin Page</b></h1>
<h2>Result's of Vote</h2>
<table border="1" id="table">
		<tr>
			<th>name</th>
			<th>count</th>
			
		</tr>
		<c:forEach items="${result}" var="resultt">
			<tr>
				<td>${resultt.name}</td>
				<td>${resultt.count}</td>
			
			</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>