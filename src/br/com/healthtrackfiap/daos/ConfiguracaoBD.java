package br.com.healthtrackfiap.daos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoBD {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static String connectionUrl = String.format("jdbc:sqlite:healthTrackFIAP.db");

	// public static final String connectionUrl =
	// "jdbc:sqlite::memory:healthTrackFIAP";
	// public static final String connectionUrl =
	// "jdbc:sqlserver://localhost:1401;databaseName=healthTrackFIAP;user=sa;password=SUA_SENHA_DE_SA";

	public static void load(File f) {
		connectionUrl = String.format("jdbc:sqlite:%s", f.getAbsolutePath());
	}

	public static void createDatabase() {
		String script = "CREATE TABLE IF NOT EXISTS t_user(\n" + "    id_user INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    first_name TEXT NOT NULL,\n" + "    last_name TEXT,\n" + "    birthday DATE,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_address(\n" + "    id_address INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    t_user_id_user INTEGER NOT NULL,\n" + "    active TEXT NOT NULL,\n" + "    type TEXT,\n"
				+ "    street TEXT,\n" + "    neighbourhood TEXT,\n" + "    city TEXT,\n" + "    state TEXT,\n"
				+ "    postal_code TEXT NOT NULL,\n" + "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_blood_pressure(\n"
				+ "    id_blood_pressure INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    t_user_id_user INTEGER NOT NULL,\n" + "    value_blood_pressure NUMERIC,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_email(\n" + "    id_email INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    t_user_id_user INTEGER NOT NULL,\n" + "    type TEXT,\n" + "    address_email TEXT,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" + "    active TEXT,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_exercise(\n" + "    id_exercise INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    t_user_id_user INTEGER NOT NULL,\n" + "    label TEXT NOT NULL,\n"
				+ "    duration DATE NOT NULL,\n" + "    description TEXT,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_food(\n" + "    id_food INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    calories INTEGER,\n" + "    description TEXT,\n" + "    t_user_id_user INTEGER NOT NULL,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_location(\n" + "    id_location INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    t_exercise_id_exercise INTEGER NOT NULL,\n" + "    latitude NUMERIC NOT NULL,\n"
				+ "    longitude NUMERIC NOT NULL,\n" + "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    FOREIGN KEY(t_exercise_id_exercise) REFERENCES t_exercise(id_exercise)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_login(\n" + "    id_login INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    login TEXT NOT NULL,\n" + "    password TEXT NOT NULL,\n"
				+ "    t_user_id_user INTEGER NOT NULL,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_phone(\n" + "    id_phone INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    t_user_id_user INTEGER NOT NULL,\n" + "    type TEXT DEFAULT 'home',\n"
				+ "    number_phone TEXT,\n" + "    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    active TEXT NOT NULL,\n" + "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n"
				+ ");\n" + "CREATE TABLE IF NOT EXISTS t_subscription(\n"
				+ "    id_subscription INTEGER PRIMARY KEY AUTOINCREMENT,\n" + "    t_user_id_user INTEGER NOT NULL,\n"
				+ "    active TEXT NOT NULL,\n" + "    expiration DATE NOT NULL,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    t_plan_id_plan INTEGER NOT NULL,\n"
				+ "    FOREIGN KEY(t_plan_id_plan) REFERENCES t_plan(id_plan),\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_weight_height(\n"
				+ "    id_weight_height INTEGER PRIMARY KEY AUTOINCREMENT,\n" + "    t_user_id_user INTEGER NOT NULL,\n"
				+ "    height INTEGER NOT NULL,\n" + "    weight NUMERIC NOT NULL,\n"
				+ "    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)\n" + ");\n"
				+ "CREATE TABLE IF NOT EXISTS t_plan(\n" + "    id_plan INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    type TEXT NOT NULL,\n" + "    description TEXT\n" + ");\n" + "\n";

		try {
			execute(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void populate() {
		String script = "INSERT INTO\n" + "   t_user(first_name, last_name, birthday, created_at) \n" + "VALUES\n"
				+ "   (\n" + "      'João', 'Cleber', '1990-06-20', datetime('now')\n" + "   )\n" + ";\n"
				+ "INSERT INTO\n" + "   t_user(first_name, last_name, birthday, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      'Maria', 'Bonita', '1980-07-12', datetime('now')\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_user(first_name, last_name, birthday, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      'Guilherme', 'Gomes', '1999-01-10', datetime('now') \n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_user(first_name, last_name, birthday, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      'Marina', 'Teixeira', '1987-04-19', datetime('now') \n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_user(first_name, last_name, birthday, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      'Luiz', 'Oliveira', '1997-11-03', datetime('now') \n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_weight_height(t_user_id_user, height, weight, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 1.50, 80.8, '2019-06-12'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_weight_height(t_user_id_user, height, weight, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 1.50, 97.5, '2020-08-10'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_weight_height(t_user_id_user, height, weight, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 1.50, 98.0, '2020-10-16'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 15.6, '2020-08-10'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 12.13, '2020-10-16'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      1, 11.13, '2020-10-18'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 16.13, '2020-10-19'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_exercise( t_user_id_user, label, duration, description, created_at ) \n" + "VALUES\n" + "   (\n"
				+ "      2, 'Futebol', '2019-06-12', 'Futebol com a Gelera', '2019-06-12' \n" + "   )\n" + ";\n"
				+ "INSERT INTO\n" + "   t_exercise( t_user_id_user, label, duration, description, created_at ) \n"
				+ "VALUES\n" + "   (\n" + "      2, 'Futebol', '2020-08-10', 'futebol denovo ', '2020-08-10' \n"
				+ "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_exercise( t_user_id_user, label, duration, description, created_at ) \n" + "VALUES\n" + "   (\n"
				+ "      3, 'Futebol', '2020-10-19', 'futebol na praia', '2020-10-19' \n" + "   )\n" + ";\n"
				+ "INSERT INTO\n" + "   t_exercise( t_user_id_user, label, duration, description, created_at ) \n"
				+ "VALUES\n" + "   (\n" + "      2, 'Futebol', '2020-10-19', 'futebol na quadra', '2020-10-19' \n"
				+ "   )\n" + ";\n" + "INSERT INTO\n" + "   t_food(t_user_id_user, calories, description, created_at) \n"
				+ "VALUES\n" + "   (\n" + "      2, 500, 'lasanha de 4 queijos', '2020-08-10'\n" + "   )\n" + ";\n"
				+ "INSERT INTO\n" + "   t_food(t_user_id_user, calories, description, created_at) \n" + "VALUES\n"
				+ "   (\n" + "      2, 80, 'maça', '2020-10-16'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_food(t_user_id_user, calories, description, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      2, 900, 'bolo de cenoura', '2020-10-19'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_food(t_user_id_user, calories, description, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      4, 1000, 'Feijoada de Domingo', '2020-09-19'\n" + "   )\n" + ";\n" + "INSERT INTO\n"
				+ "   t_food(t_user_id_user, calories, description, created_at) \n" + "VALUES\n" + "   (\n"
				+ "      4, 90, 'Salada De Fruta', '2020-10-19'\n" + "   )\n" 
				+ "INSERT INTO\n"
				+ "   t_login(login, password, t_user_id_user) \n"
				+ "VALUES\n"
				+ "   (\n"
				+ "      'haha@tutu', '123456', 4\n"
				+ "   )\n"
				+ ";";

		try {
			execute(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void execute(String script) throws Exception {

		Class.forName(DRIVER);

		Connection con = DriverManager.getConnection(connectionUrl);
		try (Statement stmt = con.createStatement()) {
			String[] scripts = script.split(";");
			for (String string : scripts) {
				stmt.execute(String.format("%s;", string));
			}
		} catch (Exception e) {
		}

	}

}
