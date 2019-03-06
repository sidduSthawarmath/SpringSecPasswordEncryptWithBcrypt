<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/login" method="post"
		class="form-horizontal">

		<c:if test="${param.error != null}">
			<div style="color: red">
				<p>Invalid username and password.</p>
			</div>
		</c:if>

		<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				<p>You have been logged out successfully.</p>
			</div>
		</c:if>
		<h4>Custom Login page</h4>
		<table>
			<tr>
				<td>User name</td>
				<td><input type="text" name="ssoId" id="username"></td>
			</tr>

			<tr>
				<td>password</td>
				<td><input type="text" name="password" id="password"></td>
			</tr>
			
			<tr>
			<td colspan="2">
			<label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label> 
			</td>
			</tr>
			
		</table>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Login">
	</form>
</body>
</html>