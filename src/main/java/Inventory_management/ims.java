package Inventory_management;

import org.apache.log4j.Logger;

import logic.daos;
import useraction.operator;
import useraction.table;
import util.utils;

public class ims {

	static String getinput() {
		return utils.getinput();
	}

	private static final Logger log = Logger.getLogger(ims.class);

	public void invms() {
		// variable declaration
		boolean programclose = true;
		String closecheck = "";
		switchcase swc = new switchcase();
		table t = new table();
		operator o = new operator();
		// welcome strings
		log.info("Welcome to your inventory management system!\n\n");

		daos.userset();
		daos.passset();

		// loop for continued operation
		do {
			// Select which table in DB to edit
			String table = t.tableselect();

			// CRUD statement to run check
			String operator = o.operatorselect();

			// switch case method hand-off
			swc.swcase(table, operator);

			log.info("\nAnything else (y/n)?");
			closecheck = getinput();
			log.info("\n");
			if (closecheck.equals("n") || closecheck.equals("N")) {
				programclose = false;
			}
		} while (programclose);

		log.info("Program closed");

	}
}
