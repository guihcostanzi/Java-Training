package model.dao;

import db.DB;
import model.dao.implementation.DepartmentDAOImp;
import model.dao.implementation.EmployeeDAOImp;

public class DAOFactory {
	
	// A class for us not to expose the implementation, but only the interfaces.
	
	public static DepartmentDAO instanciateDepartmentDAO() {
		return new DepartmentDAOImp(DB.getConnection());
	}
	
	public static EmployeeDAO instanciateEmployeeDAO() {
		return new EmployeeDAOImp(DB.getConnection());
	}

}
