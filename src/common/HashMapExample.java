package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		Connection conn = DAO.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		HashMap<Integer, String> map = new HashMap<>();
		map.put(10, "ten");
		map.put(10, "twenty");

		try {
			pstmt = conn.prepareStatement("select * from departments");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt("department_id"), rs.getString("department_name"));
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
		Set<Integer> set = map.keySet();
		for (Integer keys : set) {
			System.out.println("key: " + keys + " value: " + map.get(keys));

		}

	}
}
