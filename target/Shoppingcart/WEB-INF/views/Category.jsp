<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="addCategory" modelAttribute="category" method="post">

	<form:label path="category_Name">Category Name: </form:label>
	<form:input type="text" path="category_Name"/>
	
	<form:label path="category_Description"> Category Desc: </form:label>
	<form:textarea path="category_Description"/>
	
	<form:button type="submit">Submit</form:button>
	
	<br>
	<br>
	<br>
	<table border="2">
	<thead>
	<tr>
					<th width="2%" style="background-color: blue;">S.N</th>
					<th width="2%">Category ID</th>
					<th width="2%">Category Name</th>
					<th width="2%">Category Description</th>
					<th width="2%">Category Action</th>
				</tr>
			</thead>
			<tbody>
	<c:forEach var="cat" items="${categoryList}" varStatus="loopCounter">
	<tr>
	<td><c:out value="${loopCounter.count}" /></td>
	<td><c:out value="${cat.category_id}"/></td>
		<td><c:out value="${cat.category_Name}"/></td>
		<td><c:out value="${cat.category_Description}"/></td>
		<td><nobr>
<a class="btn btn-primary" href="editcategory/${cat.category_id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit</a>

<a class="btn btn-primary"  href="removecategory/${cat.category_id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
								</a>

							</nobr></td>
	</tr>
	</c:forEach>
	
</table>
</form:form>


</body>
</html>