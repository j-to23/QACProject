package useraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.customerslogic;
import logic.productslogic;
import util.utils;

class productsTest {

	@Test
	void testcreate() {
		utils.setUser("root");
		utils.setPass("root");
		productslogic pl = new productslogic();

		assertEquals("INSERT INTO products Values(0,'example name','2','3');",
				pl.create("example name", "2", "3"));

	}

}
