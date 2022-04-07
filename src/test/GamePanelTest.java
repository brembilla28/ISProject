package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classi.*;

class GamePanelTest {
	
	GamePanel gp;
	
	@BeforeEach
	@Test
	void createGamePanel() {
		gp = new GamePanel();	
	}

	@Test
	void reset() {
		gp.reset();
    	assertEquals(gp.ball.getX(),245, "Errore nel reset");
    	assertEquals(gp.ball.getY(),460, "Errore nel reset");
    	assertEquals(gp.ball.getDX(),0, "Errore nel reset");
    	assertEquals(gp.ball.getDY(),0, "Errore nel reset");
	}
	
	@Test
	void bordoDx() {
		Ball ball = new Ball(0,0);
		ball = gp.ball;
		ball.setDX(1);
		ball.setX(490);
		gp.checkContact();
		assertEquals(ball.getDX(),-1, "Errore nel contatto coi bordi");
	}
	
	@Test
	void bordoSx() {
		Ball ball = new Ball(0,0);
		ball = gp.ball;
		ball.setDX(1);
		ball.setX(0);
		gp.checkContact();
		assertEquals(ball.getDX(),-1, "Errore nel contatto coi bordi");
	}
	
	@Test
	void bordoAlto() {
		Ball ball = new Ball(0,0);
		ball = gp.ball;
		ball.setDY(1);
		ball.setY(-1);
		gp.checkContact();
		assertEquals(ball.getDY(),-1, "Errore nel contatto coi bordi");
	}
	
	@Test 
	void getLevel() {
		assertEquals(gp.getLVL(),0, "Errore nei livelli");
	}
	@Test 
	void getScore() {
		assertEquals(gp.getScore(),0, "Errore nello score");
	}
	@Test
	void getLives() {
		assertEquals(gp.getLives(),3, "Errore nelle vite");
	}
}
