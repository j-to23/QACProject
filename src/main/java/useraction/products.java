package useraction;
import org.apache.log4j.Logger;

import logic.productslogic;
import util.utils;


public class products implements tableinputs  {
	
	public static final Logger log = Logger.getLogger(products.class);
	
	static String getinput() {
		return utils.getinput();
	}
	
	productslogic pl = new productslogic();
	
	public void create() {
		log.info("Product name: ");
		String productname = getinput();

		log.info("Product price (eg. 20.99 or 21):  ");
		String price = getinput();

		log.info("Product stock: ");
		String stock = getinput();
		
		pl.create(productname, price, stock);
	}

	public void read() {
		pl.read();
	}

	public void update() {
		log.info("Product by ID to update: ");
		String whereis = getinput();

		log.info("Column to change (productname, price, stock): ");
		String set = getinput();

		log.info("Change value to: ");
		String setto = getinput();

		pl.update(set, setto, whereis);
	}

	public void delete() {
		log.info("Which product ID to delete?");
		String id = getinput();
		pl.delete(id);
	}

}
