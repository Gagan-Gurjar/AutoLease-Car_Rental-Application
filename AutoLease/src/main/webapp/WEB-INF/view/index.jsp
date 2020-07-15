<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/index-style.css">

<!--  ${pageContext.request.contextPath}/resources/static/css/index-style.css-->
    <title>Auto Lease</title>
</head>
<body>
    <div id="container">
        <nav>
            <div class="nav">  
                <div class="part-1"> 
                    <img src="${pageContext.request.contextPath}/resources/static/images/AL-Logo2.jpg">
                </div> 
                <div class="part-2">    
                    <ul>
                        <li><a href="#car-list">Cars</a></li>
                        <li><a href="#about-us">About</a></li>
                        <li><a href="loginSuccess">Login</a></li>
                        <li><a href="showRegister">Register</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!-- CAROUSEL -->

        <div class="slideshow">
            
                            
            <div id="main-slider" class="carousel slide" data-ride="carousel" data-interval="2000" data-pause="false">
                
                <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
                <li data-target="#main-slider" data-slide-to="3"></li>
                </ol>
                
                <div class="carousel-inner">
                    
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath}/resources/static/images/car1.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/resources/static/images/car2.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/resources/static/images/car3.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/resources/static/images/car4.jpg" class="d-block w-100" alt="...">
                    </div>
                    
                </div>
                <a class="carousel-control-prev" href="#main-slider" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#main-slider" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <p class="mind">Enjoy your trip with AutoLease</p>
                
        </div>
    

        <!-- CARS LIST -->
        <section id="car-list">
            <div class="list-header">
                Cars List
            </div>
            
            
	            <div class="list-container">
	            <c:forEach items="${cars}" var="car">
	                <div class="car">
	                    <ul>
	                        <li>
	                            <img src="data:image/jpg;base64,${car.value}" alt="">
	                        </li>
	                        <li>
	                            Company Name: ${car.key.companyName}
	                        </li>
	                        <li>
	                            Name: ${car.key.carName}
	                        </li>
	                        <li>
	                            Price: ${car.key.price}/Hr
	                        </li>
	                        <li>
	                            Fuel Type: ${car.key.fuelType}
	                        </li>
	                        <li>
	                            Seating Capacity: ${car.key.seat}
	                        </li>
	                        <li>
	                        	<a href="showLogin">Book Now</a>
	                        </li>
	                    </ul>
	                </div>
	         </c:forEach>

                
            </div>
        </section>

        <!-- ABOUT US -->

        <section id="about-us">
            <span>About Us</span> 
            <div class="about">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut cum explicabo veniam maxime deleniti alias doloremque aspernatur ea reiciendis, recusandae praesentium dolorum eum? Earum nisi necessitatibus nobis? Quisquam, exercitationem doloremque?
            </div>
        </section>
    </div>
    
    <!-- FOOTER  -->
    <footer>
        <div class="footer">
            <div id="contact-us">
                <div class="contact">
                    <span>Contact Us</span>
                    <ul>
                        <li>
                            325, MP Nagar zone-2 Bhopal(M.P)
                        </li>
                        <li>
                            +91 9876543210
                        </li>
                        <li>
                            autolease2020@gmail.com
                        </li>

                    </ul>
                </div>
                <div class="follow">
                    <span>Follow Us </span>
                    <ul>
                        <li>
                            Instagram
                        </li>
                        <li>
                            Twitter
                        </li>
                        <li>
                            Facebook
                        </li>
                    </ul>

                </div>
            </div>
            <div class="copy">
                Copyright &copy; AutoLease 2020
            </div>
        </div>
    </footer>


    
</body>
</html>