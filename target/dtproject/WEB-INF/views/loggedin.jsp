<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Example of Bootstrap 3 Dropdowns within a Navbar</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>

<div class="bs-example">
    <nav id="myNavbar" class="navbar navbar-inverse" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="loggedin">Home</a></li>
                    <li><a href="#">Profile</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Messages <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">Inbox</a></li>
                            <li><a href="#">Drafts</a></li>
                            <li><a href="#">Sent Items</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Trash</a></li>
                            
                        </ul>
                    </li>
                </ul>
                             <ul class="nav navbar-nav">
                    
                    <li><a href="viewcart">Cart</a></li>
               </ul>    
                            
                <ul class="nav navbar-nav navbar-right">
                  
                        <li><a href="#">LoggedIn</a></li>
                        
                            <!-- <li><a href="logout">Logout</a></li> -->
                         
                             <li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
                            
                
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>
<div class="container">
		<c:forEach items="${ProductList}" var="product">
			<h2 style="color: red">
				<c:out value="${product.name }" />
			</h2>


			<div class="row">
										<img src="/ECommFrontEnd/myImage/imageDisplay?id=${product.id}"
											class="img-responsive" style="width: 180px; height: 120px">
										<div>				</div>
			</div>

			<div class="col-xs-4 ">
				<div class="img">
					<div class="desc">
						<p>
						<div class="form-group">
							<input type="text"style="width: 300px;" class="form-control" value="${product.name}"
								readonly="readonly">
						</div>

						<div class="form-group">
							<input type="text"style="width: 300px;"  class="form-control"
								value="Rs. ${product.price}" readonly="readonly">
						</div>
						<div class="form-group">
							<input type="text"style="width: 300px;"  class="form-control"
								value="${product.description}" readonly="readonly">
						</div>
						<div>

                								<form action="addtoCart/${product.id}">
										<input type="submit" value="Add to Cart" class="btn btn-primary" >

									</form>
							

						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>   