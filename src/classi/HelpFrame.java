package classi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class helpframe extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyButton exit;
	JLabel bg;
	mainmenu main;
	private JLabel lives;
	private JTextField textField;
	private JButton conferma;
	public helpframe(Container c) {
		setSize(800,600);
		setLayout(null);
		
		exit = new MyButton("exit");
		exit.setBounds(325, 465, 150, 65);
		add(exit);
		
		
		/*bg = new JLabel(new ImageIcon("info.png"));
		bg.setSize(800,600);
		add(bg);*/
		
		JLabel info = new JLabel("Informazioni di gioco", SwingConstants.CENTER);
		info.setForeground(Color.BLACK);
		info.setFont(new Font("Times New Roman", Font.BOLD, 80));
		info.setBounds(0, 0, 800, 147);
		add(info);
		
		lives = new JLabel("Modifica vite (base 3): ", SwingConstants.RIGHT);
		lives.setForeground(Color.BLACK);
		
		lives.setBounds(20, 200, 185, 20);
		add(lives);
		
		textField = new JTextField();
		textField.setBounds(312, 200, 176, 20);
		add(textField);
		textField.setColumns(10);
		
		conferma = new JButton("Conferma");
		conferma.setBounds(489, 200, 100, 20);
		add(conferma);
		
		bg = new JLabel(new ImageIcon("bbg.png"));
		bg.setSize(800,600);
		add(bg);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				main.setVisible(true);
				
			}
		});
		conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()) {
					c.setlives(Integer.parseInt(textField.getText()));
				}
				
			}
		});
	}
	public void setmain(mainmenu mm) {main = mm;}
}
