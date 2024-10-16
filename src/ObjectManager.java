import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocket;
	ArrayList <Projectile> projectiles = new ArrayList<>();
	ArrayList <Alien> aliens = new ArrayList<>();
	Random ran = new Random();
	
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
	
	void addProjectile(Projectile p) {
	projectiles.add(p);
	}
	
	void addAlien() {
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH),0,50,50,10));
	}

	void update(){
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
		for(Alien a: aliens) {
		
			if (a.isActive = false) {
				aliens.remove(a);
			}
		}
		for(Projectile p: projectiles) {
			
			if (p.isActive = false) {
				projectiles.remove(p);
			}
		}
	}
	
	
}
