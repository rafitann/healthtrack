package br.com.healthtrackfiap.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrackfiap.models.Food;

public class FoodDAO {

	// private String connectionUrl =
	// "jdbc:sqlserver://localhost:1401;databaseName=healthTrackFIAP;user=sa;password=SUA_SENHA_DE_SA";

	private String connectionUrl = ConfiguracaoBD.connectionUrl;
	private final String INSERT = "INSERT INTO t_food (t_user_id_user, calories, description) VALUES ( ?, ?, ?) ";

	public FoodDAO() {

	}

	public List<Food> getAll() {

		List<Food> listFood = new ArrayList<Food>();

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			Statement stmt = con.createStatement();
			String SQL = "SELECT * FROM t_food";
			ResultSet rs = stmt.executeQuery(SQL);

			Food food = new Food();
			while (rs.next()) {
				food = new Food();
				food.setId_food(rs.getInt("id_food"));
				food.setCalories(rs.getDouble("calories"));
				food.setDescription(rs.getString("description"));

				listFood.add(food);

			}
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		return listFood;

	}

	public boolean InsertFood(Food food) throws SQLException {

		Connection con = DriverManager.getConnection(connectionUrl);
		PreparedStatement stmt;

		boolean sucesso = false;

		try {

			stmt = con.prepareStatement(INSERT);

			stmt.setInt(1, 1);
			stmt.setDouble(2, food.getCalories());
			stmt.setString(3, food.getDescription());

			stmt.execute();
			sucesso = true;

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return sucesso;

	}
}
