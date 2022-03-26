import java.awt.*;
import javax.swing.*;

public class Brick {
	
    int x,y, hp;
    String powerup;
    static Image[] brickIcons;		

    
    public Brick(int x, int y, int hp, String powerup){
		
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.powerup = powerup;
        
        brickIcons = new Image[3];
        
        for(int i=0; i<3; i++){
        	brickIcons[i] = new ImageIcon("brick"+Integer.toString(i+1)+".png").getImage();		
        }
    }
	
	public Image getImg(){
		return brickIcons[hp-1];
	}
	
    public int getHP() {
        return hp;
    }
    
    public String getPU(){
    	return powerup;
    }
 
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setHP(int i) {
        hp = i;
    }
    
    public void setPU(String pu){
    	powerup = pu;
    }

}