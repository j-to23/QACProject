package Inventory_management;

import org.apache.log4j.Logger;

import util.utils;

public class daos {
	
	public static final Logger log = Logger.getLogger(daos.class);
	
	public static String userset() {
		// table to edit check
		log.info("Database username: ");
		utils.setUser(utils.getinput());
		return utils.getUser();
	}
	
	public static String passset() {
		log.info("Database password");
		utils.setPass(utils.getinput());
		return utils.getPass();
	}
}
