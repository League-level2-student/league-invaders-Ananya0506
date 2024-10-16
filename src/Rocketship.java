import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		if (needImage) {
		    loadImage ("rocket (1).png");
		}
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
		
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
	
}
