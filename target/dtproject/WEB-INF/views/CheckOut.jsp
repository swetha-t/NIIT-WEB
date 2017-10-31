<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CheckOut Page</title>
  <link rel="stylesheet" href="resources/css/Pretty-Footer.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
</head>

<body style="background-color:#f0f4c3" data-gr-c-s-loaded="true">

<jsp:include page="header.jsp" />
                
                
<div class="container">
   <div class="col-xs-offset-2 col-xs-12">
             <div class="form-group">
                 <label style="color:#ff9800;" class="control-label" for="total"><h3><strong>Grand Total : ${total}</strong></h3></label>
                </div>
                </div>                    
        
            <div class="row .payment-dialog-row" id="checkOut-box">
                <div class="col-md-4 col-md-offset-4 col-xs-12">
                    <div class="panel panel-default credit-card-box">
                        <div class="panel-heading">
                            <h3 class="panel-title"><span class="panel-title-text"><b>Payment Details </b></span> <img class="img-responsive panel-title-image" src="C:\Users\swetha\Pictures\Saved Pictures\card.jpg" height="10%"></h3></div>
                        <div class="panel-body">
                        
                            <form:form action="invoice" id="payment-form" modelAttribute="card">
                            
                            
                            <h3 class="head text-center"><i>Billing address</i></h3>
                          <div class="row">
                          <div class="col-sm-12">
                          <div class="form-group">            
            <b> Name on Card</b>:<input type="text" class="form-control" name="first"  required > 
             
            
        
        </div>
                          </div>
                           <div class="col-sm-12">
                          <div class="form-group">            
         <b> Valid Card Number</b>:<input type="text" class="form-control" name="last"   required> 
           
        </div>
                          </div>
                          </div>
                       
                            <%-- <div class="row">
                                    <div class="col-xs-12">
                                      <div class="form-group">
                                        	<form:label class="control-label" path="card_name">Name on Card</form:label>
                                            <div class="input-group">
                                               <form:input class="form-control" type="text" required="required" placeholder="Name on Your Card" path="card_name"/>
                                                <div class="input-group-addon"><span><i class="fa fa-user"></i></span></div>
                                                </div>
                                             </div> 
                                        </div>
                                    </div>

                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                            <form:label class="control-label" path="card_number">Card number </form:label>
                                            <div class="input-group">
                                                <form:input class="form-control" type="tel" required="" placeholder="Valid Card Number" path="card_number"/>
                                                <div class="input-group-addon"><span><i class="fa fa-credit-card"></i></span></div>
                                                 </div>
                                        </div>
                                    </div>
                                </div> --%> 
                              <%--   <div class="alert alert-danger alert-dismissable fade in">
                                 <a href="#" class="close" data-dismiss="alert" aria-label="close">�</a>
                                 <strong><form:errors path="card_number"></form:errors></strong>
                                 </div> --%>
                                <div class="row">
                                    <div class="col-xs-9">
                                        <div class="form-group">
                                            <label class="control-label" for="cardExpiry"><span class="hidden-xs">Expiration </span><span class="visible-xs-inline">EXP </span> Date</label>
                                            <!-- <input class="form-control" type="tel" required="" placeholder="MM / YY" id="cardExpiry">
                                        --> <div class="row">
                                        <div class="col-xs-6">
                                         
              <select class="form-control col-sm-5" name="Expiry-month" placeholder="Month" id="expiry-month">
                <option>Month</option>
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
              </select>
            </div>
            <div class="col-xs-5">
              <select class="form-control" name="expiry-year" placeholder="year">
                <option>year</option>
                <option value="18">2018</option>
                <option value="19">2019</option>
                <option value="20">2020</option>
                <option value="21">2021</option>
                <option value="22">2022</option>
                <option value="23">2023</option>
                <option value="24">2024</option>
                <option value="25">2025</option>
                <option value="26">2026</option>
                <option value="27">2027</option>
                <option value="28">2028</option>
              </select>
            </div>
</div>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 pull-middle">
                                          <div class="form-group">
                                            <label class="control-label" for="cardCVC">CVV code</label>
                                            <input class="form-control" type="tel" required="" placeholder="CVV" id="cardCVC">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <button class="btn btn-success btn-block btn-lg" type="submit" >Pay With Card</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
   
   <br>
  

   <form:form action="CodInvoice" id="payment-form" modelAttribute="card">                         
  	<div class="row">
  	
      <div class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4">
        <button class="btn btn-warning btn-block" data-toggle="modal" data-target="#myModal" type="button">Cash on Delivery</button>
    </div></div></div>
    <div class="modal fade" id="myModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">�</span></button>
                    <h4 class="modal-title">Cash On Delivery</h4></div>
                <div class="modal-body">
                    <p>A delivery Charge of <Strong>Rs.99/-</Strong> is applicable for Cash on Delivery for orders below Rs.200/-</p>
                    <div class="col-xs-offset-2 col-xs-12">
             <div class="form-group">
                 <label class="control-label" for="total"><h3><strong>Grand Total : ${total}</strong></h3></label>
                </div>
                </div>                    
        
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                    <button class="btn btn-primary" type="submit">Agree & Place the Order</button>
                </div>
            </div>
        </div>
    </div>
   
 </form:form>
    </div>
    
    <div>
</div>
  
</body>
<jsp:include page="footer.jsp"/>
</html>