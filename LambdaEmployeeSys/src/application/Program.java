package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-- Employee Sys --");
		System.out.println();
		
		//Text file with employee's name, e-mail and salary.
		System.out.print("Insert the file path : ");
		String path = sc.nextLine();
		
		List<Employee> employeeList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] splittedLine = line.split(",");
				
				employeeList.add(new Employee(splittedLine[0], splittedLine[1], Double.parseDouble(splittedLine[2])));
				
				line = br.readLine();
				
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Enter minimum salary parameter : ");
		Double minimumSalary = sc.nextDouble();
		sc.nextLine();
		 
		List<String> emailList = employeeList.stream()
							.filter(e -> e.getSalary() > minimumSalary)
							.map(e -> e.getEmail())
							.sorted()
							.collect(Collectors.toList());
		
		System.out.println("E-mail of the employees whose salary is greater than the parameter :");
		emailList.forEach(System.out::println);
		System.out.println();
		
		double salarySum = employeeList.stream()
					.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (s1,s2) -> s1 + s2);
					
		System.out.println("Sum of the employees whose name starts with M : $ " + String.format("%.2f", salarySum));
		System.out.println();
		
		System.out.println("All employees :");
		employeeList.sort((x,y) -> x.getName().toUpperCase().compareTo(y.getName().toUpperCase()));;
		employeeList.forEach(System.out::println);

		
		sc.close();
	}

}
