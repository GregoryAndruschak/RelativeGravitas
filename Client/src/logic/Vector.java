package logic;

public class Vector {

	public int x;
	public int y;
	public int x1;
	public int y1;

	public Vector(int x, int y, int x1, int y1) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}

	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + ", x1=" + x1 + ", y1=" + y1 + "]";
	}
}
