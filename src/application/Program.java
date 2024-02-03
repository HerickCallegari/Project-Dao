package application;

import model.dao.DaoFactory;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
	}

}
