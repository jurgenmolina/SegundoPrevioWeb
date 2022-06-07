package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Bill;
import co.empresa.test.modelo.User;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class BillDaoPostgreSQL implements BillDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_BILL_SQL = "INSERT INTO bill (date_bill, user_id, value, type, observation) VALUES (?, ?, ?, ?, ?);";
	private static final String DELETE_BILL_SQL = "DELETE FROM bill WHERE id = ?;";
	private static final String SELECT_ALL_BILL = "SELECT * FROM bill WHERE user_id = ?;";
	private static final String SELECT_User_BY_ID = "SELECT * FROM bill WHERE id = ?;";
	
	
	
	
	public BillDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	public void insert(Bill bill) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_BILL_SQL);
			preparedStatement.setString(1, bill.getDate_bill());
			preparedStatement.setInt(2, bill.getUser_id().getId());
			preparedStatement.setInt(3, bill.getValue());
			preparedStatement.setInt(4, bill.getType());
			preparedStatement.setString(5, bill.getObservation());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}

	
	
	public void delete (int id)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_BILL_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	
	
	public List<Bill> selectAll(int x) {
		List <Bill> bills = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_BILL);
			preparedStatement.setInt(1, x);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String date_bill = rs.getString("date_bill");
				User user_id = new User();
				user_id.setId(x);
				int value = rs.getInt("value");
				int type = rs.getInt("type");
				String observation = rs.getString("observation");
				bills.add(new Bill(id, date_bill, user_id, value, type, observation));
			}
			
		} catch (SQLException e) {
			
		}
		
		return bills;
		
	}
	
	
	public Bill select(int id) {
		Bill bill = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_User_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String date_bill = rs.getString("date_bill");
				int x = rs.getInt("user_id");
				User user_id = new User();
				user_id.setId(x);
				int value = rs.getInt("value");
				int type = rs.getInt("type");
				String observation = rs.getString("observation");
				bill = new Bill(id, date_bill, user_id, value, type, observation);
			}
			
		} catch (SQLException e) {
			
		}
		
		return bill;
		
	}
	
	
}