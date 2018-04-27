package game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import logic.Bullet;
import logic.Item;
import logic.Map;
import logic.Player;
import logic.Vector;

public class Game extends BasicGameState {

	Player player;
	Image ph1;
	Image black;

	int center_x = 615;
	int center_y = 320;
	int shift_x = 0;
	int shift_y = 0;

	int j_vel = 0;
	boolean jumping = false;
	
	Rectangle dummy;

	int g = 5;
	int jtime = 0;

	int death_count = 0;

	SpriteSheet pss;

	Map map;

	ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	boolean picking_up = false;

	public Game(int state) {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Player(0, 0, 2);
		ph1 = new Image("res/white.png");
		black = new Image("res/black.png");
		map = new Map();
		gc.getGraphics().setColor(Color.black);
		dummy = new Rectangle(15,-100,75,100);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		ph1.draw(0, 0, 3000, 2000);
		g.drawString(player.x + " " + player.y, 0, 0);
		// g.drawString("left " + player.left + " right " + player.right + " moving " +
		// player.moving + " standing "
		// + player.standing + " jumping " + jumping, 0, 50);
		g.drawString("Deaths: " + death_count, 30, 100);
		player.current.draw(center_x, center_y, 75, 100);

		map.draw(shift_x, shift_y);

		g.drawString("Health: " + player.health + "/100", 400, 20);
		g.drawString("Weapon: " + player.weapon, 400, 50);

		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			if (!b.cycle()) {
				bullets.remove(i);
				break;
			}
			bullets.get(i).draw(shift_x, shift_y);
		}
		
		black.draw(dummy.getX(),dummy.getY(),dummy.getWidth(),dummy.getHeight());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		Input input = gc.getInput();

		player.moving = false;

		if (input.isKeyDown(Input.KEY_A)) {
			player.x -= 4;
			player.left = true;
			player.right = false;
			if (player.standing)
				player.moving = true;
		}

		if (input.isKeyDown(Input.KEY_D)) {
			player.x += 4;
			player.right = true;
			player.left = false;
			if (player.standing)
				player.moving = true;
		}

		if (input.isKeyDown(Input.KEY_SPACE) && jtime == 0) {
			jtime = 120;
			jumping = true;
		}

		if (jtime != 0) {
			j_vel = jtime / 7;
			player.y -= (int) j_vel;
			jtime--;
		}

		if (jtime == 0)
			jumping = false;

		if (jumping) {
			if (jtime > 80) {
				if (player.right)
					player.setAnimation(3);
				else
					player.setAnimation(8);
			} else if (jtime < 60) {
				if (player.right)
					player.setAnimation(5);
				else
					player.setAnimation(10);
			} else {
				if (player.right)
					player.setAnimation(4);
				else
					player.setAnimation(9);
			}
		} else if (player.moving) {
			if (player.right)
				player.setAnimation(2);
			else
				player.setAnimation(7);
		} else if (player.standing) {
			if (player.right)
				player.setAnimation(1);
			else
				player.setAnimation(6);
		} else {
			if (player.right)
				player.setAnimation(5);
			else
				player.setAnimation(10);
		}

		physics(g, player);
		player.standing = false;
		collisions(player, map.hitboxes);

		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && player.weaponReady(true)) {
			Vector v = new Vector(center_x + 38, center_y + 50, input.getMouseX(), input.getMouseY(), 10);
			Bullet b;
			if(v.right)
				b = player.fireWeapon(v, true, player.x + 101, player.y + 30);
			else
				b = player.fireWeapon(v, true, player.x - 40, player.y + 30);
			bullets.add(b);
		}

		if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON) && player.weaponReady(false)) {

		}

		if (input.isKeyPressed(Input.KEY_E)) {
			picking_up = true;
		}

		player.x += player.v.dx;
		player.y += player.v.dy;

		shift_x = player.x - center_x;
		shift_y = player.y - center_y;

		player.weaponCycle();
		player.normalize();
	}

	private void physics(int gravity, Player player) {
		player.y += gravity;
	}

	private void collisions(Player player, ArrayList<Rectangle> borders) {
		Rectangle hitbox = new Rectangle(player.x, player.y, player.width, player.height);
		for (int i = 0; i < borders.size(); i++) {
			Rectangle b = borders.get(i);

			boolean right = hitbox.getX() + 6 <= b.getX() + b.getWidth();
			boolean left = hitbox.getX() - 6 + hitbox.getWidth() >= b.getX();
			boolean up = hitbox.getY() - 6 + hitbox.getHeight() >= b.getY();
			boolean down = hitbox.getY() + (j_vel + 2) <= b.getY() + b.getHeight();

			if (hitbox.intersects(borders.get(i))) {
				if (i == 0) {
					death_count++;
					player.x = 0;
					player.y = 0;
					break;
				}

				if (up && !down) {
					player.y = (int) (b.getY() + b.getHeight());
					jtime = 49;
				}
				if (!up && down) {
					player.y = (int) (b.getY() - player.height);
					player.standing = true;
				}
				if (left && !right) {
					player.x = (int) (b.getX() + b.getWidth());
				}
				if (!left && right) {
					player.x = (int) (b.getX() - player.width);
				}
			}
		}
		ArrayList<Item> items = map.getItems();
		for (int i = 0; i < items.size(); i++) {
			if (hitbox.intersects(items.get(i).getHitbox()) && player.weap == 0) {
				items.get(i).pickUp();
				player.weaponPicked(items.get(i).id);
			} else if (picking_up) {
				items.get(i).pickUp();
				player.weaponPicked(items.get(i).id);
				picking_up = false;
			}
		}
		
		for(int i=0;i<bullets.size();i++) {
			Bullet b = bullets.get(i);
			if(hitbox.intersects(b.hitbox)) {
				b.decay = 1;
				player.v.dx+=b.v.dx;
				player.v.dy+=b.v.dy;
			}
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}