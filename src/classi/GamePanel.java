package classi;

import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class gamepanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container cc;
	gamecore game;
	private static javax.swing.Timer myTimer;
	JLabel level,score,lives, bg;
	mainmenu main;
	loseframe lose;
	/**
	 * Create the panel.
	 */
	public gamepanel(gamecore gc, Container c) {
		setSize(800,600);
		setLayout(null);
		game = gc;
		cc = c;
		game.setBounds(25, 50, 500, 500);
		add(game);
		
		level = new JLabel("Livello");
		level.setBounds(565, 81, 212, 48);
		add(level);
		
		score = new JLabel("Punteggio");
		score.setBounds(565, 181, 212, 48);
		add(score);
		
		lives = new JLabel("Vite");
		lives.setBounds(565, 280, 212, 48);
		add(lives);
		
		/*bg = new JLabel(new ImageIcon("bbg.png"));				//Setup backgroud
		bg.setSize(800,600);
		add(bg);*/
		
		myTimer = new javax.swing.Timer(10,this);				
		myTimer.start();
		
	}
	
	public void resetgamepanel(gamecore gc) { //sistemare
		setSize(800,600);
		setLayout(null);
		game = gc;
		game.setBounds(25, 50, 500, 500);
		add(game);				

		game.update(myTimer, main, this, lose);
		score.setText("Punteggio: "+Integer.toString(cc.getscore()));			//Updates lives, score, and level
		lives.setText("Vite: "+Integer.toString(cc.getlives()));
		level.setText("Livello: "+Integer.toString(cc.getlvl()));
		myTimer.start();
		
	}
	
public void actionPerformed(ActionEvent e){
		
		//Game Loop
		//Updates GamePanel and interface labels
		
		game.update(myTimer, main, this, lose);
		score.setText("Punteggio: "+Integer.toString(cc.getscore()));			//Updates lives, score, and level
		lives.setText("Vite: "+Integer.toString(cc.getlives()));
		level.setText("Livello: "+Integer.toString(cc.getlvl()));
		if (game.getLives() <= 0) setVisible(false);
	
	}




//set mainmenu
public void setmain(mainmenu m) {main = m;}


//set loseframe
public void setlose(loseframe l) {lose = l;}
}
