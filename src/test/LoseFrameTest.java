package test;

import org.junit.jupiter.api.*;
import classi.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.*;

import javax.swing.JButton;


class LoseFrameTest {
	LoseFrame lf;
	JButton exit;	
	
	@BeforeEach
	@Test
	@DisplayName("Test for Lose Frame")
	void createLoseFrame() {
		lf = new LoseFrame();
		exit = lf.exit;
	}
	

	@Test
	void pressExit() {
		ActionEvent e = new ActionEvent(exit, 0, "");
		lf.actionPerformed(e);
		assertTrue(!lf.isVisible(), "Errore: lf ancora visibile");
	}

}
