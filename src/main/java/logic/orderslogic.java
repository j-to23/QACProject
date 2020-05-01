package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import util.utils;

public class orderslogic implements crud {

	public static final Logger log = Logger.getLogger(orderslogic.class);

	static final String JDBC_DRIVER = utils.JDBC_DRIVER;
	static final String DB_URL = utils.DB_URL;
	static final String USER = utils.getUser();
	static final String PASS = utils.getPass();

	Connection conn = null;
	Statement stmt = null;

	public orderslogic() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting connection to db");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected!!");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(String customerID) {

		String update = "INSERT INTO orders Values(0," + customerID + ",0)";
		log.info(update);
		try {
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String read = "SELECT orderID from invmsdb.orders order by orderID desc limit 1";
		ResultSet rs = null;
		int ID = 0;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				ID = rs.getInt("orderID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Order created, to add items, please create orderlines at orderID: " + ID);
	}

	@Override
	public void read() {
		String read = "SELECT * from orders";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.printf("%-10s %-10s %-10s\n", "orderID", "customerID", "total (£)");
		try {
			while (rs.next()) {
				int orderID = rs.getInt("orderID");
				int customerID = rs.getInt("customerID");
				double total = rs.getDouble("totalcost");
				System.out.printf("%-10s %-10s %-10s\n", orderID, customerID, total);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(String set, String setto, String whereis) {
		log.info("Updating order...");

		String update = "UPDATE orders SET " + set + " = '" + setto + "' WHERE orderID = '" + whereis + "'";
		try {
			stmt.executeUpdate(update);
			log.info("updated");
		} catch (SQLException e) {
			log.info("failure to launch");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		log.info("Deleting " + id + " from orders and orderline...");
		String delete = "DELETE FROM orderline WHERE orderID = " + id;
		String delete1 = "DELETE FROM orders WHERE orderID = " + id;
		try {
			stmt.executeUpdate(delete);
			log.info("Order deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(delete1);
			log.info("Orderlines deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
