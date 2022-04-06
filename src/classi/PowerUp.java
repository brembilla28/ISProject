package classi;
import java.awt.*;
import javax.swing.*;

public class PowerUp{
	
	
	
	int x, y, dx, dy;					
										
	boolean act, use;					
										
	String name;						
	

	
	public PowerUp(int x, int y, String n){
		
		
		this.x=x;
		this.y=y;
		dx=0;
		dy=0;
		act=false;
		name = n;
	}
	
	public void move(){		
		
		
		if (!use && act){			
    		if (y<500){
    			y += dy;
    		}	        		
    	}
	}
	
	public Image getImage(){
		return new ImageIcon("powerup.png").getImage();
	}
	public String getName(){
		return name;
	}
	
	public boolean getUse(){
		return use;
	}
	
	public boolean getAct(){
		return act;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getDY(){
		return dy;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public void setUse(boolean b){
		use = b;
	}
	
	public void setAct(boolean b){
		act = b;
	}
	
	public void setX(int i){
		x = i;
	}
	
	public void setY(int i){
		y = i;
	}
	
	public void setDY(int i){
		dy = i;
	}
	
	
}