package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;
import Util.IdGenerator;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Employee Management System : ");

		List<String> names = new ArrayList<>();
		List<Double> salaries = new ArrayList<>();
		List<String> ids = new ArrayList<>();

		System.out.println("How many employees will be registered ?");

		int n = sc.nextInt();
		sc.nextLine();

		String name;
		Double salary;
		String id;

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + ": ");
			System.out.println("Name :");
			name = sc.nextLine();
			System.out.println("Salary :");
			salary = sc.nextDouble();
			sc.nextLine();
			id = IdGenerator.generateEmployeeID();

			names.add(name);
			salaries.add(salary);
			ids.add(id);
		}

		System.out.println("List of registered employees :");
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + ": ");
			System.out.println();

			name = names.get(i);
			salary = salaries.get(i);
			id = ids.get(i);

			Employee general = new Employee(name, salary, id);

			System.out.println(general);
		}

		System.out.println("Enter the id of the employee whose salary will be increased : ");
		String idIncrease = sc.nextLine();

		if (ids.indexOf(idIncrease) > 0) {

			System.out.println("Enter the percentage of the increase (%) :");
			double increasePercentage = sc.nextDouble();

			int increaseIndex = ids.indexOf(idIncrease);

			double increasedSalary = salaries.get(increaseIndex)
					+ salaries.get(increaseIndex) * increasePercentage / 100;

			salaries.set(increaseIndex, increasedSalary);

			System.out.println("Employees data after the increase : ");
			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.println("Employee #" + (i + 1) + ": ");
				System.out.println();

				name = names.get(i);
				salary = salaries.get(i);
				id = ids.get(i);

				Employee general = new Employee(name, salary, id);

				System.out.println(general);
			}

			sc.close();

		}
		else {
			System.out.println("This ID doesn't exist. Operation aborted.");
		}
	}

}
