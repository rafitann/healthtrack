package br.com.healthtrackfiap.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrackfiap.models.BloodPressure;

public class BloodPressureDAO {

	private final String INSERT = "INSERT INTO t_blood_pressure(t_user_id_user, value_blood_pressure) VALUES (?, ?) ";
	private final String GET_ALL = "SELECT * FROM t_blood_pressure";

	public List<BloodPressure> getAll() {

		List<BloodPressure> listPressure = new ArrayList<BloodPressure>();

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(GET_ALL);

			BloodPressure pressure = new BloodPressure();
			
			while (rs.next()) {
				
				pressure = new BloodPressure();
				pressure.setIdBloodPressure(rs.getInt("id_blood_pressure"));
				pressure.setValueBloodPressure(rs.getDouble("value_blood_pressure"));

				listPressure.add(pressure);

			}
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		return listPressure;

	}

	public boolean InsertPressure(BloodPressure pressure) throws SQLException {

		boolean sucesso = false;

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			PreparedStatement stmt;
			
			stmt = con.prepareStatement(INSERT);

			stmt.setInt(1, 1);
			stmt.setDouble(2, pressure.getValueBloodPressure());
			stmt.execute();
			sucesso = true;

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return sucesso;
	}
}
