<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>

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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/paymentPage-style.css">
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

		<!-- PAYMENT SECTION -->
		<div class="payment-box">
			<div class="header">PAYMENT MODE SELECTION</div>
			<div class="payment-mode">Amount to be pay: Rs ${price}</div>
			<div class="payment-form">
				<form:form action="${pageContext.request.contextPath}/bookingDone"
					method="POST">
					<div class="dropdown">
						Select Payment Method : <select name="paymentMethod">
							<option value="Cash">Cash</option>
							<option value="Net Banking">Net Banking</option>
							<option value="Debit/ATM Card">Debit/ATM Card</option>
							<option value="Credit Card">Credit Card</option>
						</select>
					</div>
					<input type="hidden" name="name" value="${booking.name}" />
					<input type="hidden" name="email" value="${booking.email}" />
					<input type="hidden" name="driver" value="${booking.driver}" />
					<input type="hidden" name="hour" value="${booking.hour}" />
					<input type="hidden" name="date" value="${booking.date}" />
					<input type="hidden" name="time" value="${booking.time}" />
					<input type="hidden" name="carId" value="${booking.carId}" />
					<input type="hidden" name="userId" value="${booking.userId}" />
					<input type="hidden" name="licenceNumber"
						value="${booking.licenceNumber}" />
					<input type="hidden" name="amount" value="${price}" />
					<p class="submit-btn">
						<input class="btn1" type="submit" value="Submit">
					</p>
				</form:form>
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