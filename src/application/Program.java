package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
	DepartmentDao depD = DaoFactory.createDepartmentDao();
	
	depD.insert(new Department(5, "penis"));
	
	
	}

}
