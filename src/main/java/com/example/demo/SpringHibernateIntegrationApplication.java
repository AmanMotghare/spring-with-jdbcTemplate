package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDao;

@SpringBootApplication
public class SpringHibernateIntegrationApplication {
	
	static EmployeeDao Dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateIntegrationApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Dao = (EmployeeDao) context.getBean("empDao");
		
		Scanner scan = new Scanner(System.in);
		Employee e = new Employee();
		
		int choice = 0;
		int id;
		boolean flag=true;
		
		String Name;
		String Address;
		
		while(flag) {
			System.out.println("****************************");
			System.out.println("(1).Insert Data");
			System.out.println("(2).Show Data");
			System.out.println("(3).Delete Data");
			System.out.println("(4).Update Data");
			System.out.println("(0).Exit");
			System.out.println("****************************");
			
			System.out.print("\nEnter Choice : ");
			choice = Integer.parseInt(scan.nextLine());
		
			switch (choice) {
			case 1:
				System.out.println("Add New Employee ");
				
				System.out.println("Enter Name : ");
				Name = scan.nextLine();
				
				System.out.println("Enter Address : ");
				Address = scan.nextLine();
				
				e=new Employee(Name, Address);
				
				Dao.saveEmployee(e);
				System.out.println("Data Inserted Successfully.");
				System.out.println(e);
				break;
				
			case 2:
				System.out.println("All EMPLOYEEES ");
				getallEmployees();
				break;
				
			case 3:
				System.out.println("All EMPLOYEEES ");
				getallEmployees();
				
				System.out.print("\nEnter Id to Delete : ");
				
				id = Integer.parseInt(scan.nextLine());
				
				e.setId(id);
				
				Dao.deleteEmployeeDetails(e);
				System.out.println("Employee Details Deleted.");
				
				break;
				
			case 4:
				System.out.println("All EMPLOYEEES ");
				getallEmployees();
				
				System.out.print("\nEnter Id to Update : ");
				
				id = Integer.parseInt(scan.nextLine());
				
				System.out.println("What do you want to update ?");
				System.out.println("(1). Name");
				System.out.println("(2). Address");
				
				int key = Integer.parseInt(scan.nextLine());
				
				switch (key) {
				case 1:
					System.out.println("Enter New Name : ");
					Name = scan.nextLine();
					Dao.updateEmployeeName(id, Name);
					System.out.println("Name Updated");
					System.out.println("All EMPLOYEEES ");
					getallEmployees();
				break;
				
				case 2:
					System.out.println("Enter New Address : ");
					Address = scan.nextLine();
					Dao.updateEmployeeAddress(id, Address);
					System.out.println("Address Updated");
					System.out.println("All EMPLOYEEES ");
					getallEmployees();
					
				break;

				default:
					System.out.println("Invalid Choice");
				break;
				}
				
				break;
				
			default:
				System.out.println("Invalid Choice !! ");
				break;
			}
		
		}
		
	}
	
	private static void getallEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list = Dao.getAllEmployees();
		for(Employee emp: list) {
			System.out.println(emp);
		}
	}

}
