<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/loginSuccess-style.css">
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
                        <li><a href="<c:url value="/logout" />">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="login-msg">
            Login Successful
        </div>
        <div class="welcome-msg">
            Welcome to AutoLease!
        </div>

        <!-- FORM SECTION  -->
        <section class="forms">
            <div class="booking-form">
                <p class="box-heading">Book a car now</p>
                <div class="booking-container">
                    <form action="${pageContext.request.contextPath}/user/bookNow" method="GET">
                        <div class="city">
                            <p class="mobile-no">Select City :</p><select name="city">
                            <c:forEach items="${locations}" var="location">
                                <option value="${location.locationName}">${location.locationName}</option>
                            </c:forEach>
                            </select> <br> <br>
                        </div>
                        <div class="mobile">
                            <p class="mobile-no">Enter Mobile No.</p><input type="text" name="mobile" />
                        </div>
                        <input class="btn1 btn-primary btn-block btn-large" type="submit" value="Book Now" />
                    </form>
                </div>
            </div>
            
            <div class="booking-form"> 
                <p class="box-heading">Check your bookings</p>
                <div class="booking-container mybooking">
                    <form action="${pageContext.request.contextPath}/user/showMyBooking" method="GET" >
                       <p class="mobile-no">Enter Mobile No.</p><input type="text" name="mobile" />
                        <input class="btn1 btn-primary btn-block btn-large" type="submit" value="My Bookings" />
                    </form>
                </div>
            </div>
        </section>

        <!-- ADMIN SECTION  -->

        <section class="admin-section">
            <sec:authorize access="hasAuthority('ADMIN')">
                <div class="admin-heading">
                    Hello Admin!
                </div>
                <div class="admin-option">
                    Admin's Options
                </div>
                <div class="options-list">
                    <div class="option"><a href="${pageContext.request.contextPath}/showAddCar" >Add a new Car</a></div>
                    <div class="option"><a href="${pageContext.request.contextPath}/showEditCarsByLocation" >Edit existing Car</a></div>
                </div>
            </sec:authorize>
        </section>
    </div>
</body>
</html>