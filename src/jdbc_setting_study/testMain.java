package jdbc_setting_study;

import java.sql.Connection;

import jdbc_setting_study.jdbc.DBCon;

public class testMain {

	public static void main(String[] args) {
		Connection dbcon = DBCon.getInstance().getConnection();
	}

}
