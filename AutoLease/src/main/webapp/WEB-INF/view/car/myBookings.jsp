<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Bookings</title>

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


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/myBookings-style.css">

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
						<li><a href="${pageContext.request.contextPath}/back">Back</a></li>
						<li><a href="<c:url value="/logout" />">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- CARS DISPLAY SECTION  -->

		<div class="list-container">
			<p class="msg">${msg}</p>
			<div class="car-list">

				<c:forEach items="${bookings}" var="book">
					<div class="car-column">
						<div class="img">
							<img src="data:image/jpg;base64,${book.image}" alt="">
						</div>
						<p>Car Name : ${book.car.carName}</p>
						<p>Company Name : ${book.car.companyName}</p>
						<p>Customer's Name : ${book.booking.name}</p>
						<p>Customer's Email : ${book.booking.email}</p>
						<p>Driver : ${book.booking.driver}</p>
						<p>Date : ${book.booking.date}</p>
						<p>Time : ${book.booking.time}</p>
						<p>Hour(s) : ${book.booking.hour}</p>
						<p>Amount: ${book.booking.amount}</p>
						<p class="cancel">
							<c:choose>
								<c:when test="${book.booking.cancel == 'yes'}">
					            	<span class="red">Booking Cancelled</span>
					            </c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/cancelBooking?bookingId=${book.booking.id}&userId=${book.booking.userId}">Cancel
										Booking</a>
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<!-- FOOTER  -->

	<footer>
		<div class="footer">
			<div id="contact-us">
				<div class="contact">
					<span>Contact Us</span>
					<ul>
						<li>325, MP Nagar zone-2 Bhopal(M.P)</li>
						<li>+91 9876543210</li>
						<li>autolease2020@gmail.com</li>

					</ul>
				</div>
				<div class="follow">
					<span>Follow Us </span>
					<ul>
						<li>Instagram</li>
						<li>Twitter</li>
						<li>Facebook</li>
					</ul>

				</div>
			</div>
			<div class="copy">Copyright &copy; AutoLease 2020</div>
		</div>
	</footer>
</body>
</html>