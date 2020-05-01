package Inventory_management;



import useraction.customers;

import useraction.orderline;
import useraction.orders;
import useraction.products;

public class switchcase {
	
	public static void swcase(String table, String operation) {
		switch (table) {
		case "1":
		case "customers":
			customers c = new customers();
			switch (operation) {
			case "1":
			case "create":
				c.create();
				break;
			case "2":
			case "read":
				c.read();
				break;
			case "3":
			case "update":
				c.update();
				break;
			case "4":
			case "delete":
				c.delete();
				break;
			}
			break;
		case "2":
		case "products":
			products p = new products();
			switch (operation) {
			case "1":
			case "create":
				p.create();
				break;
			case "2":
			case "read":
				p.read();
				break;
			case "3":
			case "update":
				p.update();
				break;
			case "4":
			case "delete":
				p.delete();
				break;
			}
			break;
		case "3":
		case "orders":
			orders o = new orders();
			switch (operation) {
			case "1":
			case "create":
				o.create();
				break;
			case "2":
			case "read":
				o.read();
				break;
			case "3":
			case "update":
				o.update();
				break;
			case "4":
			case "delete":
				o.delete();
				break;
			}
			break;
		case "4":
		case "orderline":
			orderline ol = new orderline();
			switch (operation) {
			case "1":
			case "create":
				ol.create();
				break;
			case "2":
			case "read":
				ol.read();
				break;
			case "3":
			case "update":
				ol.update();
				break;
			case "4":
			case "delete":
				ol.delete();
				break;
			}
			break;
		}
		
	}


	
}
