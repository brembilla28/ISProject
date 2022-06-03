package classi;


public class Brick {
	
    int x,y, hp;

    
    public Brick(int x, int y, int hp){
		
        this.x = x;
        this.y = y;
        this.hp = hp;
        
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