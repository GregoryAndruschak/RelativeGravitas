package logic;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Bullet {

	int id;

	public Vector v;

	public double x = 0;
	public double y = 0;

	Image ss;
	Image img;

	Image black = new Image("res/black.png");

	public Rectangle hitbox;

	public int decay = 0;

	public Bullet(int id, Vector v, int x, int y) throws SlickException { // id: 0 - rocket, 1 - pistol bullet, 2 -
																			// rifle bullet
		ss = new Image("res/bullets.png"); // 3 - wave, 4 - purple blob, 5 - LEIZOR
		this.id = id;

		this.x = x;
		this.y = y;
		this.v = v;

		int width = 0;
		int height = 0;
		
		if (id == 0) {
			img = ss.getSubImage(0, 0, 13, 10);
			width = 26;
			height = 20;
			decay = 1000;
			v.setV(10);
			
		}
		if (id == 1) {
			img = ss.getSubImage(14, 0, 20, 10);
			width = 26;
			height = 20;
			decay = 60;
			v.setV(7);
		}
		if (id == 2) {
			img = ss.getSubImage(35, 0, 15, 9);
			width = 30;
			height = 18;
			decay = 20;
			v.setV(9);
		}
		if (id == 3) {
			img = ss.getSubImage(60, 0, 8, 25);
			width = 64;
			height = 200;
			decay = 20;
			v.setV(8);
		}
		if (id == 4) {
			img = ss.getSubImage(69, 0, 17, 17);
			width = 34;
			height = 34;
			decay = 300;
			v.setV(3);
		}
		if (id == 5) {
			img = ss.getSubImage(0, 12, 59, 13);
			width = 650;
			height = 40;
			decay = 25;
			v.setV(0);
			img.setCenterOfRotation(0, 0);
		}
		
		float degree = (float) Math.toDegrees(Math.atan(v.getTg()));
		if(!v.right)
			img = img.getFlippedCopy(true, false);
		img.setRotation(degree);

		this.hitbox = new Rectangle((int) x, (int) y, width, height);
	}

	public boolean cycle() {
		if (decay == 0)
			return false;
		decay--;
		x += v.dx;
		y += v.dy;
		this.hitbox.setX((float) x);
		this.hitbox.setY((float) y);
		return true;
	}

	public void draw(int shift_x, int shift_y) {
		img.draw((float) (x - shift_x), (float) (y - shift_y), this.hitbox.getWidth(), this.hitbox.getHeight());
	}
}