package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import dto.Employee;

public class HashMapExample2 {
	public static void main(String[] args) {
		Connection conn = DAO.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		HashMap<Integer, Employee> map = new HashMap<>();
		

		try {
			pstmt = conn.prepareStatement("select * from emp_temp");
			rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("Employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				map.put(cnt++, emp);
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
		Set<Entry<Integer, Employee>> ent = map.entrySet();
		for(Entry<Integer, Employee> entry : ent) {
			System.out.println("k: "+ entry.getKey() + " v: "+ entry.getValue());
		}
	}
}
