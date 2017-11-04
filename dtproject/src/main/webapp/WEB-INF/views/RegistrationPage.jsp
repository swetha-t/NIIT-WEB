<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Signup Page</title>
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

    <jsp:include page="header.jsp" />

<!-- <h3 align="center">SIGNUP</h1> -->
<c:url var="actionUrl" value="saveUser" />

<form:form  commandName="user" method="post" action="${actionUrl }" class="form-horizontal" >


	<div class="form-group">
		<label for="First Name" class="col-xs-4 control-label">First Name</label>
		<div class="col-xs-4">
			<form:input name="id" path="firstName" placeholder="User First Name" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="First Name" class="col-xs-4 control-label">Last Name</label>
		<div class="col-xs-4">
			<form:input name="id" path="lastName" placeholder="User Last Name" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="Supplier Name" class="col-xs-4 control-label">Email</label>
		<div class="col-xs-4">
			<form:input name="id" path="email" placeholder="User Name" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Password</label>
		<div class="col-xs-4">
			<form:input name="password"  path="password" placeholder="User Password" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Phone Number</label>
		<div class="col-xs-4">
			<form:input name="phone"  path="phone" placeholder="User Phone" class="form-control" />
		</div>
	</div>

	<!-- <div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		
		<div class="col-xs-4">
			
		<input type="submit" value="Add User" id="btn-add" class="btn btn-primary" >
	
	</div>
	</div> -->
	
	<div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
	 <div class="col-xs-4"> 
    <button type="submit" class="btn btn-success" value="Submit">Signup</button>
    <button type="reset" class="btn btn-success" value="Reset">Cancel</button>
    <br>
   <span>Forgot     <a href="#">password?</a></span>
   </div>
   </form>
  <br>
 <div class="col-sm-12">
 <p align="center">
 <a href="#"><img src="C:\Users\swetha\Pictures\Saved Pictures\signup.png" width="250" class="img-responsive"> </a>   
 </p>  
</div>
  </div>



    </div>
 </div>
</div>
</form:form>
  <jsp:include page="footer.jsp"/>
</body>
</html>