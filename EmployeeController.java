package hibernate_employee.controller;

import java.util.Scanner;

import hibernate_employee.dao.EmployeeDao;
import hibernate_employee.dto.Employee;

public class EmployeeController 
{
	public static void main(String[] args) 
	{
		Employee employee=new Employee();
		EmployeeDao dao=new EmployeeDao();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your choice\n1.Save Employee \n2.Fetch Employee \n3.Update Employee \n4.Delete Employee \n5.Fetch All Employee");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter your id");
			int id=scanner.nextInt();
			System.out.println("Enter your name");
			String name=scanner.next();
			System.out.println("Enter your email");
			String email=scanner.next();
			System.out.println("Enter your phone");
			long phone=scanner.nextLong();
			
			employee.setId(id);
			employee.setName(name);
			employee.setEmail(email);
			employee.setPhone(phone);
			
			dao.saveEmployee(employee);
			
			break;
		}
		case 2:
		{
			System.out.println("Enter your id");
			int id=scanner.nextInt();
			dao.fetchEmployee(id);
		}
		case 3:
		{
			System.out.println("Enter your id");
			int id=scanner.nextInt();
			System.out.println("Enter your name");
			String name=scanner.next();
			System.out.println("Enter your email");
			String email=scanner.next();
			System.out.println("Enter your phone");
			long phone=scanner.nextLong();
			
			employee.setId(id);
			employee.setName(name);
			employee.setEmail(email);
			employee.setPhone(phone);
			dao.updateEmployee(employee);
			
			break;
		}
		case 4:
		{
			System.out.println("Enter your id");
			int id=scanner.nextInt();
			dao.deleteEmployee(id);
			break;
		}
		case 5:
		{
			dao.getAllEmployee();
			break;
		}
		}
	}
}
