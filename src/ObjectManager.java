import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener {

	Rocketship rocket;
	ArrayList <Projectile> projectiles = new ArrayList<>();
	ArrayList <Alien> aliens = new ArrayList<>();
	Random ran = new Random();
	private int score = 0;
	
	
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
	
	void addProjectile(Projectile p) {
	projectiles.add(p);
	}
	
	void addAlien() {
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH),0,50,50,1));
	}
	void checkCollision() {
		for(Alien a: aliens) {
			a.update();
			for(Projectile p: projectiles) {
				p.update();
				if (p.collisionBox.intersects(a.collisionBox)) {
					p.isActive = false;
					a.isActive = false;
					score++;
			}
		}
			if (rocket.collisionBox.intersects(a.collisionBox)) {
					
					a.isActive = false;
					rocket.isActive = false;
				}
		}
		}
		
	void update(){
		rocket.update();
		for(Alien a: aliens) {
			a.update();
			if (a.y > LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}
		}
		for(Projectile p: projectiles) {
			p.update();
			if (p.y > LeagueInvaders.HEIGHT) {
				p.isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
	rocket.draw(g);
	for(Alien a: aliens) {
		a.draw(g);
		}
	
	for(Projectile p: projectiles) {
		p.draw(g);
	}
	}

	void purgeObjects() {
		Iterator<Alien> iter = aliens.iterator();
		while(iter.hasNext()) {
			Alien a = iter.next();
			if (!a.isActive) {
				iter.remove();
			}
		}
		
		Iterator<Projectile> itera = projectiles.iterator();
		while(itera.hasNext()) {
			Projectile p = itera.next();
			if (!p.isActive) {
				itera.remove();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		addAlien();
		
		
	}

	public int getScore() {
		return score;
	}
	
	
}
