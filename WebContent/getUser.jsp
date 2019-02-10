<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import = "Register.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="userdetails.css">
<title>Get User</title>
</head>



<body>

	<div class="container">
		<br> <br>
		<div  class="Details" align="left">
			<table border="1" cellpadding="12">
			<%
				User user =  	new User();
					
				%>
				<caption>
					<h2>User Details of <%= session.getAttribute("fname") %> <%=session.getAttribute("lname")%></h2>
				</caption>
				
				<tr>	
						<th>First Name</th>
						<td><%=session.getAttribute("fname")%></td>
				 </tr>
				 
				<tr>	<th>Last Name</th> 
						<td><%=session.getAttribute("lname")%></td>
				</tr>
				
				<tr>	
						<th>Contact Number</th>
						<td><%=session.getAttribute("MNum")%></td>		
				 </tr>
				 
				<tr>	
						<th>Email</th> 
						<td><%=session.getAttribute("email")%></td>
				</tr>
				
				<tr>	<th>Password</th>
						 <td><%=session.getAttribute("pass")%></td>				
					</tr>		
				
				<tr>	<th>Confirm Password</th> 
						<td><%=session.getAttribute("pass2")%></td>
				</tr>
				
					<td>
						<form method="POST" action="UpdateUser">
							<input type="submit" value="Update">
							
						</form>
			
					</td>
				</tr>

			</table>
		</div>

	</div>
</body>
<%@include file="footer.jsp"%>
</html>

