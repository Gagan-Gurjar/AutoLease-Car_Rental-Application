<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>

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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/showUpdateCarPage-style.css">

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
						<li><a
							href="${pageContext.request.contextPath}/showEditCarsByLocation">Back</a></li>
						<li><a href="<c:url value="/logout"/>">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<!-- CAR DISPLAY SECTION   -->

		<div class="car-box">
			<div class="msg">${msg}</div>
			<div class="form">
				<form:form action="updateCar" method="POST"
					enctype="multipart/form-data">
					<div class="img">
						<img src="data:image/jpg;base64,${image}" alt="">
					</div>
					<p>
						<span class="tag">Id:</span> <input type="text" name="id"
							value="${car.id}" readonly />
					</p>
					<p>
						<span class="tag">Car Name:</span> <input type="text"
							name="carName" value="${car.carName}" />
					</p>
					<p>
						<span class="tag">Company Name:</span> <input type="text"
							name="companyName" value="${car.companyName}" />
					</p>
					<p>
						<span class="tag">Car Number:</span> <input type="text"
							name="carNumber" value="${car.carNumber}" />
					</p>
					<p>
						<span class="tag">Price:</span> <input type="text" name="price"
							value="${car.price}" />
					</p>
					<p>
						<span class="tag">Seater:</span> <input type="text" name="seat"
							value="${car.seat}" />
					</p>
					<p>
						<span class="fuel-tag">Fuel Type:</span><br> <span
							class="fuel">Petrol</span><input type="radio" name="fuelType"
							value="Petrol"
							${car.fuelType=='Petrol'
                            ?'checked':''} />
						<span class="fuel ">Diesel</span><input type="radio"
							name="fuelType" value="Diesel"
							${car.fuelType=='Diesel'
                            ?'checked':''} />
					</p>
					<p>
						<span class="tag">Select Image:</span> <input type="file"
							name="photo" />
					</p>
					<p>
						<span class="tag">Enable</span><input type="radio" name="disable"
							value="true" ${car.disable=='false' ?'checked':''} /> <span
							class="tag">Disable</span><input type="radio" name="disable"
							value="false" ${car.disable=='true' ?'checked':''} />
					</p>
					<p>
						<input class="btn1" type="submit" value="Save" />
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