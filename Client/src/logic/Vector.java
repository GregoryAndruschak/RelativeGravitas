package logic;

public class Vector {

	public double dx;
	public double dy;
	public boolean right = true;

	public Vector(int x, int y, int x1, int y1, double v) {
		if(x1<x)
			right=false;
		double width = x1 - x;
		double height = y1 - y;
		double diag = Math.sqrt((width * width) + (height * height));
		double sin = height / diag;
		double cos = width / diag;
		dx = cos * v;
		dy = sin * v;
	}
	
	public double getDx() {
		return dx;
	}
	
	public double getDy() {
		return dy;
	}
	
	public double getTg() {
		return dy/dx;
	}
	
}