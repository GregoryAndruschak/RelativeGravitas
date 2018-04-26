package logic;

import org.newdawn.slick.*;

public class Player {
	public int x = 0;
	public int y = 0;
	
	public Vector v;

	public int width = 76;
	public int height = 100;

	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean moving = false;
	public boolean standing = false;

	public Animation current = new Animation();

	private Animation stand_right = new Animation();
	private Animation stand_left = new Animation();
	private Animation go_right = new Animation();
	private Animation go_left = new Animation();
	private Animation jump_right = new Animation();
	private Animation jump_left = new Animation();
	private Animation float_right = new Animation();
	private Animation float_left = new Animation();
	private Animation fall_right = new Animation();
	private Animation fall_left = new Animation();

	public int health = 100;
	public String weapon = "Grav-pistol";
	public int weap = 3;
	
	private int lkm_cd = 0;
	private int pkm_cd = 0;

	public Player(int x, int y, int color) throws SlickException{
		this.v = new Vector(0,0,0,0,0);
		v.setDx(0);
		v.setDy(0);
		this.x = x;
		this.y = y;
		Image s = new Image("res/player.png");
		SpriteSheet ss = new SpriteSheet(s, 180, 234);

		stand_right.addFrame(ss.getSprite(0, color), 100);
		stand_right.addFrame(ss.getSprite(1, color), 100);
		stand_right.addFrame(ss.getSprite(2, color), 100);
		stand_right.addFrame(ss.getSprite(3, color), 100);

		jump_right.addFrame(ss.getSprite(4, color), 100);

		float_right.addFrame(ss.getSprite(5, color), 100);

		fall_right.addFrame(ss.getSprite(6, color), 100);

		go_right.addFrame(ss.getSprite(9, color), 100);
		go_right.addFrame(ss.getSprite(10, color), 100);
		go_right.addFrame(ss.getSprite(11, color), 100);
		go_right.addFrame(ss.getSprite(12, color), 100);
		go_right.addFrame(ss.getSprite(13, color), 100);
		go_right.addFrame(ss.getSprite(14, color), 100);
		go_right.addFrame(ss.getSprite(15, color), 100);
		go_right.addFrame(ss.getSprite(16, color), 100);

		stand_left.addFrame(ss.getSprite(0, color).getFlippedCopy(true, false), 100);
		stand_left.addFrame(ss.getSprite(1, color).getFlippedCopy(true, false), 100);
		stand_left.addFrame(ss.getSprite(2, color).getFlippedCopy(true, false), 100);
		stand_left.addFrame(ss.getSprite(3, color).getFlippedCopy(true, false), 100);

		jump_left.addFrame(ss.getSprite(4, color).getFlippedCopy(true, false), 100);

		float_left.addFrame(ss.getSprite(5, color).getFlippedCopy(true, false), 100);

		fall_left.addFrame(ss.getSprite(6, color).getFlippedCopy(true, false), 100);

		go_left.addFrame(ss.getSprite(9, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(10, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(11, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(12, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(13, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(14, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(15, color).getFlippedCopy(true, false), 100);
		go_left.addFrame(ss.getSprite(16, color).getFlippedCopy(true, false), 100);
	}

	public void setAnimation(int i) {
		if (i == 1) {
			current = stand_right;
		}
		if (i == 2) {
			current = go_right;
		}
		if (i == 3) {
			current = jump_right;
		}
		if (i == 4) {
			current = float_right;
		}
		if (i == 5) {
			current = fall_right;
		}
		if (i == 6) {
			current = stand_left;
		}
		if (i == 7) {
			current = go_left;
		}
		if (i == 8) {
			current = jump_left;
		}
		if (i == 9) {
			current = float_left;
		}
		if (i == 10) {
			current = fall_left;
		}
	}

	public boolean weaponReady(boolean mouse) {//true = lkm, false = pkm
		if(mouse) {
			if(lkm_cd==0)
				return true;
		}
		else {
			if(pkm_cd==0)
				return true;
		}
		return false;
	}
	
	public Bullet fireWeapon(Vector v, boolean lkm, int x, int y) throws SlickException {
		Bullet b = new Bullet(0,v,x,y);
		if(lkm) {
			if(weap==2) {
				b = new Bullet(3,v,x,y);
				lkm_cd = 50;
			}
			if(weap==3) {
				b = new Bullet(1,v,x,y);
				lkm_cd = 25;
			}
			if(weap==4) {
				b = new Bullet(2,v,x,y);
				lkm_cd = 20;
			}
			if(weap==5) {
				b = new Bullet(4,v,x,y);
				lkm_cd = 60;
			}
			if(weap==6) {
				b = new Bullet(5,v,x,y);
				lkm_cd = 120;
			}
		}
		else {
			if(weap==2) {}
			if(weap==3) {}
			if(weap==4) {
				b = new Bullet(0,v,x,y);
				pkm_cd = 25;
			}
			if(weap==5) {}
			if(weap==6) {}
		}
		return b;
	}
	
	public void weaponCycle() {
		if(lkm_cd!=0)
			lkm_cd--;
		if(pkm_cd!=0)
			pkm_cd--;
	}

	public void weaponPicked(int id) {
		weap = id;
		if (id == 2) {
			this.weapon = "Wave Emitter";
		}
		if (id == 3) {
			this.weapon = "Grav-pistol";
		}
		if (id == 4) {
			this.weapon = "Temporal Rifle";
		}
		if (id == 5) {
			this.weapon = "Magnetic Pulsator";
		}
		if (id == 6) {
			this.weapon = "Transdimensional Railgun";
		}
	}
	
	public void normalize() {
		if(v.dx>0) {
			if(v.dx<1)
				v.setDx(0);
			else
				v.addDx(-1);
		}
		else {
			if(v.dx>-1)
				v.setDx(0);
			else
				v.addDx(1);
		}
		
		if(v.dy>0) {
			if(v.dy<1)
				v.setDy(0);
			else
				v.addDy(-1);
		}
		else {
			if(v.dy>-1)
				v.setDy(0);
			else
				v.addDy(1);
		}
	}
}