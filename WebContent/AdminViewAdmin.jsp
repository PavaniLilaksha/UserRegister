<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="deleteU.css">
<title>View Admin</title>

<%
if(session.getAttribute("email")==null) 
%>
</head>
<body>

	<header>

	<div class="container">

	<div class="form">
			<form action="adminDeleteAdmin">
				<table class="table">

					<tr>
						<td>Admin Email</td>
						<td><input id="input" type="text"
							name="emailForView" required></td>
					</tr>
					<tr>
						<td></td>
						<td style="font-size: 20px; color: red;">${deleteError}</td>
					</tr>
				</table>
				<br /> <input type="submit" value="View" name="submitButton"
					id="dButton">
			</form>
		</div>


	</div>

</body><br><br><br><br>
<%@include file="footer.jsp"%>
</html>