package useraction;

import org.apache.log4j.Logger;

import logic.orderlinelogic;
import util.utils;

public class orderline implements tableinputs {

	public static final Logger log = Logger.getLogger(orderline.class);

	static String getinput() {
		return utils.getinput();
	}

	orderlinelogic oll = new orderlinelogic();

	@Override
	public void create() {
		log.info("Order ID to add item to: ");
		String orderID = getinput();
		log.info("Product ID of item to add: ");
		String productID = getinput();
		log.info("Quantity of item to add: ");
		String quantity = getinput();
		oll.create(orderID, productID, quantity);
	}

	@Override
	public void read() {
		oll.read();
	}

	@Override
	public void update() {
		
		log.info("Which orderline to update by ID: ");
		String whereis = getinput();

		log.info("Column to change (orderID, productID, quantity, cost): ");
		String set = getinput();

		log.info("Change value to: ");
		String setto = getinput();

		oll.update(set, setto, whereis);
	}

	@Override
	public void delete() {
		System.out.println("Which order ID and associated orderline items to delete?");
		String id = getinput();
		oll.delete(id);
	}
}
