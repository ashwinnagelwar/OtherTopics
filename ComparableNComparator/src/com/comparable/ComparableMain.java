package com.comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	ArrayList<Employee>list=new ArrayList<>();
	list.add(new Employee(1,"Ashwin","Warora",32));
	list.add(new Employee(3,"Rahul","Chimur",35));
	list.add(new Employee(2,"Vaibhav","Nagpur",32));
	
	Collections.sort(list);
	System.out.println(list);
	}

}
