package classi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class LoseFrame extends JFrame implements ActionListener{
	
	//pannello che appare quando si perde
	
	JLabel msg, bg;				
	MyButton exit;				
	
	public LoseFrame(){
		
		
		
		super();
		
		setLayout(null);
		setSize(800,600);
	
		Font f = new Font("Bebas Neue", Font.PLAIN, 60);			
		
		msg = new JLabel("GAME OVER");					
		msg.setFont(f);												
		msg.setForeground(Color.WHITE);
        msg.setSize(600,100);
        msg.setLocation(250,200);
        add(msg);
		exit.setSize(200,65);
		exit.setLocation(300, 450);
		exit.addActionListener(this);								
		add(exit);
		
		bg = new JLabel(new ImageIcon("bbg.png"));					
		bg.setSize(800,600);
		add(bg);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		
		
		Object src = e.getSource();				
		
		if(src == exit){						
			new MainMenu();
			setVisible(false);
		}
	}
	
}