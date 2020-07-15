<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login-style.css">

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

        <!-- LOGIN  -->
        
        <section id="login-box">
            <div class="msg">${msg}<br>
            <c:if test="${param.error != null}">
			<i>Invalid username/password. Please Try Again!</i>
		</c:if></div>
			<div class="sucessMsg">
			${successMsg}
			</div>
            <form:form action="login" method="POST">
               <div class="login">    
                    <h1>LOGIN</h1>
                    <div class="lable">
                        <input type="text" name="username" placeholder="Username" required="required" />
                        <input type="password" name="password" placeholder="Password" required="required" />
                    
                        <input type="submit" value="Login" class="btn1 btn-primary btn-block btn-large" />       
                        <a href="showRegister" class="register">Register Now</a>                        
                    </div>
                </div>
            </form:form>
        </section>


    </div>

</body>
</html>