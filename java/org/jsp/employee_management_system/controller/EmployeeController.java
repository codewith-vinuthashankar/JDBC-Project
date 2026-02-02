package org.jsp.employee_management_system.controller;




import java.util.*;

import org.jsp.employee_management_system.dao.EmployeeDao;
import org.jsp.employee_management_system.entity.Employee;


public class EmployeeController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao dao = new EmployeeDao();

		System.out.println("-------Welcome to employee Management System------");
		System.out.println("--------------------------------");
		System.out.println("1.For Insert Employee Details");
		System.out.println("2.For Fetching All the Employee Details");
		System.out.println("3.To fetch Employee details by empid");
		System.out.println("4.To dlete the data or an record");
		System.out.println("5.For update employee id");
		System.out.println("please inter the choice:-");
		int choice = sc.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("-------Enter employee details------");
			System.out.println("-------Enter employee empid------");
			int eid = sc.nextInt();
			sc.nextLine();
			System.out.println("-------Enter employee name------");
			String name = sc.nextLine();
			System.out.println("-------Enter employee email------");
			String email = sc.nextLine();
			System.out.println("-------Enter employee Salary------");
			double salary = sc.nextDouble();
			System.out.println("-------Enter employee Age------");
			int age = sc.nextInt();

			Employee emp = new Employee();
			emp.setEid(eid);
			emp.setName(name);
			emp.setEmail(email);
			emp.setSalary(salary);
			emp.setAge(age);

			boolean res = dao.saveEmployee(emp);

			if (res) {
				System.out.println("-------Data inserted------");
			} else {
				System.out.println("-------Data not inserted------");
			}
		}
			break;

		case 2: {
			System.out.println("-----------------Employee Details------------");
			List<Employee> emp = dao.getAllEmployee();
			if (emp != null) {
				for (Employee e : emp) {
					System.out.println(e.getEid());
					System.out.println(e.getName());
					System.out.println(e.getEmail());
					System.out.println(e.getSalary());
					System.out.println(e.getAge());
					System.out.println("-------------------------");
				}
			} else {
				System.out.println("Employee table is empty");
			}

		}
			break;
		case 3:{
			System.out.println("Enter the empid to fetch");
			int eid=sc.nextInt();
			Employee e=dao.getEmployeeById(eid);
			if (e!=null) {
				System.out.println("Empid :"+e.getEid());
				System.out.println("name :"+e.getName());
				System.out.println("Email :"+e.getEmail());
				System.out.println("Salary :"+e.getSalary());
				System.out.println("Age :"+e.getAge());
			}
			else {
				System.out.println("give id is not found");
			}
		}
		break;
	
		case 4:{
			System.out.println("please enter eid to dlete employee");
			int eid=sc.nextInt();
			boolean b=dao.deleteEmployeeById(eid);
			if(b) {
				System.out.println("data is deleted");
			}
			else {
				System.out.println("given id is not found");
			}
			break;
		}
		
		case 5:{
			System.out.println("please enter employee eid");
			int eid=sc.nextInt();
			sc.nextLine();
			System.out.println("please enter name");
			String name=sc.nextLine();
			boolean b=dao.updateEmployeeById(eid, name);
			if(b) {
				System.out.println("data is updated");
			}
			else {
				System.out.println("data is not updated");
			}
			break;   
		}
		case 6:{
			System.out.println("SUCCESSFULLY EXIT");
			System.exit(0);
		}
		
		default: {
			System.err.println("Invalid Choice");
		}

		}
	}

}
		











