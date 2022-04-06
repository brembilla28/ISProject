package classi;
import java.awt.event.KeyEvent;


public class Paddle{
	
	
	private int x, y, width; 		
	private String pUp;				

	
	public Paddle(int x, int y){
		
		
		this.x = x;
		this.y = y;
		width = 60;
		pUp = "";
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
	
	public void powerUse(int lives, Ball b){
		
		
		if (pUp.equals("expand")){	
			if (width < 150) {
        	width += 10;
			}
        }
        
        else if (pUp.equals("shrink")){			
        	if (width > 60) {
            	width -= 20;
    			}
        	else width = 40;
        } 
        	
        else if(pUp.equals("life")){			
        	lives += 1;
        } 
        
        else if(pUp.equals("fast")){			
        	
        	b.setDY(b.getDY() * 1.5 );
        	b.setDX(b.getDX() * 1.5 );
        }
        
        else if (pUp.equals("slow")){			
        	
        	b.setDY(b.getDY() * 0.5 );
        	b.setDX(b.getDX() * 0.5 );
        }
    
        
        else{									
        	width = 60;
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
	
	public void setpUp(String s){
		pUp = s;
	}
	
}
