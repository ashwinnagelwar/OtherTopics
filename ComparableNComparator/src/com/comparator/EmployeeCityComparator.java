package com.comparator;

import java.util.Comparator;

public class EmployeeCityComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.getCity().compareTo(e2.getCity());
	}
}
