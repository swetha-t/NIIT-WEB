<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <style>
  body {
    background-color:black;
}
  </style>
</head>
<body>
  <c:import url="/WEB-INF/views/header.jsp" />>

<br>
<br>
<br>
<br>
<div id= "printableArea">
 
     <div class="container">
        <div class="well">     


		<table class ="table table-hover ">
		<thead>
		<tr>
	
	<th>Product image</th>
	<th>Product name</th>
	<th>product price</th>
	<th>Quantity</th>
	

	
	
</tr>
</thead>	
<tbody>	
<c:forEach items="${orderdetails}" var="cd">
		<tr>
		<td><img src="/dtproject/myImage/imageDisplay?id=${cd.productid}" alt="" width="200" height="200" /></td>
			<td>${cd.productname}</td>
			<td>${cd.productprice}</td>
			<td>${cd.quantity}</td>
			
			
		</tr>
</c:forEach>	
	</tbody>
	<tbody>
				<c:forEach items="${productList}" var="product" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${product.id}" /></td>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.price}" /></td>
						<td><c:out value="${product.quantity}" /></td>
						<td><c:out value="${product.image}" /></td>
						<td><nobr>	
	</nobr></td></tr></c:forEach>
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
       <a href="index" class="btn btn-danger" role="button">ContinueShopping</a>
     	</div>
 </div>
 
 
     <c:import url="/WEB-INF/views/footer.jsp" />>

</body>
</html>