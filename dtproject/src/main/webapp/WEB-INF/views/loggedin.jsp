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
                <a class="navbar-brand" href="#">Hot Mobile</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">Home</a></li>
                   
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">About <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">Organization</a></li>
                            <li><a href="#">Alerts</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Services</a></li>
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
          
        <div class="row">
<c:forEach items="${ProductList}" var="product">     
            <div class="col-sm-4">
                <div class="panel panel-primary">
             <div class="panel-body"> <img src="/dtproject/myImage/imageDisplay?id=${product.id}" class="img-responsive" img height="75 alt="Image"></div>
                <%-- <img src="<c:url value="/resources/assets/img/rv_1-gito-1.jpg"/>">
                    --%> <div class="caption">
                        <h3>${product.name}</h3>
                        <ul>
                         <p>${product.description}</p>
                        <li>Price: Rs.<Strong>${product.price}</Strong></li>
                       
     
                   <form:form action="addtoCart/${product.id}" method="POST">
                                <input type="submit" value="Add to Cart" class="btn btn-primary">
                                </form:form>
                                
                                </ul>
                            </div>
                        </div>
                    </div>
         
           </c:forEach>       
                </div>
                
         
        </div>
        <br><br><br>
<jsp:include page="footer.jsp" />
</body>
</html>   