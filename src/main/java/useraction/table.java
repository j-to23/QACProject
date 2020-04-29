package useraction;

import util.utils;

public class table {
	
	
	public table() {
		
	}
	
	String getinput(){
		return utils.getinput();
	}
	
	public String tableselect() {
		//variable initialisation
		String table = "";		boolean tablecheck = true;
		// table to edit check
		System.out.println("Would you like to edit Users(1), Products(2), Orders(3) or Orderline(4)?");
		do {
			table = getinput().toString().toLowerCase();
			if (table.equals("1") || table.equals("2") || table.equals("3") || table.equals("4")
					|| table.equals("customers") || table.equals("products") || table.equals("orders")
					|| table.equals("orderline")) {
				tablecheck = false;
			} else {
				System.out.println("Please type one of the given options or its associated number.");
			}
		} while (tablecheck);
		
		return table;
	}
}
