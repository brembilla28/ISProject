package classi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Brick {
	
    int x,y, hp;
    static Image[] brickIcons;		

    
    public Brick(int x, int y, int hp){
		
        this.x = x;
        this.y = y;
        this.hp = hp;
        
        brickIcons = new Image[4];
        
        for(int i=0; i<3; i++){
        	brickIcons[i] = new ImageIcon("brick"+Integer.toString(i+1)+".png").getImage();		
        }
    }
	
	//ottenimento immagine mattoncino in base a hp
	public Image getImg(){
		return brickIcons[hp-1];
	}
	
    //ottenimento hp
    public int getHP() {
        return hp;
    }
    
 
    //ottenimento coordinata x
    public int getX() {
        return x;
    }

    //ottenimento coordinata y
    public int getY() {
        return y;
    }
    
    //impostazione hp
    public void setHP(int i) {
        hp = i;
    }
    

}