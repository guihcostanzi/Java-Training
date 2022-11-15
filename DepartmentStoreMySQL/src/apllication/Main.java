package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import enums.JobRoles;
import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.dao.EmployeeDAO;
import model.entities.Department;
import model.entities.Employee;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		// INSTANTIATING THE DATA ACCES OBJECTS WITH THE DAO FACTORY.
		EmployeeDAO employeeDAO = DAOFactory.instanciateEmployeeDAO();
		
		DepartmentDAO departmentDAO = DAOFactory.instanciateDepartmentDAO();
		
		//TEST SEQUENCE
		
		//1 - findByID() :
		
		System.out.println("\n-------------------------[findByID]-------------------------\n");
		
		System.out.print("Enter the desired employee's ID :");
		Employee emp = employeeDAO.findByID(sc.nextInt());
		sc.nextLine();
		System.out.println(emp);
		System.out.println();
		
		System.out.print("Enter the desired departments's ID :");
		Department dep = departmentDAO.findByID(sc.nextInt());
		sc.nextLine();
		System.out.println(dep);
		System.out.println();
		
		//2 - findAll() :
		
		System.out.println("\n-------------------------[findAll]-------------------------\n");
		
		System.out.println("Employees list :");
		List<Employee> employeesList = employeeDAO.findAll();
		
		for (Employee employee : employeesList) {
			System.out.println(employee);
		}
		System.out.println();
		

		System.out.println("Departments list :");
		List<Department> departmentsList = departmentDAO.findAll();
		
		for (Department department : departmentsList) {
			System.out.println(department);
		}
		
		//3 - findByDepartment() -- Employee Only:   
		
		System.out.println("\n-------------------------[findByDepartment]-------------------------\n");
		
		System.out.print("Enter a department's ID :");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		System.out.println("Employees list :");
		employeesList = employeeDAO.findByDepartment(new Department(id, null));
		
		for (Employee employee : employeesList) {
			System.out.println(employee);
		}
		
		//4 - insert()
		
		System.out.println("\n-------------------------[insert]-------------------------\n");
		
		System.out.println("Let's register a new Department :");
		
		System.out.print("Name :");
		String name = sc.nextLine();
		
		dep = new Department(null, name);
		
		departmentDAO.insert(dep);
		
		System.out.println("The new department ID is : " + dep.getId());
		System.out.println();
		
		System.out.println("Let's register a new Employee :");
		
		System.out.print("Name :");
		name = sc.nextLine();
		System.out.print("Salary :");
		Double salary = sc.nextDouble();
		sc.nextLine();
		System.out.print("Contract Date (dd-MM-yyyy) :");
		Date contractDate = sdf.parse(sc.next());
		sc.nextLine();
		System.out.print("Gender :");
		char gender = sc.next().toUpperCase().charAt(0);
		sc.nextLine();
		System.out.print("Role :");
		JobRoles role = JobRoles.valueOf(sc.next());
		sc.nextLine();
		System.out.println("Department is predefined as ID = 1 !");
		
		//I'll use a predefined department to prevent mistakes.
		dep = new Department(1, "TOYS"); 
		
		emp = new Employee(null, name, salary, contractDate, gender, role, dep);
		
		employeeDAO.insert(emp);
		
		System.out.println("The new employee ID is : " + emp.getId());
		
		//5 - update();
		
		System.out.println("\n-------------------------[update]-------------------------\n");
		
		// Both objects must have an ID so that the DB can update them.
		
		emp = new Employee(5, "UPDATED EMP", 1200.0, contractDate, 'F', JobRoles.SELLER, dep);
		employeeDAO.update(emp);
		
		dep = new Department(3, "UPDATED DEP");
		departmentDAO.update(dep);
		
		//6 - deleteByID();
		
		System.out.println("\n-------------------------[deleteByID]-------------------------\n");
		
		System.out.print("Lets delete an employee. Insert its ID :");
		employeeDAO.deleteByID(sc.nextInt());
		sc.nextLine();
		
		System.out.print("Lets delete a department. Insert its ID :");
		departmentDAO.deleteByID(sc.nextInt());
		sc.nextLine();
		
		System.out.println("END !");
		
		sc.close();
		DB.closeConnection();
		
		
		

	}

}
