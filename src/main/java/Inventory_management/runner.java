package Inventory_management;

import org.apache.log4j.Logger;

public class runner {

	public static final Logger log = Logger.getLogger(runner.class);
	
	public static void main(String[] args) {
		ims ims = new ims();
		log.info("Welcome to the Inventory management system");
		ims.invms();
	}
}
