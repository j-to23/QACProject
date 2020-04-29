package util;

import java.util.Scanner;

public class utils {
	public static final String MYSQL_URL = "localhost:3306";
	public static final Scanner sc = new Scanner(System.in);
	
	static String USER = "";
	static String PASS = "";
	
	public static String getUser() {
		return USER;
	}

	public static void setUser(String user) {
		USER = user;
	}

	public static String getPass() {
		return PASS;
	}

	public static void setPass(String pass) {
		PASS = pass;
	}

	public utils() {
	}

	public static String getinput() {
		return sc.nextLine();
	}

}
