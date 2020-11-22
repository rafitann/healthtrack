package br.com.healthtrackfiap.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GenericDAO {

	@FunctionalInterface
	public interface SQLExpression {
		public Object prepare(ResultSet resultSet);
	}
	
	private Connection connection;
	protected String table;
	private String insertSQL;
	private String updateSQL;

	public GenericDAO(Connection con) {
		this.connection = con;
		//this.table = table;
	}
	
	protected void setInsertSQL(String sql) {
		this.insertSQL = sql;
	}

	protected void setUpdateSQL(String sql) {
		this.updateSQL = sql;
	}

	public void insert(Object object) {
		System.out.println(insertSQL);
		try (PreparedStatement stmt = connection.prepareStatement(insertSQL)) {
			//this.setStatementValues(stmt, object);
			stmt.execute();
		} catch (SQLException ex) {
			this.treatException(ex);
		}
	}

	public void update(Object object) {
		try (PreparedStatement stmt = connection.prepareStatement(updateSQL)) {
			//this.setStatementValues(stmt, object);
			stmt.execute();
		} catch (SQLException ex) {
			this.treatException(ex);
		}
	}

	public void delete(int id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", table);
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException ex) {
			this.treatException(ex);
		}
	}

	public Object find(int id) {
		String sql = String.format("SELECT * FROM %s WHERE id = ?", table);
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			return executeResultSet(stmt);
		} catch (SQLException ex) {
			this.treatException(ex);
			return null;
		}

	}

	public ArrayList<?> findAll(String sql, SQLExpression expression) {
		ArrayList<Object> items = new ArrayList<>();

		//String sql = String.format("SELECT * FROM %s", table);
		
		try (Statement stmt = connection.createStatement()) {
			stmt.execute(sql);
			
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) 
					items.add(expression.prepare(rs));
			} catch (Exception ex) {}
			
			return items;
			
		} catch (SQLException ex) {
			this.treatException(ex);
			return null;
		}
	}
	
	private Object executeResultSet(PreparedStatement stmt) {
		try (ResultSet rs = stmt.getResultSet()) {
			rs.next();
			//return this.createObject(rs);
			return null;
		} catch (Exception ex) {
			this.treatException(ex);
			return null;
		}
	}

	private ArrayList<?> executeResultSet(Statement stmt) {
		ArrayList<Object> resultset = new ArrayList<Object>();

		try (ResultSet rs = stmt.getResultSet()) {
			while (rs.next()) {
				//resultset.add(createObject(rs));
			}
		} catch (Exception ex) {
			this.treatException(ex);
		}
		return resultset;
	}

	private void treatException(Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	}

}
