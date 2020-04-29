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
	
	@Override
	public void create() {
		log.info("Product name: ");
		String productname = getinput();

		log.info("Product price (eg. 20.99 or 21):  ");
		String price = getinput();

		log.info("Product stock: ");
		String stock = getinput();
		
		pl.create(productname, price, stock);
	}

	@Override
	public void read() {
		pl.read();
	}

	@Override
	public void update() {
		log.info("Column to set: ");
		String set = getinput();

		log.info("set values to: ");
		String setto = getinput();

		log.info("where: ");
		String where = getinput();

		log.info("is equal to: ");
		String whereis = getinput();
		pl.update(set, setto, where, whereis);
	}

	public void delete() {
		log.info("Which product ID to delete?");
		String id = getinput();
		pl.delete(id);
	}

}
