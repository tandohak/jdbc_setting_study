package jdbc_setting_study.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;

	public static DBCon getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}	
	
	private DBCon() {
		Properties properties = getPropertys("conf.properties");
		
//		properties에 미리 생성한 properites파일에 저장된 패스를 키값으로 받아온다.
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("pwd");
		String url = properties.getProperty("url");
		
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
		
	}

	private Properties getPropertys(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		// 클래스 로더로 propertiesPath파일을 읽어 온다.
		
		try {
			properties.load(is);//properties에  propertiesPath를 읽어들여 불러온다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
}
