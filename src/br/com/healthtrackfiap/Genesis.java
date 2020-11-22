package br.com.healthtrackfiap;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.healthtrackfiap.daos.ConfiguracaoBD;
import br.com.healthtrackfiap.daos.GenericDAO;
import br.com.healthtrackfiap.daos.GenericDAO.SQLExpression;

public class Genesis {

	public static void main(String[] args) {
		try {
			// bloodPressure();

			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			GenericDAO dao = new GenericDAO(con);

			@SuppressWarnings("unchecked")
			ArrayList<String> a = (ArrayList<String>) dao.findAll("SELECT * FROM t_food", new GenericDAO.SQLExpression() {
				public Object prepare(ResultSet resultSet) {
					try {
						return resultSet.getString("description");
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			
			System.out.println(a);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void bloodPressure() throws Exception {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			Statement stmt = con.createStatement();

			StringBuffer buffer = new StringBuffer();
			Scanner scanner = new Scanner(new File("script.sql"));
			while (scanner.hasNext())
				buffer.append(scanner.nextLine());

			String[] scripts = buffer.toString().split(";");

			for (String string : scripts) {
				stmt.execute(String.format("%s;", string));
			}

			ResultSet query = stmt.executeQuery("SELECT * FROM t_food");
			while (query.next()) {
				System.out.println(query.getInt("id_food"));
			}

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
