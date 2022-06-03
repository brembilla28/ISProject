package classi;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class gamecore extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Brick> bricks;
	Paddle paddle;
	Ball ball;
	
	int score, level, left, lives;
	boolean[] keys;
	boolean started;
	
public gamecore() {
	level = 0;
	load(level);
	ball = new Ball(245, 464);
	paddle = new Paddle(220, 475);
	keys = new boolean[2000];
	started = false;
	
	lives = 3;
	addKeyListener(this);				
    this.setFocusable(true);
    this.grabFocus();
}	

//modifica dati di gioco
public void modlives(int i) {
	lives = i;
}
public void modpaddle(int x) {
	paddle.setWidth(x);
}

//caricamento dati livello
public void load(int lvl){	
	
	int[] xpossibilities = {0,50,100,150,200,250,300,350,400,450};
	boolean[] usedx = new boolean[xpossibilities.length];
	int[] ypossibilities = {0,25,50,75,100,125,150,175,200,225};
	boolean[] usedy;
	List<Brick> bricksarray = new ArrayList<Brick>();
	
	for(int i = 0; i <= xpossibilities.length; i++) {
		int x = (int)(Math.random()*xpossibilities.length);
		if(!usedx[x]) {
			usedx[x] = true;
			usedy = new boolean[ypossibilities.length];
			for(int a = 0; a <= ypossibilities.length; a++) {
				int y = (int)(Math.random()*ypossibilities.length);
				if(!usedy[y]) {
					usedy[y] = true;
					int hp;
					if(lvl > 7)hp = (int)(Math.random()*8);
					else hp =  (int)(Math.random()*(lvl+1));
					if (hp > 7) hp = 7;
					Brick temp = new Brick(xpossibilities[x], ypossibilities[y], hp);
					bricksarray.add(temp);
		}
		}
	}
	}
	bricks = bricksarray;																
}

//verifica contatto movimento pallina
public void checkContact(gamepanel gp, mainmenu main, loseframe lose){
	
	
    //controllo bordi destro e sinistro
    if(ball.getX() + 10 >= 500 || ball.getX() <= 0){
        ball.setDX(-1 * ball.getDX());
    }
    
    //controllo bordo alto aggiunto = sotto
    if(ball.getY() <= 0){
        ball.setDY(-1 * ball.getDY());
    }
    
    //controllo contatto paddle
    if(ball.getY() + 10 >= paddle.getY() && (ball.getX() >= paddle.getX() && ball.getX() <= (paddle.getX() + paddle.getWidth()))){
        if(ball.getY() + 10 <= paddle.getY() + 10){
        	
        	double ballPos = ball.getX() - paddle.getX();			
			double newx = (ballPos/paddle.getWidth()) - .5;			//Changes balls angle/x velocity based on the position it touches paddle

			ball.setDX(newx*5);										//Sets the new x and y velocities
			ball.setDY(-1 * ball.getDY());
        }
    }

    //controllo bordo basso
    if(ball.getY() + 10 > paddle.getY() + 10){
			
			lives-=1;
			reset();					
        
    }

    for(Brick b: bricks){
    	
        if(ball.getX() + 10 >= b.getX() && ball.getX() <= b.getX() + 50){
        	
            if(ball.getY() + 10 >= b.getY() && ball.getY() <= b.getY() + 25){
            	
                if(b.getHP()>0){
                	
                    if(ball.getX() + 10 - ball.getDX() <= b.getX() || ball.getX() - ball.getDX() >= b.getX() + 50){

						ball.setDX(-1 * ball.getDX());
                        b.setHP(b.getHP()-1);
                        
                        
                    } else{
                    	
                 		ball.setDY(-1 * ball.getDY());
                    	b.setHP(b.getHP()-1);
                   
                    } 
                    score += (b.getHP()+1)*5;
                } 
            }
        }
      	
        
    }
    
	
	int temp = 0;
	
	for(Brick b: bricks){											//contatore mattoncini
		
		if(b.getHP()> 0){
			temp ++;
		}
	}
	
	left = temp;
	
    if(left == 0)
    {

        level++;
		load(level);
        reset();		
    }
    

    if(lives <= 0){
    	setVisible(false);
    	gp.setVisible(false);
    	lose.setVisible(true);
    	
    }
}

//rappresentazione elementi di gioco
public void paintComponent(Graphics g){
  
  
  g.setColor(new Color(222,222,222));					
	g.fillRect(0,0,getWidth(),getHeight());

  for(Brick b: bricks){
  	switch (b.getHP()) {
		case 1:
      	g.setColor(Color.yellow);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		case 2:
      	g.setColor(Color.orange);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		case 3:
      	g.setColor(Color.magenta);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		case 4:
      	g.setColor(Color.green);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		case 5:
      	g.setColor(Color.cyan);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		case 6:
      	g.setColor(Color.blue);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		case 7:
      	g.setColor(Color.black);					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;

		default:
      	g.setColor(new Color(222,222,222));					
  		g.fillRect(b.getX(),b.getY(),50,25);
			break;
		}
  }
	
  
  

  g.setColor(Color.BLACK);
  g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), 10);


  g.setColor(Color.darkGray);
  g.fillOval((int)(ball.getX()), (int)(ball.getY()), 10, 10);
}


//update game
public void update(javax.swing.Timer mT, mainmenu main, gamepanel gg, loseframe lose){
	
	
	if(!started){						
		
		if(keys[KeyEvent.VK_SPACE]){	
			
			ball.setDX(5);
			ball.setDY(-5);
			started = true;						
			mT.start();
		}
		
  	} else{
		
		checkContact(gg,main, lose);						
		paddle.move(keys);					
		ball.move();						
		
		
    	repaint();								
		
	}
}



public void keyTyped(KeyEvent evt){} //non usata

public void keyPressed(KeyEvent event){			
	
	int i = event.getKeyCode();
	keys[i] = true;
}

public void keyReleased(KeyEvent evt){
	
	int i = evt.getKeyCode();
	keys[i]=false;
	
}


//reset livello
public void reset(){
	

	
	ball.setX(245);
    ball.setY(464);
    ball.setDX(0);
    ball.setDY(0);
    
    paddle.setX(220);
    paddle.setY(475);
    
  	
  	if(lives>0){				
  		
  	
  		score += 10;
  		
  	}
  	
    started = false;			
}

//ritorna livello
public int getLVL(){
	
	return level;
}

//ritorna vite
public int getLives(){
	
	return lives;
}

//ritorna punteggio
public int getScore(){
	
	return score;
}

public void resetcore() {
	level = 0;
	load(level);
	ball = new Ball(245, 464);
	paddle = new Paddle(220, 475);
	keys = new boolean[2000];
	started = false;
	
	lives = 3;
	
}
}
