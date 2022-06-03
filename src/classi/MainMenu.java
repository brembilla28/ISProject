package classi;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class mainmenu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyButton start,help,exit;
	JLabel bg;
	helpframe helping;
	gamepanel gaming;
	public mainmenu() {
		setSize(800,600);
		setLayout(null);
		
		exit = new MyButton("exit");
		exit.setBounds(325, 465, 150, 65);
		add(exit);
		
		help = new MyButton("help");
		help.setBounds(300, 365, 200, 65);
		add(help);
		
		start = new MyButton("start");
		start.setBounds(265, 265, 260, 90);
		add(start);
		
		bg = new JLabel(new ImageIcon("bbg1.png"));
		bg.setSize(800,600);
		add(bg);
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				helping.setVisible(true);
			}
		});
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gaming.setVisible(true);
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

public void sethelp(helpframe h) {helping = h;}
public void setgame(gamepanel g) {gaming = g;}
}
