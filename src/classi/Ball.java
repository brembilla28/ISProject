package classi;

import java.awt.*;
import javax.swing.*;

public class Ball{
	
	//Informazioni pallina
	
	private double x, y, dx, dy; //posizione e velocità
	
	public Ball(double x, double y){
		
		//posiziona pallina
		
		this.x = x;
		this.y = y;
		
	}
	
	public void move(){
		
		//movimento pallina
		
		this.setX(this.getX() + this.getDX());
        this.setY(this.getY() + this.getDY());
	}
	

    //ottenere velocità x
    public double getDX() {
        return dx;
    }

    //ottenere velocità y
    public double getDY() {
        return dy;
    }

    //ottenere coordinata x
    public double getX() {
        return x;
    }

  //ottenere coordinata y
    public double getY() {
        return y;
    }
    
    //impostazione velocità x
    public void setDX(double dx) {
        this.dx = dx;
    }
    
    //impostazione velocità x
    public void setDY(double dy) {
        this.dy = dy;
    }
    
    //impostazione coordinata x
    public void setX(double x) {
        this.x = x;
    }

    //impostazione coordinata x
    public void setY(double y) {
        this.y = y;
    }

}