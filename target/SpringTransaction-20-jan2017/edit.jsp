<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="employee" action="save.do">

		<table>

			<tr>
				<td>ID</td>
				<td><form:input path="id"/></td>

			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="fname"/></td>
				<td><form:errors path="fname" cssClass="error"/></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><form:input path="lname"/>
				<td><form:errors path="lname" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Dob</td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" cssClass="error" /></td>
			</tr>


			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>


			<tr>
				<td>email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>


			<tr>
				<td>Department Name</td>

				<td><form:select path="department" items="${deptList}"
						itemValue="did" itemLabel="name" style="width: 145px" /></td>
			</tr>



		</table>

		<table>
			<tr>
				<td><input type="submit" name="update" value="update" /></td>
				<td><input type="submit" name="back" value="Back To Main Page" /></td>
			</tr>

		</table>


	</form:form>
</body>
</html>