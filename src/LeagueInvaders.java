import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	JFrame frame;
	GamePanel panel; 
	LeagueInvaders(){
		this.frame = new JFrame();
	
		this.panel = new GamePanel();
	}
	
	void setup() {
		frame.add(panel);
		frame.setSize(new Dimension(WIDTH, HEIGHT));	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	
	}
	
	
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();	
	}
	
}
