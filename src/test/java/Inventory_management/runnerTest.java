package Inventory_management;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;


class runnerTest {
	
	@Mock
	ims invms;
	@Test
	void testmain() {
		ims Ims = mock(ims.class);
		doNothing().when(Ims).invms();
		runner.main(null);
		
		verify(Ims, times(1)).invms();
	}

}
