<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>e-channeling</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
*{
    padding: 0px;
    margin: 0px;
    box-sizing: border-box;
    list-style: none;
    font-family: 'Poppins', sans-serif;
}

.navbar{
    width: 100%;
    height: 80px;
    background-color: #fee;
    display: flex;
    justify-content: space-around;
    align-items: center;
    color: #000;
}
.menu ul{
    display: flex;
    align-items: center;
}
.menu ul li a{
    text-decoration: none;
    color: #000;
    padding: 5px 12px;
    letter-spacing: 2px;
    font-size: 18px;
}
.menu ul li a:hover{
    border-bottom: 4px solid #000;
    transition: 0.4s;
}
.login a{
    text-decoration: none;
    color: #000;
    font-size: 18px;
    font-weight: bold;
    border-radius: 12px;
    padding: 12px 30px;
    border: 2px solid #b61ee9;
}
.login a:hover{
   background-color: #b61ee9;
   transition: 0.6s; 
}




.footer{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}
.fcontainer{
    background-color: black;
}
.row{
    display: flex;
    justify-content: space-between;
    padding: 40px 100px;
}
.footer-col ul{
    list-style: none;
}
.footer-col h4{
    color: white;
    margin-top: 25px;
    font-size: 22px;
    position: relative;
    font-family: 'Ubuntu', sans-serif;
}
.footer-col h3::before{
    content: '';
    width: 70px;
    height: 2px;
    position: absolute;
    background-color: #b61ee9;
    bottom: -10px;
}
.footer-col ul li{
    padding: 10px 0;
}
.footer-col ul li a{
    color: white;
    text-decoration: none;
    font-size: 16px;
    opacity: 0.7;
    transition: 0.5s;
}
.footer-col ul li a:hover{
    opacity: 1;
}
.footer-col form input{
    border: none;
    width: 250px;
    height: 45px;
    display: block;
    padding-left: 20px;
    margin: 14px 0;
}
.footer-col .inputSubmit{
    padding: 0px 20px;
    background-color: #b61ee9;
    border: none;
    color: white;
}
.col p{
    color: white;
}
.row hr{
    opacity: 0.7;
}
.row .socialIcons i{
    display: inline-block;
    color: white;
    font-size: 20px;
    margin: 0 15px;
    transition: 0.5s;
}
.row .socialIcons i:hover{
    color: #b61ee9; 
}
@media (max-width: 600px){
    footer .row{
        flex-direction: column;
        padding: 20px 30px;
    }

    footer .footer-col ul{
        margin-left: 20px;
        margin-bottom: 20px;
    }
    .footer-col input{
        width: 100%;
    }
}
</style>
</head>
<body>
<!---Header-->
        <header>
            
            <div class="navbar">
                <div class="logo">
                    <h1>E-Channeling</h1>    
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Channeling</a></li>
                        <li><a href="labtest-form.jsp">Lab Test</a></li>
                        <li><a href="#">Order Medicine</a></li>
                        <li><a href="#">Claim Refund</a></li>
                        <li><a href="#">Contact Us</a></li>    
                    </ul>               
                </div>
                <div class="login">
                    <a href="#">Login</a>
                    <a href="#">Register</a>
                </div>
            </div>
        </header>
    <!----Header End-->
	
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Lab Tests</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Lab Test</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Area</th>
						<th>Test</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="labtest" items="${listLabTest}">

						<tr>
							<td><c:out value="${labtest.id}" /></td>
							<td><c:out value="${labtest.name}" /></td>
							<td><c:out value="${labtest.area}" /></td>
							<td><c:out value="${labtest.lab}" /></td>
							<td><c:out value="${labtest.email}" /></td>
							<td><c:out value="${labtest.phone}" /></td>
							<td><a href="edit?id=<c:out value='${labtest.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${labtest.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<!---Footer-->
    <section>
        <footer class="footer">
            <div class="fcontainer">
                <div class="row">
                    <!--1st column-->
                    <div class="footer-col">
                        <h4>Pages</h4>
                        <ul>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                    <!--2nd column-->
                    <div class="footer-col">
                        <ul>
                            <br>
                            <br>
                            <li><a href="#">Promotions</a></li>
                            <li><a href="#">Careers</a></li>
                            <li><a href="#">News</a></li>
                            <li><a href="#">FAQs</a></li>
                        </ul>
                    </div>
                    <!--3rd column-->
                    <div class="footer-col">
                        <h4>Office</h4>
                        <ul>
                            <li><a href="">312, Galle Rd</a></li>
                            <li><a href="">Kollupitiya</a></li>
                            <li><a href="">+97 123134235</a></li>
                            <li><a href="">support@echanneling.com</a></li>
                        </ul>
                    </div>
                    <!--4th column-->
                    <div class="footer-col">
                        <h4>Newsletter</h4>
                        <form action="">
                            <input type="text" placeholder="Your Name" class="inputName">
                            <input type="email" placeholder="Your Email" class="inputEmail">
                            <input type="submit" value="submit" class="inputSubmit">
                        </form>   
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        <p>&#169; 2023 E-Channeling. All Rights Reserved.</p>
                    </div>
                    <div class="socialIcons">
                        <a href=""><i class="fa-brands fa-facebook"></i></a>
                        <a href=""><i class="fa-brands fa-instagram"></i></a>
                        <a href=""><i class="fa-brands fa-twitter"></i></a>
                        <a href=""><i class="fa-brands fa-youtube"></i></a>
                    </div>
                </div>
            </div>
        </footer>
    </section>
    <!---Footer End-->
</body>
</html>
