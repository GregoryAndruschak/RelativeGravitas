package logic;

import org.newdawn.slick.*;

public class Player {
	public int x = 0;
	public int y = 0;

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
	public String weapon = "None";
	public int weap = 0;
	
	private int[] lkm_cd = new int[4];
	private int[] pkm_cd = new int[4];

	public Player(int x, int y, int color) throws SlickException {
		for(int i=0;i<4;i++) {
			lkm_cd[i]=0;
			pkm_cd[i]=0;
		}
		
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
			if(lkm_cd[weap]==0)
				return true;
		}
		else {
			if(pkm_cd[weap]==0)
				return true;
		}
		return false;
	}
	
	public Bullet fireWeapon(Vector v, boolean lkm) {
		Bullet b = new Bullet(weap,v);
		return b;
	}
	
	public void weaponCycle() {
		if(lkm_cd[weap]!=0)
			lkm_cd[weap]--;
		if(pkm_cd[weap]!=0)
			pkm_cd[weap]--;
	}

	public void weaponPicked(int id) {
		weap = id;
		if (id == 0) {
			this.weapon = "Wave Emitter";
		}
		if (id == 1) {
			this.weapon = "Grav-pistol";
		}
		if (id == 2) {
			this.weapon = "Temporal Rifle";
		}
		if (id == 3) {
			this.weapon = "Magnetic Pulsator";
		}
		if (id == 4) {
			this.weapon = "Transdimensional Railgun";
		}
	}
}