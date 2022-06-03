package classi;

import java.awt.event.*;




public class Paddle{
	
	
	private int x, y, width; 		

	
	public Paddle(int x, int y){
		
		
		this.x = x;
		this.y = y;
		width = 60;
	}
	
	public void move(boolean[] keys){
		
		
		if(keys[KeyEvent.VK_LEFT]){
 			if(this.getX() > 0) {
                this.setX(this.getX() - 5);
 			}
        }
        if(keys[KeyEvent.VK_RIGHT]){
        	if(this.getX() + 60 < 500) {
            	this.setX(this.getX() + 5);
            }
        }

	}	

	
	public int getWidth(){
		return width;
	}
	
	
	public int getX(){
		return x;
	}
	
	
	public int getY(){
		return y;
	}
	
	
	public void setWidth(int i){
		width = i;
	}
	
	
	public void setX(int i){
		x = i;
	}
	
	public void setY(int i){
		y = i;
	}
	
	
}