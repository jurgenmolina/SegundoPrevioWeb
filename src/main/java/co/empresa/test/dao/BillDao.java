package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.Bill;
import co.empresa.test.modelo.User;

public interface BillDao {
	public void insert(Bill bill) throws SQLException;
	public void delete(int id) throws SQLException;
	public List < Bill > selectAll(int x);
	public Bill select(int id);
	
}
