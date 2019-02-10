<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylerr.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" type="text/css" href="footer.css">
<title>Admin Register</title>
</head>
<body><br>
	<header>
	
			<div class="row">
				<div class="logo"></div>

			
			</div>
			<form action="RegisterAdmin" method="post" >
			<div class="register">
				<h2>Admin Register Here</h2>
			
				
				<label> First Name</label><br>
				<input type="text" name="fname" id="name" placeholder="Enter First Name"><br><br>
				
				<label> Last Name</label><br>
				<input type="text" name="lname" id="name" placeholder="Enter Lirst Name"><br><br>
				
				<label> Mobile Number</label><br>
				<select id="ph">
					<option>+91</option>
					<option>+92</option>
					<option>+93</option>
					<option>+94</option>
					<option>+95</option>
				</select>
				<input type="number" name="MNum" id="num" placeholder="Enter Mobile Number"><br><br>
				
				<label> Email</label><br>
				<input type="email" name="email" id="name" placeholder="Enter Email"><br><br>
				
				<label> Password</label><br>
				<input type="password" name="pass" id="name" placeholder="Enter Password"><br><br>
				
				<label> Confirm Password</label><br>
				<input type="password" name="pass2" id="name" placeholder="Re-Enter Password"><br><br>
				
				<input type="radio" name="gender" id="male">
				<span id="male"> &nbsp; Male</span>&nbsp;&nbsp;
				<input type="radio" name="gender" id="male">
				<span id="fmale"> &nbsp; Female</span>&nbsp;&nbsp;<br><br>
			
				<input type="submit" value="Submit" id="sub"><br><br>	
			
			</form>
			</div>
			
	
</body>
<%@include file="footer.jsp" %>

</body>
</html>