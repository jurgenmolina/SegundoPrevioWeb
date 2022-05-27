




package co.empresa.test.dao;

public class UserDaoFactory {

	public static UserDao getUserDao(String type) {
		switch(type) {
		case "mysql":
			return new UserDaoPostgreSQL();
		case "postgresql":
			return new UserDaoPostgreSQL();
		default:
			return new UserDaoPostgreSQL();
		}
	}
	
}
