package classi;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class MyButton extends JButton{
	ImageIcon p;
	ImageIcon d;
	//Custom JButton class

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyButton(String f){
		
		p = new ImageIcon(f+"P.png");			
		d = new ImageIcon(f+"D.png");			
		
		this.setIcon(d);								
		this.setRolloverIcon(p);
		this.setPressedIcon(d);
		this.setContentAreaFilled(false);			
		this.setBorderPainted(false);
		
	}
}