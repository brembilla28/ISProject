package classi;
import java.awt.event.*;
import javax.swing.*;


public class MainMenu extends JFrame implements ActionListener{
	

	public MyButton start;		//pulsanti per interagire con utente
	public MyButton help;
	public MyButton exit;
	MyButton[] buttons;				//Array di tutti i pulsanti
	
	JLabel bg;						//Background image					
	
	public MainMenu(){
		
		//Basic setup of screen
		//Positions and sizes are set for all buttons and images
		super("Brick Breaker");
		
		//setLayout(null);
		setSize(800,600);
		
		start = new MyButton("start");
		help = new MyButton("help");
		exit = new MyButton("exit");
		
		start.setSize(260,90);
		help.setSize(200,65);
		exit.setSize(150,65);
		
		buttons = new MyButton[]{start, help, exit};		//Buttons are put in an Array for easy access and manipulation
		
		for(int i=0; i<buttons.length; i++){
			
			MyButton b = buttons[i];
			b.setLocation(400-b.getWidth()/2, 300+i*75);
			b.addActionListener(this);
			add(b);
			
		}
		
		bg = new JLabel(new ImageIcon("bbg1.png"));
		bg.setSize(800,600);
		add(bg);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Program will exit on close
		setVisible(true);									//Makes it visible

	}
	
	public void actionPerformed(ActionEvent e){
		
		
		Object src = e.getSource();			
		
		
		if(src == start){					//inizia gioco
			new BB();
			setVisible(false);				
			
		} else if(src == help){				//carica informazioni utili
			new HelpFrame();
			setVisible(false);				
			
		} else if(src == exit){				//esce gioco
			System.exit(0);
		}
			
	
		
	}
	
	public static void main(String[] args){
		new MainMenu();
	}
}
