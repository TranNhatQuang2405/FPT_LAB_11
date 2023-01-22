package fpt.lab.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseLoader {

	private static String DB_URL = null;
	private static String USER_NAME = null;
	private static String PASSWORD = null;

	public static Connection getConnection() {
		if (DB_URL == null) {
			getResource();
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			return connection;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private static void getResource() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("app.properties");
			Properties properties = new Properties();
			properties.load(input);
			DB_URL = properties.getProperty("database.url");
			USER_NAME = properties.getProperty("database.user");
			PASSWORD = properties.getProperty("database.password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
