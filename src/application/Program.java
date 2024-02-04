package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
	DepartmentDao depD = DaoFactory.createDepartmentDao();
	
	
	List<Department> deps = depD.findAll();
	deps.forEach(System.out::println);
	}

}
