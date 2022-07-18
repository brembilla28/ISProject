package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import classi.*;

public class ContainerTest {
	
	@Test
	@DisplayName("Test creazione container")
	void createContainer() {
		Container c = new Container();
		assertEquals(c.getSize().height, 600, "L'altezza non è corretta" );
		assertEquals(c.getSize().width, 800, "La larghezza non è corretta" );
	}
	
	@Test
	@DisplayName("Test setcore container")
	void setcoreContainer() {
		Container c = new Container();
		c.setcore();
	}
}
