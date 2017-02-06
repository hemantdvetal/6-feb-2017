<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Form</title>
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
				<td>&nbsp;</td>
				<td><input type="hidden" name="id" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.firstName" text="First Name" /></td>
				<td><form:input path="fname" /></td>
				<td><form:errors path="fname" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.LastName" text="Last Name" /></td>
				<td><form:input path="lname" /></td>
				<td><form:errors path="lname" cssClass="error" /></td>
			</tr>


			<tr>
				<td><spring:message code="lbl.dob" text="Dob" /></td>
				<td><input type="text" name="dob" /></td>
				<td><form:errors path="dob" cssClass="error" /></td>
			</tr>


			<tr>
				<td><spring:message code="lbl.Address" text="Address" /></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>


			<tr>
				<td><spring:message code="lbl.email" text="Email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			
			
			
			<tr>
				<td>Dept Name</td>
				<td><form:select path="department" items="${deptList}"
						itemValue="did" itemLabel="name" style="width: 145px" /></td>
				<td>&nbsp;</td>
			</tr>
			
			
		</table>
		<table>
			<tr>
				<td><input type="submit" name="saveEmployee" value="Save" /></td>
				<td><input type="submit" name="back" value="Back To Main Page" /></td>
			</tr>


		</table>

	</form:form>
</body>
</html>