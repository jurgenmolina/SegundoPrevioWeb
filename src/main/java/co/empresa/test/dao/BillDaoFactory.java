




package co.empresa.test.dao;

public class BillDaoFactory {

	public static BillDao getBillDao(String type) {
		switch(type) {
		case "mysql":
			return new BillDaoPostgreSQL();
		case "postgresql":
			return new BillDaoPostgreSQL();
		default:
			return new BillDaoPostgreSQL();
		}
	}
	
}
