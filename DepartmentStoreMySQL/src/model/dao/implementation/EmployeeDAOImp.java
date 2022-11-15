package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import enums.JobRoles;
import model.dao.EmployeeDAO;
import model.entities.Department;
import model.entities.Employee;

public class EmployeeDAOImp implements EmployeeDAO {

	private Connection conn;

	public EmployeeDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Employee findByID(Integer id) {

		PreparedStatement sqlStatement = null;
		ResultSet results = null;

		try {

			sqlStatement = conn.prepareStatement(
						"SELECT E.*, D.* FROM EMPLOYEES E" 
						+ " INNER JOIN DEPARTMENTS D"
						+ " ON ID_DEPARTMENT = IDDEPARTMENT" 
						+ " WHERE IDEMPLOYEE = ?"
						);

			sqlStatement.setInt(1, id);

			results = sqlStatement.executeQuery();

			if (results.next()) {

				Department dep = setDepartmentAttrib(results); // getInt, getString... Method at the end of the code.

				Employee emp = setEmployeeAttrib(results, dep); // getInt, getString... Method at the end of the code.
				
				return emp;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
			DB.closeResultSet(results);
		}

	}

	@Override
	public List<Employee> findAll() {
		
		PreparedStatement sqlStatement = null;
		ResultSet results = null;
		
		try {
			
			sqlStatement = conn.prepareStatement(
					"SELECT E.*, D.* FROM EMPLOYEES E" 
					+ " INNER JOIN DEPARTMENTS D"
					+ " ON ID_DEPARTMENT = IDDEPARTMENT" 
					);
			
			results = sqlStatement.executeQuery();
			
			List<Employee> employeesList = new ArrayList<>();
			Map<Integer, Department> verificationMap = new HashMap<>(); // Needed to assure a department is instantiated only once.
			
			while(results.next()) {
				
				Department dep = verificationMap.get(results.getInt("IDDEPARTMENT")); // Tries to have a dep returned. If key is not registered, return null.
				
				if(dep == null) { // If it's null, then dep doesn't exist yet. A new object will be created.
					dep = setDepartmentAttrib(results); // Method at the end of the code.
					verificationMap.put(results.getInt("IDDEPARTMENT"), dep); // Register the occurrence of dep in the map.
				}
				
				Employee emp = setEmployeeAttrib(results, dep); // If the dep != null, then emp receives the respective dep from the map catalog.
				
				employeesList.add(emp);
			}
			
			return employeesList;	
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
			DB.closeResultSet(results);
		}
	}
	
	@Override
	public List<Employee> findByDepartment(Department dep) {
		
		PreparedStatement sqlStatement = null;
		ResultSet results = null;

		try {

			sqlStatement = conn.prepareStatement(
						"SELECT E.*, D.* FROM EMPLOYEES E" 
						+ " INNER JOIN DEPARTMENTS D"
						+ " ON ID_DEPARTMENT = IDDEPARTMENT" 
						+ " WHERE ID_DEPARTMENT = ?"
						);

			sqlStatement.setInt(1, dep.getId());

			results = sqlStatement.executeQuery();
			
			List<Employee> employeeList = new ArrayList<>();
			
			while (results.next()) {

				Employee emp = setEmployeeAttrib(results, dep); // getInt, getString...
				
				employeeList.add(emp);
			}

			return employeeList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
			DB.closeResultSet(results);
		}

	}

	@Override
	public void insert(Employee obj) {
		
		PreparedStatement sqlStatement = null;
		
		try {
			
			sqlStatement = conn.prepareStatement(
					"INSERT INTO EMPLOYEES (NAME, SALARY, CONTRACT_DATE, GENDER, ROLE, ID_DEPARTMENT) "
					+ "VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS
					);
			
			sqlStatement.setString(1, obj.getName());
			sqlStatement.setDouble(2, obj.getSalary());
			sqlStatement.setDate(3, new java.sql.Date(obj.getContractDate().getTime())); // Constructor receives milliseconds (long) as argument.
			sqlStatement.setString(4, String.valueOf(obj.getGender())); // A setChar / getChar method doesn't exist.
			sqlStatement.setString(5, String.valueOf(obj.getRole()));
			sqlStatement.setInt(6, obj.getDepartment().getId());
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			if(rowsAffected > 0) {
				
				ResultSet keys = sqlStatement.getGeneratedKeys();
				
				if (keys.next()) {
					
					obj.setId(keys.getInt(1));
				}
				
				System.out.println("Success ! Rows affected : " + rowsAffected);
				DB.closeResultSet(keys);
			}
			else {
				throw new DbException("Unexpected error ! No rows affected.");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
		}

	}

	@Override
	public void update(Employee obj) {
		
		PreparedStatement sqlStatement = null;
		
		try {
			
			sqlStatement = conn.prepareStatement(
					"UPDATE EMPLOYEES "
					+ "SET NAME = ?, "
					+ "SALARY = ?, "
					+ "CONTRACT_DATE = ?, "
					+ "GENDER = ?, "
					+ "ROLE = ?, "
					+ "ID_DEPARTMENT = ? "
					+ "WHERE IDEMPLOYEE = ?" 
					);
			
			sqlStatement.setString(1, obj.getName());
			sqlStatement.setDouble(2, obj.getSalary());
			sqlStatement.setDate(3, new java.sql.Date(obj.getContractDate().getTime())); // Constructor receives milliseconds (long) as argument.
			sqlStatement.setString(4, String.valueOf(obj.getGender())); // A setChar , getChar method doesn't exist.
			sqlStatement.setString(5, String.valueOf(obj.getRole()));
			sqlStatement.setInt(6, obj.getDepartment().getId());
			sqlStatement.setInt(7, obj.getId());
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			if(rowsAffected > 0) {
				
				System.out.println("Success ! Rows affected : " + rowsAffected);
			}
			else {
				throw new DbException("Unexpected error ! No rows affected.");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
		}

	}

	@Override
	public void deleteByID(Integer id) {
		
		PreparedStatement sqlStatement = null;
		
		try {
			
			sqlStatement = conn.prepareStatement(
					"DELETE FROM EMPLOYEES "
					+ "WHERE IDEMPLOYEE = ?"
					);
			
			sqlStatement.setInt(1, id);
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			if (rowsAffected > 0) {
				
				System.out.println("Success ! Rows affected : " + rowsAffected);
			}
			else {
				throw new DbException("Unexpected error ! No rows affected.");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
		}

	}
	
	// METHODS TO SIMPLIFY SETTING OBJECTS ATRIBUTES 
	// THEY THROWS THE SQLEXCEPTION BECAUSE THEY WILL BE USED WHERE IT'S ALREADY TREATED PROPERLY.
	
	// SET THE ATTRIBUTES OF AN EMPLOYEE OBJECT BASED ON A RESULT SET AND A DEPARTMENT AND RETURNS IT.
	private Employee setEmployeeAttrib(ResultSet results, Department dep) throws SQLException {
		Employee emp = new Employee();
		emp.setId(results.getInt("E.IDEMPLOYEE"));
		emp.setName(results.getString("E.NAME"));
		emp.setSalary(results.getDouble("E.SALARY"));
		emp.setContractDate(results.getDate("E.CONTRACT_DATE"));
		emp.setGender(results.getString("E.GENDER").charAt(0));
		emp.setRole(JobRoles.valueOf(results.getString("E.ROLE")));
		emp.setDepartment(dep);

		return emp;
	}
	
	// SET THE ATTRIBUTES OF AN DEPARTMENT OBJECT BASED ON A RESULT SET AND RETURNS IT.
	private Department setDepartmentAttrib(ResultSet results) throws SQLException {
		Department dep = new Department();
		dep.setId(results.getInt("D.IDDEPARTMENT"));
		dep.setName(results.getString("D.NAME"));
		
		return dep;
	}
	
	// OBS: THE get<type>(<column index>) method returns the value of the column value of the row.


}
