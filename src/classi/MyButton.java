package classi;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class MyButton extends JButton{
	
	//Custom JButton class

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyButton(String f){
		
		ImageIcon p = new ImageIcon(f+"P.png");			
		ImageIcon d = new ImageIcon(f+"D.png");			
		
		this.setIcon(d);								
		this.setRolloverIcon(p);
		this.setPressedIcon(d);
		this.setContentAreaFilled(false);			
		this.setBorderPainted(false);
		
	}
}