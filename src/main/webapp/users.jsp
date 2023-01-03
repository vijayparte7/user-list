<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.vijay.userlist.entity.User,java.util.List,com.vijay.userlist.util.SortData,org.springframework.data.domain.Page"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List Page</title>
</head>
<body>
<% Page<User> users=(Page<User>)request.getAttribute("users");
SortData sortData=(SortData)request.getAttribute("sortData");
%>
<% if(users.getTotalPages()>sortData.getOffset()+1){ %> <a href="sort?offSet=<%=sortData.getOffset()+1%>&pageSize=<%=sortData.getPageSize()%>&field=<%=sortData.getField()%>">Next Page</a><%} %>
<% if(sortData.getOffset()>0){ %><a style="margin-left: 20px" href="sort?offSet=<%=sortData.getOffset()-1%>&pageSize=<%=sortData.getPageSize()%>&field=<%=sortData.getField()%>">Prev Page</a><%} %>
	<table>
	<tr>
	<th><a href="sort?offSet=0&pageSize=<%=sortData.getPageSize()%>&field=firstname">First Name</a></th>   
    <th><a href="sort?offSet=0&pageSize=<%=sortData.getPageSize()%>&field=lastname">Last Name</a></th>   
    <th><a href="sort?offSet=0&pageSize=<%=sortData.getPageSize()%>&field=emailid">Email ID</a></th>   
    <th><a href="sort?offSet=0&pageSize=<%=sortData.getPageSize()%>&field=employeeid">employee ID</a></th>   
    <th><a href="sort?offSet=0&pageSize=<%=sortData.getPageSize()%>&field=organization">Organization</a></th>   
   	</tr>
	<% for (User user : users) { %>
	<tr>
    <td><%=user.getFirstname()%></td>   
    <td><%=user.getLastname()%></td>   
    <td><%=user.getEmailid()%></td>  
    <td><%=user.getEmployeeid()%></td>
    <td><%=user.getOrganization()%></td>
	</tr>
		<%} %>
	
	</table>
	<pre>
	
	<a href="logout">logout</a>
	</pre>
</body>
</html>