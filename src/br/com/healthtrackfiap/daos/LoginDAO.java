package br.com.healthtrackfiap.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.healthtrackfiap.models.User;
import br.com.healthtrackfiap.models.WeightHeight;
import br.com.healthtrackfiap.utils.FormatadorData;

public class LoginDAO {

	public User getUser(String user, String password) {

		User usr = null;

		try {
			Class.forName(ConfiguracaoBD.DRIVER);
			Connection con = DriverManager.getConnection(ConfiguracaoBD.connectionUrl);
			PreparedStatement stmt = con.prepareStatement("select * from t_login WHERE login = ? AND password = ?");

			stmt.setString(1, user);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				stmt = con.prepareStatement("select * from t_user WHERE id_user = ?");
				stmt.setInt(1, rs.getInt("t_user_id_user"));
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					usr = new User();
					usr.setUserID(rs.getString("id_user"));
					usr.setName(rs.getString("first_name"));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usr;

	}

}
