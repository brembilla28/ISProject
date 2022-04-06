package classi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.io.*;




public class BB extends JFrame implements ActionListener{
	
	//Main
	
	private GamePanel game;						//pannello di gioco
	private javax.swing.Timer myTimer;			//timer di gioco
	
	JLabel bg, score, lives, level;				//etichetta per punteggio,livello e vite
	
	public BB(){
			
		super("Brick Breaker");
		
		setLayout(null);
		setSize(800,600);
		
		game = new GamePanel();					//istanzia unG amePanel aka inizia il gioco
		game.setSize(500, 500);
		game.setLocation(25,25);
		add(game);
		
		Font f = new Font("Bebas Neue", Font.PLAIN, 30);		
		
		level = new JLabel("Livello 1");			//setup etichette varie
		level.setFont(f);
		level.setForeground(Color.WHITE);
        level.setSize(250,50);
        level.setLocation(585,150);
        add(level);
        
		score = new JLabel("Punteggio: 0");
		score.setFont(f);
		score.setForeground(Color.WHITE);
        score.setSize(300,100);
        score.setLocation(575,150);
        add(score);
        
        lives = new JLabel("Vite: 3");
		lives.setFont(f);
		lives.setForeground(Color.WHITE);
        lives.setSize(300,100);
        lives.setLocation(580,250);
        add(lives);
        
        
        
		bg = new JLabel(new ImageIcon("bbg.png"));				//Setup backgroud
		bg.setSize(800,600);
		add(bg);
		
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		setVisible(true);										
		
		myTimer = new javax.swing.Timer(10,this);				
		myTimer.start();
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		//Game Loop
		//Updates GamePanel and interface labels
		
		game.update(myTimer);
		score.setText("Punteggio: "+Integer.toString(game.getScore()));			//Updates lives, score, and level
		lives.setText("Vite: "+Integer.toString(game.getLives()));
		level.setText("Livello: "+Integer.toString(game.getLVL()));
		if (game.getLives() <= 0) setVisible(false);
		
	}

}
