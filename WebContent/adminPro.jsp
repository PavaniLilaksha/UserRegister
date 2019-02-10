 <%@page import = "Admin.Admin" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Profile</title>
<link rel="stylesheet" type="text/css" href="styleadmin.css">
<link rel="stylesheet" type="text/css" href="footer.css">

<%
if(session.getAttribute("email")==null) 
%>
</head>
<body>

	<div class="main">
	<table>
	<tr><td><a href="AdminViewUser.jsp" />Get users</td></tr>
	<tr><td><a href="adminReg.jsp" />Add admin</td></tr>
	</table>

	</div>
	
	
	<div class="containerForAdminDetails">
		<br> <br>
		<div  class="adminDetails" align="left">
			<table border="1" cellpadding="12">
			<%
				Admin admin =  	Admin.getInstance();
					
			%>
			
				<caption>
					<h2><%=admin.getEmail()%> Details</h2>
				</caption>
				<tr>	<th>First Name</th>
						<td><%=admin.getFirstName()%></td>
				 </tr>
				 
				<tr>	<th>Last Name</th> 
						<td><%=admin.getLastName()%></td>
				</tr>
				
				<tr>	
						<th>Contact Number</th>
						<td><%=admin.getMobileNumber()%></td>		
				 </tr>
				 
				<tr>	
						<th>Email</th> 
						<td><%=admin.getEmail()%></td>
				</tr>
				
				<tr>	<th>Password</th>
						 <td><%=admin.getPassword()%></td>				
					</tr>		
				
				<tr>	<th>Confirm Password</th> 
						<td><%=admin.getConfirmPassword()%></td>
				</tr>
				
					
					<td>
						<form method="POST" action="getUser">
							<input type="hidden" name="email>"
								value="<%=session.getAttribute("email")%>" /> <input type="submit"
								value="Edit Admin" class="select-button" />
						</form>
					</td>
				</tr>

			</table>
		</div>

	</div>

	</div>
</body>
<%@include file="footer.jsp"%>
</html>

