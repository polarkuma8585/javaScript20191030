package common;

import java.util.ArrayList;
import java.util.List;

import dto.Employee;

public class ArrayListExample {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		int cnt = 0;
		while (true) {
			Employee emp = new Employee();
			emp.setEmployeeId(++cnt);
			emp.setFirstName("name" + cnt);
			list.add(emp);
			if (cnt > 3)
				break;
		}
		System.out.println();
		for(Employee emp:list) {
			System.out.println(emp);
			
		}
		list.remove(0);
		
		System.out.println(list.size());
	}
}
