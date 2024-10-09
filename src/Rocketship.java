import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		
	}

	public void right() {
        if (x<450) {
		x+=speed;
        }
        }
	public void left() {
        if (x>0) {
		x-=speed;
    }
	}
	public void up() {
        if (y>0) {
		y-=speed;
        }
        }
	public void down() {
        if (y<750) {
		y+=speed;
    }
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
}
