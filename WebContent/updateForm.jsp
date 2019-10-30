<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.EmpDao" %>
<%@ page import="dto.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%
		String empId = request.getParameter("empId");
		EmpDao dao = new EmpDao();
		Employee emp = dao.getEmp(empId);

	%>
	<form id="frm" action="EmpServlet">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="employee_id" value="<%=emp.getEmployeeId() %>">
		<table border="1" cellpadding="5px">
			<tr>
				<th>FirstName:</th>
				<td><input type="text" id="firstName" name="firstName" value="<%=emp.getFirstName()%>" readonly></td>
			</tr>
			<tr>
				<th>LastName:</th>
				<td><input type="text" id="lastName" name="lastName" value="<%=emp.getLastName()%>" readonly></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" id="email" name="email" value="<%=emp.getEmail()%>" readonly></td>
			</tr>
			<tr>
				<th>JobId:</th>
				<td><input type="text" id="jobId" name="jobId" value="<%=emp.getJobId()%>"></td>
			</tr>
			<tr>
				<th>salary:</th>
				<td><input type="text" id="salary" name="salary" value="<%=emp.getSalary()%>"></td>
			</tr>
			<tr>
				<th>HireDate:</th>
				<td><input type="text" id="hireDate" name="hireDate" value="<%=emp.getHireDate()%>" readonly></td>
			</tr>
			<tr>
				<th>PhoneNumber:</th>
				<td><input type="text" id="phoneNumber" name="phoneNumber" value="<%=emp.getPhoneNumber()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="sbmbtn"
					value="입력"></td>
			</tr>
		</table>

	</form>
</body>
</html>