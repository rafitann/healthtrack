package br.com.healthtrackfiap.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.healthtrackfiap.models.WeightHeight;
import br.com.healthtrackfiap.utils.FormatadorData;

public class WeightHeightDAO {

	// private String connectionUrl =
	// "jdbc:sqlserver://localhost:1401;databaseName=healthTrackFIAP;user=sa;password=SUA_SENHA_DE_SA";
	private final String INSERT = "INSERT INTO t_weight_height (t_user_id_user, height, weight) VALUES ( ?, ?, ?) ";
	private final String GET_ALL = "SELECT * FROM t_weight_height";

	public List<WeightHeight> getAll() {

		List<WeightHeight> listInfo = new ArrayList<WeightHeight>();

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_ALL);

			WeightHeight imc = new WeightHeight();
			while (rs.next()) {
				imc = new WeightHeight();
				imc.setIdImc(rs.getString("id_weight_height"));
				imc.setHeight(rs.getDouble("height"));
				imc.setWeight(rs.getDouble("weight"));
				imc.setCreatedAt(FormatadorData.parseDate(rs.getString("created_at")));
				
				listInfo.add(imc);

			}
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		return listInfo;

	}

	public boolean insertWeightHeight(WeightHeight weightHeight) throws SQLException {

		PreparedStatement stmt;

		boolean sucesso = false;

		try {

			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			stmt = con.prepareStatement(INSERT);
			stmt.setInt(1, 1);
			stmt.setDouble(2, weightHeight.getHeight());
			stmt.setDouble(3, weightHeight.getWeight());
			//stmt.setDate(4, weightHeight.getCreatedAt());
			stmt.execute();

			sucesso = true;

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return sucesso;

	}
}
