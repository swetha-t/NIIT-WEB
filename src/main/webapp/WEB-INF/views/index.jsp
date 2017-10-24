<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.bs-example{
    	margin: 20px;
    }
</style>
<%-- <jsp:include page="showProduct.jsp" />  --%>

</head>
<body>
${ExistingMessage}
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
                    <li><a href="#">Home</a></li>
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
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle"> <span class="glyphicon glyphicon-user"></span>Sign Up <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <p><a href="login"><span  class="glyphicon glyphicon-log-in"></span>Log in </a></p>
                          <p><a href="register"> <span class="glyphicon glyphicon-user"></span>Registration</a></p>
          
                        
      <p><a href="<c:url value="j_spring_security_logout"/>"><span  class="glyphicon glyphicon-log-out"></span>LogOut </a></p>               
 
 
  
                          
                        </ul>
                    </li>
                </ul>
                    
            </div>
        </div>
    </nav>
</div>


<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="3" class="active"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img class="img-rounded" class="img-responsive center-block"
      src="C:\Users\swetha\Pictures\Saved Pictures\1.jpg" style="width:100%" "height="50%">
    </div>

    <div class="item">
    <img class="img-rounded" class="img-responsive center-block"
      src="C:\Users\swetha\Pictures\Saved Pictures\2.png" style="width:100%" "height="50%">
    </div>

    <div class="item">
    <img class="img-rounded" class="img-responsive center-block"
      src="C:\Users\swetha\Pictures\Saved Pictures\3.jpg" style="width:100%" "height="20%">
    </div>
 
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>




<!-- =================================-->

<div class="container">
		<c:forEach items="${ProductList}" var="product">
			<h2 style="color: red">
				<c:out value="${product.name }" />
			</h2>


			<div class="pi-img-wrapper">
										<img src="/Shoppingcart/myImage/imageDisplay?id=${product.id}"
											class="img-responsive" style="width: 100px; height: 100px">
										<div>				</div>
			</div>

			<div class="col-xs-4 ">
				<div class="img">
					<div class="desc">
						<p>
						<div class="form-group">
							<input type="text" class="form-control" value="${product.name}"
								readonly="readonly">
						</div>

						<div class="form-group">
							<input type="text" class="form-control"
								value="Rs. ${product.price}" readonly="readonly">
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
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
	</div>
	</br>
	</br>

</body>

</html>   