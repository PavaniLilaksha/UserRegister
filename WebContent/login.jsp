<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link href="stylell.css" rel="stylesheet" type="text/css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>

	<header>
	
			<div class="row">
				<div class="logo"></div>
											
				<ul class="main-nav"><br><br>
				<li><a herf="index.jsp"> Home </a></li>
				<li><a herf=""> Room Booking </a></li>
				<li><a herf=""> Event Booking </a></li>
				<li><a herf="About us.jsp"> About Us </a></li>
				<li><a herf="Contact us.jsp"> Contact Us </a></li>		
			
			</ul>	
				
				
		<div class="login">
			<h1 id="log">Login</h1>
			<img id="lin" src="Pics/Lin.png" class="lin"><br>
					<form action="loginCheck" method="get" id="form">
					<p>Email</p>
					<input type="text" name="username" placeholder="Enter Email"><br><br>
					
					<p>Password</p>
					<input type="password" name="password" placeholder="Enter Password"><br><br>
					
					<input type="submit" name="Submit" value="Login"><br><br>
					<a href="getUser.jsp">Forgot Password</a>
					
					</form>
			</div>

</body>
</html>