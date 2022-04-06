package test;

import org.junit.jupiter.api.*;
import classi.*;
import java.awt.event.*;

class BBTest {
	BB bb;
		
	@Test
	@RepeatedTest(10)
	@DisplayName("Test for BB")
	void createBB() {
		bb = new BB();
		javax.swing.Timer myTimer = new javax.swing.Timer(10,bb);
		myTimer.start();
		ActionEvent e = new ActionEvent(myTimer, 0, "");
		bb.actionPerformed(e);
	}

}
