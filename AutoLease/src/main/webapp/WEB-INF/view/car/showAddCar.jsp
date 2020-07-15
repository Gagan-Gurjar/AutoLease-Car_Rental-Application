<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a car</title>

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
	href="${pageContext.request.contextPath}/resources/static/css/showAddCar-style.css">

</head>

<body>
	<div id="container">
		<!-- NAVBAR -->

		<nav>
			<div class="nav">
				<div class="part-1">
					<img
						src="${pageContext.request.contextPath}/resources/static/images/AL-Logo2.jpg">
				</div>
				<div class="part-2">
					<ul>
						<li><a href="${pageContext.request.contextPath}/back">Back</a></li>
						<li><a href="<c:url value="/logout" />">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<!-- ADD SECTION  -->
		<div class="add-car">
		<div class="car">
                Add a Car
            </div>
			<div class="msg">${msg}</div>
			<div class="form">
				<form:form action="saveCar" method="POST"
					enctype="multipart/form-data">
					<p>
						Company Name: <input type="text" name="companyName" />
					</p>
					<p>
						Car Name: <input type="text" name="carName" />
					</p>
					<p>
						Car Number: <input type="text" name="carNumber" />
					</p>
					<p>
						Fuel Type: <span class="fuel-type">Petrol</span><input
							type="radio" name="fuelType" value="Petrol" required /> <span
							class="fuel-type">Diesel</span><input type="radio"
							name="fuelType" value="Diesel" />
					</p>
					<p>
						Seater: <input type="text" name="seat" />
					</p>
					<p>
						Price: <input type="text" name="price" />
					</p>
					<p>
						City: <select name="city">
							<c:forEach items="${locations}" var="location">
								<option value="${location.locationName}">${location.locationName}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						Image <input type="file" name="image" />
					</p>
					<p>
						<input class="btn1" type="submit" value="Submit">
					</p>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>