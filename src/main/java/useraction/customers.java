package useraction;

import org.apache.log4j.Logger;

import logic.customerslogic;
import util.utils;

public class customers implements tableinputs {
	
	private static final Logger log = Logger.getLogger(customerslogic.class);

	static String getinput() {
		return utils.getinput();
	}
	
	customerslogic cl = new customerslogic();
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		log.info("Customer's full name: ");
		String fullname = getinput();

		log.info("First line of address: ");
		String address = getinput();

		log.info("Customer's postcode: ");
		String postcode = getinput();

		log.info("Customer's email: ");
		String email = getinput();
		
		cl.create(fullname, address, postcode, email);
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		cl.read();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		log.info("column to set: ");
		String set = getinput();

		log.info("set values to: ");
		String setto = getinput();

		log.info("where: ");
		String where = getinput();

		log.info("is equal to: ");
		String whereis = getinput();
		cl.update(set, setto, where, whereis);
	}

	@Override
	public void delete() {
		log.info("Which customer ID to delete?");
		String id = getinput();
		cl.delete(id);
	}

}
