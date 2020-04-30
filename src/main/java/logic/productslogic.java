package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import util.utils;

public class productslogic implements crud {
	
	public static final Logger log = Logger.getLogger(productslogic.class);
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://"+utils.MYSQL_URL+"/invmsdb?useSSL=false";
	static final String USER = utils.getUser();
	static final String PASS = utils.getPass();

	Connection conn = null;
	Statement stmt = null;

	public productslogic() {
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

	public void create(String productname, String price, String stock) {
		String update = "INSERT INTO products Values(0,'" + productname + "','" + price + "','" + stock
				+"');";
		try {
			stmt.executeUpdate(update);
			log.info("Product added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void read() {
		String read = "SELECT * from products";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int productID = rs.getInt("productID");
				String productname = rs.getString("productname");
				double price = rs.getDouble("price");
				int stock = rs.getInt("stock");
				System.out.printf("%-5s %-30s %-10s %-10s\n",productID, productname, "£"+price, stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void update(String set, String setto, String whereis) {
		log.info("Updating statement");

		String update = "UPDATE products SET " + set + " = '" + setto + "' WHERE productID = '" + whereis + "'";
		try {
			stmt.executeUpdate(update);
			log.info("updated");
		} catch (SQLException e) {
			// TODO manually typing this is dumb
			log.info("failure to launch");
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		log.info("Deleting " + id + " from products...");
		String delete = "DELETE FROM products WHERE productID = " + id;
		try {
			stmt.executeUpdate(delete);
			log.info("Product deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
