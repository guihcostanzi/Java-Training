package Entities;

public class Employee {
	
	private String name;
	private Double salary;
	private String id;
	
	public Employee(String name, Double salary, String id) {
		this.name = name;
		this.salary = salary;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "Name : " + name + "\nSalary : $" + salary + "\nID : " + id + "\n";
		
	}
	
	
	

}
