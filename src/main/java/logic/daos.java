package logic;

import org.apache.log4j.Logger;

import util.utils;

public class daos {
	
	public static final Logger log = Logger.getLogger(daos.class);
	
	static String getinput() {
		return utils.getinput();
	}
	
	public static void userset() {
		// table to edit check
		log.info("Database username: ");
		utils.setUser(getinput());
	}
	
	public static void passset() {
		log.info("Database password");
		utils.setPass(getinput());
	}
}
