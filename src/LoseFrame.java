import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LoseFrame extends JFrame implements ActionListener{
	
	
	JLabel msg, bg;				
	MyButton exit;	
	
	public LoseFrame(){
		
		
		
		super();
		
		setLayout(null);
		setSize(800,600);
	
		Font f = new Font("Bebas Neue", Font.PLAIN, 60);			
		
		msg = new JLabel("Game lost.");					
		msg.setFont(f);												
		msg.setForeground(Color.WHITE);
        msg.setSize(600,100);
        msg.setLocation(225,250);
        add(msg);
		
		exit = new MyButton("exit");
		exit.setSize(120,65);
		exit.setLocation(340, 450);
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
			new test();
			setVisible(false);
		}
	}
	
}