package useraction;

import org.apache.log4j.Logger;

import logic.orderslogic;
import util.utils;

public class orders implements tableinputs  {
	
	public static final Logger log = Logger.getLogger(orders.class);
	
	static String getinput() {
		return utils.getinput();
	}
	
	orderslogic osl = new orderslogic();
	
	@Override
	public void create() {
		log.info("Customer ID for order: ");
		String customerID = getinput();
		osl.create(customerID);
	}

	@Override
	public void read() {
		osl.read();
	}

	@Override
	public void update() {
		
		log.info("Which order to update by ID: ");
		String whereis = getinput();

		log.info("Column to change (customerID, totalcost): ");
		String set = getinput();

		log.info("Change value to: ");
		String setto = getinput();

		osl.update(set, setto, whereis);
	}

	@Override
	public void delete() {
		log.info("Which order ID and associated orderline items to delete?");
		String id = getinput();
		osl.delete(id);
	}
}
