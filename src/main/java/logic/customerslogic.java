package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import util.utils;

public class customerslogic implements crud {
	
	private static final Logger log = Logger.getLogger(customerslogic.class);

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://"+utils.MYSQL_URL+"/invmsdb?useSSL=false";
	static final String USER = utils.getUser();
	static final String PASS = utils.getPass();

	Connection conn = null;
	Statement stmt = null;

	public customerslogic() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Starting connection to db");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Connected!!");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void create(String fullname, String address, String postcode, String email) {

		int customerID = 0;

		String update = "INSERT INTO customers Values(0,'" + fullname + "','" + address + "','" + postcode + "','"
				+ email + "')";
		try {
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String read = "SELECT customerID from invmsdb.customers order by customerID desc limit 1";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				customerID = rs.getInt("customerID");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Customer added at customerID: " + customerID);

	}

	@Override
	public void read() {
		String read = "SELECT * from customers";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int customerID = rs.getInt("customerID");
				String fullname = rs.getString("fullname");
				String pw = rs.getString("address");
				String postcode = rs.getString("postcode");
				String email = rs.getString("email");
				System.out.printf("%-5s %-30s %-30s %-30s %-30s\n",customerID, fullname, pw, postcode, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String set, String setto, String where, String whereis) {
		log.info("Updating statement");

		String update = "UPDATE customers SET " + set + " = '" + setto + "' WHERE " + where + " = '" + whereis + "'";
		try {
			stmt.executeUpdate(update);
			log.info("updated");
		} catch (SQLException e) {
			// TODO manually typing this is dumb
			log.info("failure to launch");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String  id) {
		log.info("Deleting " + id + " from customers...");
		String delete = "DELETE FROM customers WHERE customerID = " + id;
		try {
			stmt.executeUpdate(delete);
			log.info("Records deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
