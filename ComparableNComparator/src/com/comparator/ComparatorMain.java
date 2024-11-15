package com.comparator;

import java.util.ArrayList;
import java.util.Collections;



public class ComparatorMain {

	//with comparator we can sort by different parameter without chnages in employee class
	
	public static void main(String[] args) {
		
		ArrayList<Employee>list=new ArrayList<>();
		list.add(new Employee(1,"Ashwin","Warora",32));
		list.add(new Employee(3,"Rahul","Chimur",35));
		list.add(new Employee(2,"Vaibhav","Nagpur",32));
		
		//employeeCityComparator used to implements comparator to provide sorting based on employee city
		Collections.sort(list,new EmployeeCityComparator());
		
		for (Employee employee : list) {
            System.out.println(employee);
        }
		
		
		//employeeNameComparator used to implements comparator to provide sorting based on employee name
		Collections.sort(list,new EmployeeNameComparator());
		
		for (Employee employee : list) {
            System.out.println(employee);
        }
		
	}
}
