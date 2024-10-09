import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
Font subtitleFont;
Timer frameDraw;
Rocketship rocketship = new Rocketship(250,700,50,50,10);
	
	GamePanel(){
		 titleFont = new Font("Marker Felt", Font.PLAIN, 50);
		 subtitleFont = new Font("Arial", Font.PLAIN, 20);
		    frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
	}
	
	 
	
	void updateMenuState() {  }
	void updateGameState() {  }
	void updateEndState()  {  }
	
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 100, 300);
		g.drawString("Press SPACE for instructions", 100, 500);
	}
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocketship.draw(g);
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("You killed enemies", 100, 300);
		g.drawString("Press ENTER to restart", 100, 500);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		   rocketship.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    rocketship.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		  rocketship.left();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		   rocketship.right();
		}
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
