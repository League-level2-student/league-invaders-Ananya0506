import java.awt.Rectangle;

public class GameObject {
	 int x;
	 int y;
	 int width;
	 int height;
	 boolean isActive = true;
	 int speed= 0;
	 Rectangle collisionBox;
	
	 void update(){
		 collisionBox.setBounds(x, y, width, height);
		  
	 }
	 
	 public GameObject(int x, int y, int width, int height, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.collisionBox = new Rectangle(x, y, width, height);
	 }







}
