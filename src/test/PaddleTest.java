package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import classi.Paddle;

class PaddleTest {
	Paddle pad;
	@BeforeEach
	@Test
	@DisplayName("Test for paddle")
	void createPaddle() {
		int x = (int)Math.random(), y = (int)Math.random();
		pad = new Paddle(x,y);
		assertEquals(pad.getX(), x, "La x non corrisponde");
		assertEquals(pad.getY(),y, "La y non corrisponde");
	}
	@RepeatedTest(5)
	@DisplayName("Test for moving the paddle right")
	void testmoveright() {
		int x = (int)Math.random()*499;
		pad.setX(x);
		boolean[] keys = new boolean[2000];
		keys[KeyEvent.VK_RIGHT] = true;
		pad.move(keys);
		assertEquals(pad.getX(), x+5, "La x non corrisponde");
	}
	
	@RepeatedTest(5)
	@DisplayName("Test for moving the paddle left")
	void testmoveleft() {
		int x = (int)(Math.random()*499+1);
		pad.setX(x);
		boolean[] keys = new boolean[2000];
		keys[KeyEvent.VK_LEFT] = true;
		pad.move(keys);
		assertEquals(pad.getX(), x-5, "La x non corrisponde");
	}

	@Test
	@DisplayName("Test for paddle get coordinates")
	void testSet() {
		int x = (int)Math.random(), y = (int)Math.random();
		pad.setX(x);
		pad.setY(y);
		assertEquals(pad.getX(), x, "La x non corrisponde");
		assertEquals(pad.getY(),y, "La y non corrisponde");

	}


}