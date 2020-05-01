package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class factory {
	
	static factory factory1 = null;
	
	//Database stuff
	Statement stmt = null;
	Connection conn = null;
	
	public Connection getconn() {
		if (conn != null) {
			return conn;
		} else {
			try {
				conn = DriverManager.getConnection(utils.DB_URL, utils.getUser(), utils.getPass());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	}

	public Statement getstmt() {
		if (stmt != null) {
			return stmt;
		} else {
			try {
				stmt = getconn().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stmt;
		}
	}
	
}
