package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import classi.classifica;

public class ClassificaTest {

	classifica classifica = new classifica(1, "s");

	@Test
	@DisplayName("Test score della classifica")
	void scoreClassifica() {
		assertEquals(classifica.score(), 1, "Lo score non è corretto");
	}
	
	@Test
	@DisplayName("Test score della classifica")
	void nameClassifica() {
		assertEquals(classifica.name(), "s", "Il name non è corretto");
	}
	
	@Test
	@DisplayName("Test modifica score della classifica")
	void modificaScoreClassifica() {
		classifica.setscore(2);
		assertEquals(classifica.score(), 2, "Lo score non è corretto");
	}
	
	@Test
	@DisplayName("Test confronto tra classifiche")
	void confrontoClassifiche() {
		classifica classifica2 = new classifica(2, "");
		int confronto = classifica.compareTo(classifica2);
		assertEquals(confronto, 1, "Il confronto non è corretto");
		
		classifica2.setscore(1);
		confronto = classifica.compareTo(classifica2);
		assertEquals(confronto, 1, "Il confronto non è corretto");
		
		classifica2.setscore(0);
		confronto = classifica.compareTo(classifica2);
		assertEquals(confronto, -1, "Il confronto non è corretto");
	}
}
