<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
		<!-- <sql:query var="rs" dataSource="jdbc/TestDB">
		select id, username, password from test
		</sql:query> -->
		
<body>
	<center><h1>Spring MVC Tutorials</h1></center>

 <table border= "3" width= 50%  > 
	<tr>  <th width="40">id</th>
			<th width="40">username</th>
			<th width="200">password</th>
			<th width ="200"> Action</th>
		</tr>	
	<tr>
		<c:forEach  var ="row" items="${offers}">
				
			<td>${row.id }</td>
			<td>${row.username}</td>
			<td>${row.password}</td>
			<td>Action</td>
		</tr>	
	</c:forEach>
			
	

  	</table>
  	
  		
<p>	<a href="${pageContext.request.contextPath}/createOffer">Create New Offer </a> </p> 
	</body>
</html>