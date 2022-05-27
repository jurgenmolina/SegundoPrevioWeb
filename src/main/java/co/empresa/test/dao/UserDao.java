package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.User;
import co.empresa.test.modelo.Usuario;

public interface UserDao {
	public void insert(User user) throws SQLException;
	public User select(int id);
	public User selectName(String user);
	public List < User > selectAll();
}
