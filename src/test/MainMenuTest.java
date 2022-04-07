package test;

import org.junit.AfterClass;
import org.junit.jupiter.api.*;
import classi.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.*;

import javax.swing.JButton;

class MainMenuTest {
	MainMenu mm;
	JButton start, help, exit;	
	
	@BeforeEach
	@Test
	@DisplayName("Test for Main Menu")
	void createMainMenu() {
		mm = new MainMenu();
		start = mm.start;
		help = mm.help;
		exit = mm.exit;
		Robot bot;
		
		try {
			bot = new Robot();
			bot.mouseMove(10,10);
			bot.mousePress(InputEvent.BUTTON1_MASK);
			//add time between press and release or the input event system may 
			//not think it is a click
			Thread.sleep(250);
			bot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch(InterruptedException e2){
		} catch (AWTException e1) {}	
	}

	
	@Test
	void pressStart() {
		ActionEvent e = new ActionEvent(start, 0, "");
		mm.actionPerformed(e);
		assertTrue(!mm.isVisible(), "Errore: mm ancora visibile");
	}

	
	@Test
	void pressHelp() {
		ActionEvent e = new ActionEvent(help, 0, "");
		mm.actionPerformed(e);
		assertTrue(!mm.isVisible(), "Errore: mm ancora visibile");
	}

}
