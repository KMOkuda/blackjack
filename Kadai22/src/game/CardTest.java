package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testCardInt() {//引数は1~52
		int testN[] = { 1, 13, 14, 52 };
		for (int i = 0; i < testN.length; i++) {
			assertTrue((testN[i] - 1) / 13 >= 0 && (testN[i] - 1) / 13 <= 3);
			//assertTrue(false);
		}
	}

}
