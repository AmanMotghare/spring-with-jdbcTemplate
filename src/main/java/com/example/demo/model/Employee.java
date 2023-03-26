package com.example.demo.model;

public class Employee {
	
	private int Id;
	private String Name;
	private String Address;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String address) {
		super();
		Name = name;
		Address = address;
	}

	public Employee(int id, String name, String address) {
		super();
		Id = id;
		Name = name;
		Address = address;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Address=" + Address + "]";
	}
}
