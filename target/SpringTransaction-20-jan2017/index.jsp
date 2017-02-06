<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>

<style>
body {
	background-color: powderblue;
}

h1 {
	color: blue;
}

p {
	color: red;
}
</style>

</head>
<body>
	<form method="post" action="save.do">



		<table>

			<!-- <tr><a href="hello.html">All Employees</a></tr> -->
			<tr>
				<td><input type="text" name="id" /></td>
				<td><input type="submit" name="search" value="search" /></td>
                <td><td><c:out value="${message}" /></td>
			</tr>
		</table>
        <c:if test="${not empty employee1}">

		<table style="" border="3">
			<tr>
				<th><font color="red">Select</font></th>
				<th><font color="red">Id</font></th>
				<th><font color="red">First Name</font></th>
				<th><font color="red">Last Name</font></th>

				<th><font color="red">Dob</font></th>
				<th><font color="red">Address</font></th>
				<th><font color="red">Email</font></th>



				<th><font color="red">Dept Name</font></th>
				<th><font color="red">Dept Location</font></th>


			</tr>
			<c:forEach var="emp" items="${employee1}" >
				<tr>
					<td><input type="checkbox" name="checkbox" value="${emp.id}" /></td>
					<td><c:out value="${emp.id}" /></td>
					<td><c:out value="${emp.fname}" /></td>
					<td><c:out value="${emp.lname}" /></td>
					<td><c:out value="${emp.dob}" /></td>
					<td><c:out value="${emp.address}" /></td>
					<td><c:out value="${emp.email}" /></td>
					<td><c:out value="${emp.department.name}" /></td>
					<td><c:out value="${emp.department.location}" /></td>
				</tr>
			</c:forEach>
          


		</table>
		</c:if>
		<table>


			<tr>
				<td><input type="submit" name="save" value="Add Employee" /> <input
					type="submit" name="delete" value="Delete Employee" /> <input
					type="submit" name="edit" value="Edit Emlpoyee" /></td>
			</tr>



		</table>
	</form>
</body>
</html>