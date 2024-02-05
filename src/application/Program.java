package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sld = DaoFactory.createSellerDao();
		DepartmentDao dpd = DaoFactory.createDepartmentDao();

		// implement 1 seller - INSIRT
		Department dep = dpd.findById(1);
		// Seller seller = new Seller(null, "Herick Campos", "herickzeno@gmail.com", new
		// Date(0), 3000.0, dep);
		System.out.println("Sucess on Insert seller!!\n");
		// sld.insert(seller);

		// implement 2 seller - findById
		System.out.println("--------------------------------------");
		Seller seller = sld.findById(10);
		System.out.println("Seller: " + seller + "\n");

		// implement 3 seller - update
		System.out.println("--------------------------------------");
		seller.setName("Herick Campos Callegari");
		seller.setBaseSalary(10000.0);

		sld.update(seller);
		seller = sld.findById(10);

		System.out.println("updated Seller: " + seller + "\n");

		// implement 4 seller - findAll
		System.out.println("--------------------------------------");
		List<Seller> sellers = sld.findAll();
		sellers.forEach(System.out::println);

		// implement 5 seller - findByDepartment
		System.out.println("--------------------------------------");
		sellers = sld.findByDepartment(dep);
		sellers.forEach(System.out::println);

		// implement 6 seller - delete
		System.out.println("--------------------------------------");
		sld.deleteBy(seller);
	}
}
