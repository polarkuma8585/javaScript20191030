package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dto.Employee;
import net.sf.json.JSONArray;


// 한 페이지에 많은 기능을 넣으면 많은 접속자들을 감당하지 못해 효율이 떨어짐.
// servlet은 각 기능 별로 만들 것.

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		EmpDao dao = new EmpDao();
		Employee emp = new Employee();
		
		String jobId = request.getParameter("jobId");
		String salary = request.getParameter("salary");
		String phNum = request.getParameter("phoneNumber");
		
		if (action == null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<h3>No Result : 입력된 값이 없습니다. </h3>");
			sb.append("<p>**********</p>");
			out.print(sb.toString());
			
		} else if (action.equals("delete")) {
			
			String emplId = request.getParameter("empId");
			
			dao.deleteEmp(emplId);
			
		} else if (action.equals("list")) {
			List<Employee> list = dao.getEmpList();
			out.println(JSONArray.fromObject(list));
			
		} else if (action.equals("update")) {
			String empId = request.getParameter("employee_id");

			emp.setJobId(jobId);
			emp.setSalary(Integer.parseInt(salary));
			emp.setPhoneNumber(phNum);
			emp.setEmployeeId(Integer.parseInt(empId));
			
			dao.updateEmp(emp);
			
			response.sendRedirect("empList.html");
			
		} else if (action.equals("insert")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String hireDate = request.getParameter("hireDate");
		
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setEmail(email);
			emp.setJobId(jobId);
			emp.setSalary(Integer.parseInt(salary));
			emp.setHireDate(hireDate);
			emp.setPhoneNumber(phNum);
			
			dao.insertEmp(emp);
			
			response.sendRedirect("empList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
