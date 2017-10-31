<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="resources/css/Pretty-Footer.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Footer.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Registration-Form.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Google-Style-Login.css"/>">
</head>
  
</head>
<body>

<jsp:include page="header.jsp" />

<form  method="post" action="j_spring_security_check" class="form-horizontal" >

<h1 align="center">LOGIN</h1>
	<div class="form-group">
		<label for="User Email" class="col-xs-4 control-label">Email</label>
		<div class="col-xs-4">
			<input name="j_username" type="email"  placeholder=" User Email" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Password</label>
		<div class="col-xs-4">
			<input name="j_password"  type="password" placeholder="User Password" class="form-control" />
		</div>
	</div>
            
            <div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		
		<div class="col-xs-4">	
		<input type="submit" value="Login" id="btn-add" class="btn btn-primary" >
		</div>
	</div> 
            
            <div class="checkbox">
                <div class="checkbox">
                    <label>
                        <input type="checkbox">Remember me</label>
                </div>
            </div>
            
            
            
            
            
            
            
            <!-- <button class="btn btn-primary  btn-lg btn-signin" type="submit"><span class="glyphicon glyphicon-off"></span>Sign in</button> -->
            <div >
            ${error}
			${logout }
            </div>
        <form><a href="#" class="forgot-password">Forgot your password?</a></form>
        
        

	<!-- <div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		
		<div class="col-xs-4">	
		<input type="submit" value="Login" id="btn-add" class="btn btn-primary" >
		</div>
	</div> -->
</form>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
<jsp:include page="footer.jsp" />
  <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>

 
</body>

</html>