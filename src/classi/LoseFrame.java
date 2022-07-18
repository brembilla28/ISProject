package classi;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class loseframe extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel bg;
	MyButton exit;
	mainmenu main;
	List<classifica> cl;
	int score;
	String[] names;
	boolean scrittura;
	DefaultListModel<String> modelclassifica;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public loseframe(mainmenu m, Container c) {
		setSize(800,600);
		main = m;
		cl = new ArrayList<classifica>();
		readfile();
		
		
		exit = new MyButton("exit");
		exit.setBounds(325, 465, 150, 65);
		setLayout(null);
		add(exit);
		
		JLabel gameover = new JLabel("Game Over");
		gameover.setForeground(Color.BLACK);
		gameover.setBounds(200, 10, 400, 165);
		gameover.setFont(new Font("Times New Roman", Font.BOLD, 80));
		add(gameover);
		
		modelclassifica = new DefaultListModel<String>();
		refreshlist();
		
		JList Listclass = new JList(modelclassifica); 
		JScrollPane jcp = new JScrollPane(Listclass);
		jcp.setBounds(312, 200, 176, 100);
		add(jcp);
		
		textField = new JTextField();
		textField.setBounds(312, 305, 176, 20);
		add(textField);
		textField.setColumns(10);

		
		JButton ok = new JButton("Conferma");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty() && c.getscore() > 0 && !scrittura) {
				writefile(c.getscore(), textField.getText());
				scrittura = true;
				//refreshlist();
				//jcp.revalidate();
				//jcp.repaint();
				refreshlist();

				}
			}
		});
		ok.setBounds(489, 305, 100, 20);
		add(ok);
		
		JLabel classifica = new JLabel("Classifica", SwingConstants.CENTER);
		classifica.setForeground(Color.BLACK);
		classifica.setBounds(312, 175, 176, 20);
		classifica.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(classifica);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				scrittura = false;
				c.setcore();
				main.setVisible(true);
				textField.setText(null);
			}
		});
		bg = new JLabel(new ImageIcon("bbg.png"));
		bg.setSize(800,600);
		add(bg);
	}
	
	public void refreshlist() {
		names = new String[cl.size()];
		for (int i = 0; i < cl.size(); i++) {
			if(cl.get(i).score() < 1000 && cl.get(i).score() > 100) {
				names[i] = cl.get(i).score() + "  " + cl.get(i).name();
			} 
			else if(cl.get(i).score() < 100) {
				names[i] = cl.get(i).score() + "   " + cl.get(i).name();
			}
			else if (cl.get(i).score() < 10) {
				names[i] = cl.get(i).score() + "    " + cl.get(i).name();
			} else names[i] = cl.get(i).score() + " " + cl.get(i).name();
			
			modelclassifica.addElement(names[i]);
		}
		
	}
	public void createfile() {
		File file = new File("fileclassifica.txt");
		try {
		if (file.createNewFile()) {
			//System.out.println("file creato. Nome file: " + file.getName());	
		} else {
			//System.out.println("file esistente");
		}}catch(IOException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
	}

	public void writefile(int score, String name) {
		boolean updated = false;
		for(classifica c : cl) {
			if (c.name().equals(name) && c.score() <= score) {
				c.setscore(score);
				updated = true;
				break;
			} else if (c.name().equals(name) && score < c.score) {
				updated = true;
				break;
			}
		}
		if (!updated) {
			cl.add(new classifica(score, name));	
			updated = true;
		}
		if (updated) {
		Collections.sort(cl);
		try {
			 FileWriter myWriter = new FileWriter("fileclassifica.txt");
			 for(classifica cc : cl) {
		     myWriter.write(cc.name() + " " + cc.score() + "\n");}
		      myWriter.close();
		} catch (IOException e) {
			System.out.println("errore");
			e.printStackTrace();
		}}
	}

	public void readfile() {
		 try {
		      File fil = new File("fileclassifica.txt");
		      Scanner reader = new Scanner(fil);
		      while (reader.hasNextLine()) { 
		        String data = reader.nextLine();
		        String[] name = data.split(" ");
		        cl.add(new classifica(Integer.parseInt(name[1]), name[0])); 
		      }
		      reader.close();
		    } catch (FileNotFoundException e) {
		    	createfile();
		    }

	}
}
