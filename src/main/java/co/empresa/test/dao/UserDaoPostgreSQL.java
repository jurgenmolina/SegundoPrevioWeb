package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import co.empresa.test.modelo.User;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class UserDaoPostgreSQL implements UserDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_User_SQL = "INSERT INTO users (username, pass, email) VALUES (?, ?, ?);";
	private static final String DELETE_User_SQL = "DELETE FROM User WHERE id = ?;";
	private static final String UPDATE_User_SQL = "UPDATE User SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_User_BY_ID = "SELECT * FROM users WHERE id = ?;";
	private static final String SELECT_User_BY_username = "SELECT * FROM users WHERE username = ?;";
	private static final String SELECT_ALL_UserS = "SELECT * FROM users;";
	
	
	
	public UserDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	public void insert(User user) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_User_SQL);
			preparedStatement.setString(1, user.getUsername());
			System.out.println(user.getUsername());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setString(3, user.getEmail());
			System.out.println(user.getEmail());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}

	
	
//	public void delete (int id)  throws SQLException {
//		try {
//			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_User_SQL);
//			preparedStatement.setInt(1, id);
//
//			conexion.execute();
//		} catch (SQLException e) {
//			
//		}
//	}
	
//	public void update(User users)  throws SQLException {
//		try {
//			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_User_SQL);
//			preparedStatement.setString(1, users.getNombre());
//			preparedStatement.setString(2, users.getEmail());
//			preparedStatement.setString(3, users.getPais());
//			preparedStatement.setInt(4, users.getId());
//			conexion.execute();
//		} catch (SQLException e) {
//			
//		}
//	}
	
	public List<User> selectAll() {
		List <User> users = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_UserS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				users.add(new User(id, username, pass, email));
			}
			
		} catch (SQLException e) {
			
		}
		
		return users;
		
	}
	
	
	public User select(int id) {
		User user = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_User_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String pass = rs.getString("pass");
				String email = rs.getString("email");;
				user = new User(id, username, pass, email);
			}
			
		} catch (SQLException e) {
			
		}
		
		return user;
		
	}
	
	public User selectName(String username) {
		User user = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_User_BY_username);
			preparedStatement.setString(1, username);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("pass");
				String email = rs.getString("email");;
				user = new User(id, username, pass, email);
			}
			
		} catch (SQLException e) {
			
		}
		
		return user;
		
	}
}