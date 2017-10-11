package jdbc_setting_study.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
	public static void close(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
