package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import classi.*;

class BrickTest {
	Brick brick;

	@Test
	@DisplayName("Test for brick")
	void createBrick() {
		int x = (int)Math.random(), y = (int)Math.random();
		int hp = (int)Math.random();
		brick = new Brick(x,y,hp);
		assertEquals(brick.getX(), x, "La x non corrisponde");
		assertEquals(brick.getY(),y, "La y non corrisponde");
		assertEquals(brick.getHP(), hp, "La hp non corrisponde");
		hp = (int)Math.random();
		brick.setHP(hp);
		assertEquals(brick.getHP(), hp, "Il metodo setHP non funziona");
	}
}
