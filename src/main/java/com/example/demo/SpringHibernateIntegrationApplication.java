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

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateIntegrationApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeDao Dao = (EmployeeDao) context.getBean("empDao");
		
		Scanner scan = new Scanner(System.in);
		Employee e;
		
		int choice = 0;
		
		boolean flag=true;
		
		String Name;
		String Address;
	
		while(flag) {
			System.out.println("****************************");
			System.out.println("(1).Insert Data");
			System.out.println("(2).Show Data");
			System.out.println("(3).Delete Data");
			System.out.println("(4).Update Data");
			System.out.println("(5).Search Data");
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
				List<Employee> list = Dao.getAllEmployees();
				for(Employee emp: list) {
					System.out.println(emp);
				}
				break;
				
			case 3:
				System.out.print("Enter Id to Update : ");
				
				break;
	
			default:
				System.out.println("Invalid Choice !! ");
				break;
			}
		
		}
		
	}

}
