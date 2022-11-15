package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class DepartmentDAOImp implements DepartmentDAO {

	private Connection conn;

	public DepartmentDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Department findByID(Integer id) {

		PreparedStatement sqlStatement = null; // It will receive a SQL query.
		ResultSet results = null;

		try {
			// Preparation of an SQL query.
			sqlStatement = conn.prepareStatement("SELECT * FROM DEPARTMENTS D WHERE IDDEPARTMENT = ?");
			
			sqlStatement.setInt(1, id); // It defines the <?> value. set<type>(<?'s position>, <value>);

			results = sqlStatement.executeQuery(); // This var executes the query and receives its returned data.

			if (results.next()) { // Verifies if the ResultSet ( Returned Data) has a row (is not null).
				
				Department dep = setDepartmentAttrib(results); //  Instantiate the object attributes. Obs : Method at the end of the code.
				
				return dep;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement); // Closes the Statement.
			DB.closeResultSet(results); // Closes the ResultSet.
		}

	}


	@Override
	public List<Department> findAll() {

		PreparedStatement sqlStatement = null;
		ResultSet results = null;

		try {

			sqlStatement = conn.prepareStatement(
					"SELECT * FROM DEPARTMENTS D"
			);
			
			results = sqlStatement.executeQuery();
			
			List<Department> departmentList = new ArrayList<>();
			
			while(results.next()){ // It goes through all of the ResultSet's rows, until the row is null(false).
			
				Department dep = setDepartmentAttrib(results); // Method at the end of the code.
				
				departmentList.add(dep);
			}
			
			return departmentList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
			DB.closeResultSet(results);
		}
	}
	
	
	// The object's ID will be defined by the DB, as the PK is set to AUTO_INCREMENT.
	@Override
	public void insert(Department obj) {
		
		PreparedStatement sqlStatement = null;
		
		try {
			sqlStatement = conn.prepareStatement(
					"INSERT INTO DEPARTMENTS(NAME)"
					+ " VALUES (?)",
					Statement.RETURN_GENERATED_KEYS); //It returns the generated keys. KEY = ID.
			
			sqlStatement.setString(1, obj.getName());
			
			int rowsAffected = sqlStatement.executeUpdate(); // This var executes and receives the number of rows affected by the update.
			
			if(rowsAffected > 0) {
				
				ResultSet keys = sqlStatement.getGeneratedKeys(); // It collects the returned keys.
				
				if(keys.next()) { // Verifies if the ResultSet in not empty.
					obj.setId(keys.getInt(1)); // ResultSet with one position (row). Object receives its id.
				}
				
				System.out.println("Success ! Rows affected : " + rowsAffected);
				
				DB.closeResultSet(keys);
			} else {
				throw new DbException("Unexpected error ! No rows affected.");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(sqlStatement);
		}

	}

	@Override
	public void update(Department obj) {
		
		PreparedStatement sqlStatement = null;
		
		try {
			sqlStatement = conn.prepareStatement(
					"UPDATE DEPARTMENTS "
					+ "SET NAME = ? "
					+ "WHERE IDDEPARTMENT = ?" 
					); 
			
			sqlStatement.setString(1, obj.getName());
			sqlStatement.setInt(2, obj.getId());
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			if(rowsAffected > 0) {
				
				System.out.println("Success ! Rows affected : " + rowsAffected);
				
			} else {
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
					"DELETE FROM DEPARTMENTS "
					+ "WHERE IDDEPARTMENT = ?")
					;
			
			sqlStatement.setInt(1, id);
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			if ( rowsAffected > 0) {
				
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
	
	// METHOD TO SIMPLIFY SETTING OBJECTS ATTRIBUTES 
	// IT THROWS THE SQLEXCEPTION BECAUSE IT WILL BE USED WHERE IT'S ALREADY TREATED PROPERLY.
	
	// SET THE ATTRIBUTES OF AN DEPARTMENT OBJECT BASED ON A RESULT SET AND RETURNS IT.
		private Department setDepartmentAttrib(ResultSet results) throws SQLException {
			Department dep = new Department();
			dep.setId(results.getInt("D.IDDEPARTMENT"));
			dep.setName(results.getString("D.NAME"));
			
			return dep;
		}
		
   // OBS: THE get<type>(<column index>) method returns the value of the column value of the row.

	
	
}
