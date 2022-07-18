package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import classi.*;

public class GamecoreTest {
	gamecore gc;
	
	@Test
	@BeforeEach
	@DisplayName("Test creazione gamecore")
	void createGamecore() {
		gc = new gamecore();
		assertEquals(gc.getLVL(), 0, "Il livello non è corretto" );
		assertEquals(gc.getLives(), 3, "Le vite non sono corrette" );
	}
	
	@Test
	@DisplayName("Test reset")
	void resetTest() {
		int score = gc.getScore();
		gc.reset();
		assertEquals(gc.getScore(), score + 10, "Reset non è corretto" );
	}
	
	@Test
	@DisplayName("Test modify lives")
	void livesTest() {
		int i = (int)Math.random()+1;
		gc.modlives(i);
		assertEquals(gc.getLives(), i, "le vite non sono corrette" );
	}
	
	@Test
	@DisplayName("Test reset gamecore")
	void resetGamecore() {
		gc.resetcore();
		assertEquals(gc.getLives(), 3, "Resetcore non è corretto" );
		assertEquals(gc.getLVL(), 0, "Resetcore non è corretto" );
	}

}
