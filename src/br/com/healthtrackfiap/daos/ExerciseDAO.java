package br.com.healthtrackfiap.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrackfiap.models.Exercise;

public class ExerciseDAO {

	private final String INSERT = "INSERT INTO t_exercise(t_user_id_user,label, duration, description) VALUES (?, ?, ?,?) ";
	private String GET_ALL = "SELECT * FROM t_exercise";

	// private String connectionUrl =
	// "jdbc:sqlserver://localhost:1401;databaseName=healthTrackFIAP;user=sa;password=SUA_SENHA_DE_SA";

	public List<Exercise> getAll() {

		List<Exercise> listExercise = new ArrayList<Exercise>();

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			Statement stmt = con.createStatement();
			String SQL = GET_ALL;
			ResultSet rs = stmt.executeQuery(SQL);

			Exercise exercise = new Exercise();
			while (rs.next()) {
				exercise = new Exercise();
				exercise.setIdExercise(rs.getInt("id_exercise"));
				exercise.setLabel(rs.getString("label"));
				exercise.setDuration(rs.getDate("duration"));
				exercise.setDescription(rs.getString("description"));

				listExercise.add(exercise);

			}
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		return listExercise;

	}

	public boolean InsertExercise(Exercise exercise) throws SQLException {

		PreparedStatement stmt;

		boolean sucesso = false;

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			stmt = con.prepareStatement(INSERT);

			stmt.setInt(1, 1);
			stmt.setString(2, exercise.getLabel());
			stmt.setDate(3, new java.sql.Date(exercise.getDuration().getTime()));
			stmt.setString(4, exercise.getDescription());
			stmt.execute();

			sucesso = true;

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return sucesso;

	}

}
