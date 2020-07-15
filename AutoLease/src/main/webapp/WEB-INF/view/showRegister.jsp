<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/register-style.css">

</head>

<body>
	<div id="container">
		<!-- NAVBAR -->

		<nav>
			<div class="nav">
				<div class="part-1">
					<img src="${pageContext.request.contextPath}/resources/static/images/AL-Logo2.jpg">
				</div>
				<div class="part-2">
					<ul>
						<li><a href="backHome">Home</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<!-- Registration  -->
		<section id="register-box">
			<div class="register">
				<h1>Registration</h1>
				<div class="lable">

					<form:form action="processForm" modelAttribute="user" method="POST">
		<form:errors path="firstName"></form:errors>
		<form:input path="firstName" placeholder="First Name"
							required="required" />
			
		<form:errors path="firstName"></form:errors>			
		<form:input path="lastName" placeholder="Last Name"
							required="required" />
						
		<!-- Gender:<br> -->
		
		<form:errors path="age" />
		<div class="age">Age</div>				
		<form:input type="number" path="age" placeholder="Age" required="required" />
						
		<form:errors path="gender" />				
		<div class="radio">
                        <div class="radio-inline">
                            <div class="box">
                                <form:radiobutton path="gender" value="Male" name="gender" checked="checked" />
                            </div>  
                            <div class="text">
                                Male
                            </div> 
                        </div>
                        <div class="radio-inline">
                            <div class="box">
                                <form:radiobutton path="gender" value="Female" name="gender"/>
                            </div>
                            <div class="text">
                                Female
                            </div>
                        </div>
                        <div class="radio-inline">
                            <div class="box">
                                <form:radiobutton path="gender" value="Others" name="gender"/>
                            </div>
                            <div class="text">
                                Others
                            </div>
                        </div>
                    </div>
						
		<form:errors path="email" />
		<form:input path="email" placeholder="Email"
							required="required" />
						
		<form:errors path="password" />
		<form:input type="password" path="password"
							placeholder="Password" required="required" />
						
		<form:errors path="phone" />
		<form:input path="phone" placeholder="Phone No."
							required="required" />
						
						<span>${userExists}</span>

						<input type="submit" value="Submit"
							class="btn1 btn-primary btn-block btn-large">

					</form:form>
					<a href="showLogin" class="register">Go to Login Page</a>
				</div>
			</div>
		</section>


	</div>
</body>
</html>