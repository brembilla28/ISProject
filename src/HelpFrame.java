import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class HelpFrame extends JFrame implements ActionListener{
	
	
	JLabel info;				
	MyButton exit;				
	
	public HelpFrame(){
		
	
		
		super();
		
		setLayout(null);
		setSize(800,600);
	
		exit = new MyButton("exit");
		exit.setSize(150,65);
		exit.setLocation(500, 400);
		exit.addActionListener(this);			
		add(exit);
		
		info = new JLabel(new ImageIcon("info.png"));
		info.setSize(800,600);
		add(info);
		
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