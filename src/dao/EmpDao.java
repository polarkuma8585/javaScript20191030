package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import dto.Employee;

public class EmpDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void deleteEmp(String empId) {
		conn = DAO.getConnect();
		String sql  = "delete from emp_temp where employee_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			int r = pstmt.executeUpdate();
			System.out.println("사원번호" + empId + " 의 사원정보가 삭제 되었습니다."); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void updateEmp(Employee emp) {
		conn = DAO.getConnect();
		String sql = "update emp_temp set salary =?, job_id= ?, phone_number=? where employee_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getSalary());
			pstmt.setString(2, emp.getJobId());
			pstmt.setString(3, emp.getPhoneNumber());
			pstmt.setInt(4, emp.getEmployeeId());
			
			int r = pstmt.executeUpdate();
			System.out.println("EmployeeID "+ emp.getEmployeeId()+" 의 정보가 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Employee getEmp(String empId) {
		conn = DAO.getConnect();
		String sql = "select * from emp_temp where employee_id = ?";
		Employee emp = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new Employee();
				emp.setEmail(rs.getString("email"));
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setSalary(rs.getInt("salary"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	
	public void insertEmp(Employee emp) {
		conn = DAO.getConnect();
		String sql = "insert into emp_temp (employee_id, first_name, last_name, email, job_id, salary, hire_date, phone_number)"
				+ "values(employees_seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getJobId());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setString(6, emp.getHireDate());
			pstmt.setString(7, emp.getPhoneNumber());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Employee> getEmpList() {
		conn = DAO.getConnect();
		String sql = "select * from emp_temp order by 1 desc";
		List<Employee> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Employee emp = null;
			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
