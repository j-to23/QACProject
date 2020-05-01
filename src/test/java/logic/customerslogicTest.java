package logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import util.utils;

class customerslogicTest {

	@Before
	public void setup() {

	}

	@Test
	void testcreate() {
		utils.setUser("root");
		utils.setPass("root");
		customerslogic cl = new customerslogic();

		assertEquals("INSERT INTO customers Values(0,'john doe','101 white lane','AA12BB','example@email.com')",
				cl.create("john doe", "101 white lane", "AA12BB", "example@email.com"));
	}

}
