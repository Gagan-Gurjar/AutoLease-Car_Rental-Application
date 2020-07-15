<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Confirmation</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/OTP-style.css">
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
		
		<!-- OTP FIELD  -->
		<div class="otp-box">
			<form action="user/confirmRegistration"  method="POST" ></form>
				<!-- <div class="error">${error}</div> -->
				<div class="input-field">
					<div class="text">One Time Password:</div>
					<input name="userOTP" placeholder="6-digit code"/>
					<input type="hidden" name="adminOTP" value="${otp}" />
				</div>
				<input type="hidden" name="firstName" value="${user.firstName}" />
				<input type="hidden" name="lastName" value="${user.lastName}" />
				<input type="hidden" name="email" value="${user.email}" />
				<input type="hidden" name="password" value="${user.password}" />
				<input type="hidden" name="phone" value="${user.phone}" />
				<input type="hidden" name="age" value="${user.age}" />
				<input type="hidden" name="gender" value="${user.gender}" />
				
				<div class="btn-box">
					<input class="btn1 btn-primary btn-block btn-large" type="submit" value="Submit">
				</div>
			</form>
		</div>
		<div class="register-page">
			Back to Registration Page <a href="showRegister">Click Here</a><br/>
		</div>
	</div>
</body>
</html>