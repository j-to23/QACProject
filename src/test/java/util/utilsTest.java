package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class utilsTest {
	
	@Before
	public void setup() {

	}
	
	@Test
	void testuserget() {
		utils.setUser("root");

		assertEquals("root",utils.getUser());
	}

	@Test
	void testpassget() {
		utils.setPass("root");

		assertEquals("root",utils.getPass());
	}
}
