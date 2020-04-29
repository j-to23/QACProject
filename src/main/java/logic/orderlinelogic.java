package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import util.utils;

public class orderlinelogic implements crud {

	public static final Logger log = Logger.getLogger(orderlinelogic.class);

	static String getinput() {
		return utils.getinput();
	}

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://" + utils.MYSQL_URL + "/invmsdb?useSSL=false";
	static final String USER = utils.getUser();
	static final String PASS = utils.getPass();

	Connection conn = null;
	Statement stmt = null;
	Scanner sc = new Scanner(System.in);

	public orderlinelogic() {
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
	
	
	
	// create statement
	public void create(String orderID, String productID, String quantity) {
		//string statements to get price of individual item
		String read = "SELECT price from invmsdb.products WHERE productID = "+ productID;
		//string statement to get previous total cost of order being added to
		String read2 = "SELECT totalcost from invmsdb.orders WHERE orderID = "+ orderID;		
		double total = 0;
		double totalcostorders = 0;

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				//total is the quantity of items multiplied by individual price
				total = rs.getDouble("price")*Double.parseDouble(quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rs = null;
		try {
			rs = stmt.executeQuery(read2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				//get previous total cost or order
				totalcostorders = rs.getDouble("totalcost");
				log.info("previous order total: "+totalcostorders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// adds new row to orderline table
		String update = "INSERT INTO orderline Values(0," + orderID + "," + productID + "," + quantity + "," + total + ")";
		// updates associated order row to new orderline
		String update2 = "UPDATE orders SET totalcost = " + (total+totalcostorders) + " WHERE orderID = '" + orderID + "'";
		
		try {
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(update2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		read = "SELECT orderlineID from invmsdb.orderline order by orderlineID desc limit 1";
		rs = null;
		int ID = 0;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				ID = rs.getInt("orderlineID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Item added at orderline: " + ID +", for order ID: "+ orderID);
	}

	@Override
	public void read() {
		String read = "SELECT * from orderline";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int orderlineID = rs.getInt("orderlineID");
				int orderID = rs.getInt("orderID");
				int productID = rs.getInt("productID");
				int quantity = rs.getInt("quantity");
				double cost = rs.getDouble("cost");
				System.out.printf("%-5s %-5s %-5s %-5s %-30s\n",orderlineID, orderID, productID, quantity, cost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(String set, String setto, String where, String whereis) {
		log.info("Please use delete functionality to update orderlines for orders");
	}

	@Override
	public void delete(String id) {
		log.info("Updating linked order");
		String read = "SELECT cost,orderID from invmsdb.orderline where orderlineID ="+id;
		String update = "";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				double cost = rs.getDouble("cost");
				int orderID = rs.getInt("orderID");				
				update = "UPDATE orders SET totalcost = totalcost - " + cost + " WHERE orderID = '" + orderID + "'";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(update);
		try {
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("Deleting " + id + " from orderline...");
		String delete = "DELETE FROM orderline WHERE orderlineID = " + id;
		try {
			stmt.executeUpdate(delete);
			log.info("Orderline deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
