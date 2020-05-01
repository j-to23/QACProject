package util;

import java.util.Scanner;

public class utils {
	public static final Scanner sc = new Scanner(System.in);
	//Database constants
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "35.246.16.203";
	public static final String DB_NAME = "invmsdb";
	public static final String DB_URL = "jdbc:mysql://" + MYSQL_URL + "/" + DB_NAME + "?useSSL=false";
	static String USER = "";
	static String PASS = "";
	
	public static String getUser() {
		return USER;
	}

	public static String setUser(String user) {
		USER = user;
		return USER;
	}

	public static String getPass() {
		return PASS;
	}

	public static String setPass(String pass) {
		PASS = pass;
		return PASS;
	}

	public utils() {
	}

	public static String getinput() {
		return sc.nextLine();
	}

}
