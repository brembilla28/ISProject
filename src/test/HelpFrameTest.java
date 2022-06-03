package test;

import org.junit.jupiter.api.*;
import classi.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.*;

import javax.swing.JButton;


class HelpFrameTest {
	HelpFrame hf;
	JButton exit;	
	
	@BeforeEach
	@Test
	@DisplayName("Test for Help Frame")
	void createHelpFrame() {
		hf = new HelpFrame();
		exit = hf.exit;
	}

	

	@Test
	void pressExit() {
		ActionEvent e = new ActionEvent(exit, 0, "");
		hf.actionPerformed(e);
		assertTrue(!hf.isVisible(), "Errore: helpframe ancora visibile");
	}
}
