package logic;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Item {

	private Rectangle hitbox;
	private Image img;
	private boolean exists = true;
	private int x;
	private int y;
	
	private int width;
	private int heigth;

	private int respawn_counter = 0;
	
	public int id = -1;

	public Item(int x, int y, int id) throws SlickException { // id: 0 - boost
		this.id = id;
		this.x = x; //0 - wave emitter, 1 - grav-pistol, 2 - temporal rifle
		this.y = y; //3 - magnetic pulsator, 4 - transdimensional railgun
		this.width = 50;
		this.heigth = 50;
		Image s = new Image("res/items.png");
		SpriteSheet ss = new SpriteSheet(s, 50, 50);

		hitbox = new Rectangle(x, y, 50, 50);
		img = ss.getSprite(id, 0);
		
		if(id==0) {this.width = 75;}
		if(id==1) {this.width = 75;}
		if(id==2) {this.width = 75;}
		if(id==3) {this.width = 75;}
		if(id==4) {this.width = 75;}
		if(id==5) {this.width = 75;}
		if(id==6) {this.width = 75;}

	}

	public void draw(int shift_x, int shift_y) {
		if (exists)
			img.draw(x-shift_x,y-shift_y,width,heigth);
		else if (respawn_counter != 0)
			respawn_counter--;
		else {
			exists = true;
		}

	}

	public void pickUp() {
		exists = false;
		respawn_counter = 300;
	}

	public boolean exists() {
		return exists;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}
}