package logic;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Map {

	ArrayList<Rectangle> borders = new ArrayList<Rectangle>();
	ArrayList<Rectangle> platforms = new ArrayList<Rectangle>();

	public ArrayList<Rectangle> hitboxes = new ArrayList<Rectangle>();
	ArrayList<Image> objects = new ArrayList<Image>();

	int world_width = 3000;
	int world_heigth = 2000;

	Image black = new Image("res/black.png");
	Image platform = new Image("res/platform.png");

	ArrayList<Item> items = new ArrayList<Item>();

	public Map() throws SlickException {
		borders.add(new Rectangle(-world_width, world_heigth, world_width * 3, 20));

		platforms.add(new Rectangle(650, 0, 700, 40));
		platforms.add(new Rectangle(850, 1000, 300, 40));
		platforms.add(new Rectangle(0, 200, 400, 40));
		platforms.add(new Rectangle(1600, 200, 400, 40));
		platforms.add(new Rectangle(200, 1300, 300, 40));
		platforms.add(new Rectangle(1500, 1300, 300, 40));
		platforms.add(new Rectangle(200, 700, 300, 40));
		platforms.add(new Rectangle(1500, 700, 300, 40));

		items.add(new Item(450, 1050, 3));

		hitboxes.addAll(borders);
		hitboxes.addAll(platforms);
	}

	public void draw(int shift_x, int shift_y) {
		for (int i = 0; i < hitboxes.size(); i++) {
			float x = hitboxes.get(i).getX();
			float y = hitboxes.get(i).getY();
			float w = hitboxes.get(i).getWidth();
			float h = hitboxes.get(i).getHeight();
			if (i != 0)
				platform.draw(x - shift_x, y - shift_y, w, h);
			else
				black.draw(x - shift_x, y - shift_y, w, h);
		}

		for (int i = 0; i < items.size(); i++) {
			items.get(i).draw(shift_x, shift_y);
		}
	}

	public ArrayList<Item> getItems() {
		return items;

	}
}