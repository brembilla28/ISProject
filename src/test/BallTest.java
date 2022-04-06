package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.*;

import classi.*;

class BallTest {
	Ball ball;
	
	@BeforeEach
	@Test
	@DisplayName("Test for ball")
	void createBall() {
		double x = Math.random(), y = Math.random();
		ball = new Ball(x,y);
		assertEquals(ball.getX(), x, "La x non corrisponde");
		assertEquals(ball.getY(),y, "La y non corrisponde");
	}
	
	@RepeatedTest(5)
	@DisplayName("Test for moving the ball")
	void moveBall() {
		double dx = Math.random(), dy = Math.random();
		ball.setDX(dx);
		ball.setDY(dy);
		ball.move();
		assertEquals(ball.getDX(), dx, "Velocità x errata");
		assertEquals(ball.getDY(), dy, "Velocità y errata");
	}
	
	@Test
	@DisplayName("Test for loading the image")
	void getImage() {
		assertEquals(ball.getImage(), new ImageIcon("ball.png").getImage());
	}
	
}
