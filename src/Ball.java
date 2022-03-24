import java.awt.*;
import javax.swing.*;

public class Ball{
	
	private double x, y, dx, dy; 
	
	public Ball(double x, double y){
		
		this.x = x;
		this.y = y;
		
	}
	
	public void move(){
		
		this.setX(this.getX() + this.getDX());
        this.setY(this.getY() + this.getDY());
	}
	
	public Image getImage(){
		
		return new ImageIcon("ball.png").getImage();
	}

    public double getDX() {
        return dx;
    }

    public double getDY() {
        return dy;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void setDX(double dx) {
        this.dx = dx;
    }
    
    public void setDY(double dy) {
        this.dy = dy;
    }
    
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}