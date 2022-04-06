package classi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	
	//pannello di gioco
	
	Brick[] bricks;					
	Paddle paddle;					
	public Ball ball;						

	
	boolean[] keys;					
	boolean started;				
	
	private int level, lives, score, left;		
	
	public GamePanel(){
		
		super();
		level = 0;
		ball = new Ball(245, 460);
		paddle = new Paddle(220, 475);
		bricks = load(level);					

		
		keys = new boolean[2000];
		
		started = false;					
		
		lives = 3;							
		score = 0;
		left = bricks.length;				
		
		addKeyListener(this);				
        this.setFocusable(true);
        this.grabFocus();
			
	}
	
	public Brick[] load(int lvl){		
		
		
		Scanner inFile=null;			
		
		try{		
    			inFile = new Scanner (new BufferedReader (new FileReader("bricks"+Integer.toString(lvl)+".txt")));
    			
		} catch(IOException ex){
			
			System.exit(0);
			
		}
		
		Brick[] temp = new Brick[16];												
		
		for(int i = 0; i < temp.length; i++){										
            Brick b;
            int hp = (int)(Math.random()*3);										
            
          
	        b = new Brick(inFile.nextInt(), inFile.nextInt(), hp+1);			
	        temp[i] = b;
        }
        
        return temp;																
	}
	
	public void checkContact(){
		
			
        //controllo bordi destro e sinistro
        if(ball.getX() + 10 >= 500 || ball.getX() <= 0){
            ball.setDX(-1 * ball.getDX());
        }
        
        //controllo bordo alto
        if(ball.getY() < 0){
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
        	
            if(ball.getX() + 10 >= b.getX() && ball.getX() <= b.getX() + 55){
            	
                if(ball.getY() + 10 >= b.getY() && ball.getY() <= b.getY() + 20){
                	
                    if(b.getHP()>0){
                    	
                        if(ball.getX() + 10 - ball.getDX() <= b.getX() || ball.getX() - ball.getDX() >= b.getX() + 55){
   
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
			bricks = load(level);
            reset();		
        }
        

        if(lives <= 0){
        	
        	
        	setVisible(false);
        	new LoseFrame();
        	
        }
	
    }
    
    public void reset(){
		

		
    	ball.setX(245);
        ball.setY(460);
        ball.setDX(0);
        ball.setDY(0);
        
        paddle.setX(220);
        paddle.setY(475);
        
      	
      	if(lives>0){				
      		
      	
      		score += 10;
      		
      	}
      	
        started = false;			
    }
    
	public void keyPressed(KeyEvent event){			
	
    	int i = event.getKeyCode();
    	keys[i] = true;
    }
	
	public void keyReleased(KeyEvent evt){
		
		int i = evt.getKeyCode();
		keys[i]=false;
		
	}
	
	public void keyTyped(KeyEvent evt){} //non usata
	
	public void paintComponent(Graphics g){
        
        
        g.setColor(new Color(222,222,222));					
		g.fillRect(0,0,getWidth(),getHeight());

        for(Brick b: bricks){
            if(b.getHP()>0){
            
                g.drawImage(b.getImg(), b.getX(), b.getY(), this);
            }
        }
		
        
        

        g.setColor(Color.BLACK);
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), 10);


        g.drawImage(ball.getImage(),(int)(ball.getX()), (int)(ball.getY()), this);
    }
    
    public void update(javax.swing.Timer mT){
    	

    	if(keys[KeyEvent.VK_H]){		
    		
    		mT.stop();				
    		new HelpFrame();
    		setVisible(false);
    			
    	}
    	
    	if(keys[KeyEvent.VK_M]){		
    		
    		mT.stop();				
    		new MainMenu();
    		setVisible(false);
    		
    	}
    	
    	if(!started){						
    		
    		if(keys[KeyEvent.VK_SPACE]){	
    			
    			ball.setDX(3);
    			ball.setDY(-5);
    			started = true;						
    			mT.start();
    		}
    		
    	} else{
    		
    		checkContact();						
    		paddle.move(keys);					
    		ball.move();						
    		
    		
        	repaint();								
    		
    	}
    }
    
    public int getLVL(){
    	
    	return level;
    }
    
    public int getLives(){
    	
    	return lives;
    }
    
    public int getScore(){
    	
    	return score;
    }}
