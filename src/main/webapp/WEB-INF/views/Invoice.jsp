<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
 <link rel="stylesheet" href="resources/css/Pretty-Footer.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand navbar-link" href="#"><img src="resources/assets/img/90a3d103aa1d8fc2bff6448dcd2edc53.svg" width="70px" id="logo"> N Bakes &amp; Cakes</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#" data-hover="dropdown">Menu<i class="glyphicon glyphicon-align-justify"></i> <span class="caret hidden"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        <c:forEach items="${categoryList}" var="category">
                            <li role="presentation"><a href="product${category.id}">${category.categoryName}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

 			 <sec:authorize access="!isAuthenticated()">                
 	    			<li role="presentation"><a href="login">Login <i class="glyphicon glyphicon-log-in"></i></a></li>
                    <li role="presentation"><a href="signup">SignUp <i class="glyphicon glyphicon-user"></i></a></li>
             </sec:authorize>
            
             <sec:authorize access="isAuthenticated()">
            		  <!-- <li class="active" role="presentation"><a href="cart">Shop<i class="glyphicon glyphicon-shopping-cart"></i></a></li>
                       --><li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
             </sec:authorize>

                </ul>
            </div>
        </div>
    </nav>

<br>
<br>
<br>
<br>
<div id= "printableArea">
 <form:form modelAttribute="user" commandName="user">
<div class="container">
        <div class="well">
       
            <div class="row">
            
                <div class="col-md-4">
                    <label>Name:${user.name} </label>
                </div> 
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label>email:${user.email} </label>
                </div>
            </div>
            <div class="row">
    	            <div class="col-md-4">
                    <label>contact no:${user.contact_number} </label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label>Shipping Address:${user.address} </label>
                </div>
            </div>
            <hr>
        </div>
    </div>
    </form:form>
     <div class="container">
        <div class="well">     


		<table class ="table table-hover ">
		<thead>
		<tr>
	
	<th>Product image</th>
	<th>Product name</th>
	<th>product price</th>
	<th>Quantity</th>
	<th>SubTotal</th>

	
	
</tr>
</thead>	
<tbody>	
<c:forEach items="${cd}" var="cd">
		<tr>
		<td><img src="/Bakersfrontend/myImage/imageDisplay?id=${cd.productid}" alt="" width="200" height="200" /></td>
			<td>${cd.productname}</td>
			<td>${cd.productprice}</td>
			<td>${cd.quantity}</td>
			<td>${cd.subTotal}</td>	
			
		</tr>
</c:forEach>	
	</tbody>	
	
</table>
     <div class='form-control'>
     
                  Total:  <span class='amount'>Rs.${total}${cod}</span>
     </div>  
 
  
</div>
</div>
</div>
<div class="row">
<div class="col-md-offset-2 col-md-2">
<button class="btn btn-info" onclick="printDiv('printableArea')"><span class="glyphicon glyphicon-print"></span>Print Invoice</button>
</div>
		<div class="col-md-4">
       <a href="index" class="btn btn-danger" role="button">Continue Shopping</a>
     	</div>
 </div>
</body>
</html>