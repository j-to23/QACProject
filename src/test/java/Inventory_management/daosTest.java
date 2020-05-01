package Inventory_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import util.utils;

class daosTest {
	
	@Before
	public void setup() {
	utils.setUser("root");
	utils.setPass("root");
	}
	
	
	@Test
	void testuser() {
		Mockito.when(utils.getinput()).thenReturn("root");
		assertEquals("root", daos.userset());
	}
	

	@Test
	void testpass() {
		fail("Not yet implemented");
	}
}
