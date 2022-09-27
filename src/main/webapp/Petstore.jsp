<!DOCTYPE html>
<%@page import="java.util.HashMap"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<style>
table, th, td {
  border: solid black;
}

</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table style="width:500px" id="Courses">
<tr> 
<th>PET ID  </th>
<th> PET NAME </th>
<th>Action  </th>
</tr>

<c:forEach items="${petList}" var="pet">
<tr> 
<td> ${pet.key}</td>
<td> ${pet.value}</td>
<td> </td>
</tr>
</c:forEach>
</table>
<a href="Pet.html">
<button type="button">Add New Pet</button>
</a>



</body>
</html>