package logic;

public class Bullet {

	int id;
	public Vector v;
	public int w = 10;
	public int h = 10;
	public int x = 0;
	public int y = 0;
	
	public Bullet(int id, Vector v) {
		this.id = id;
		this.v=v;
		this.x = v.x;
		this.y = v.y;
	}
}