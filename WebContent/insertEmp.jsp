<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="empList.html">리스트 화면</a></p>
	<form id="frm" action="EmpServlet">
		<input type="hidden" name="action" value="insert">
		<table border="1" cellpadding="5px">
			<tr>
				<th>FirstName:</th>
				<td><input type="text" id="firstName" name="firstName"></td>
			</tr>
			<tr>
				<th>LastName:</th>
				<td><input type="text" id="lastName" name="lastName"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" id="email" name="email"></td>
			</tr>
			<tr>
				<th>JobId:</th>
				<td><input type="text" id="jobId" name="jobId"></td>
			</tr>
			<tr>
				<th>salary:</th>
				<td><input type="text" id="salary" name="salary"></td>
			</tr>
			<tr>
				<th>HireDate:</th>
				<td><input type="date" id="hireDate" name="hireDate"></td>
			</tr>
			<tr>
				<th>PhoneNumber:</th>
				<td><input type="text" id="phoneNumber" name="phoneNumber"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="sbmbtn"
					value="입력"></td>
			</tr>
		</table>

	</form>
</body>
</html>