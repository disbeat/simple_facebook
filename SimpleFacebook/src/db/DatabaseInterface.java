package db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Config;

public class DatabaseInterface {

	private static DatabaseInterface dbi;

	private Connection conn;

	private DatabaseInterface() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + Config.getString("DB_PATH").replace("/", File.separator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DatabaseInterface getInstance() {
		if (dbi == null) {
			dbi = new DatabaseInterface();
		}
		return dbi;
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	public int executeUpdate(String sql) throws SQLException {
		Statement stat = conn.createStatement();
		return stat.executeUpdate(sql);
	}

}
