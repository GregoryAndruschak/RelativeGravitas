package logic;

public class Vector {

	public double dx;
	public double dy;
	public boolean right = true;
	private double sin = 0;
	private double cos = 0;

	public Vector(int x, int y, int x1, int y1, double v) {
		if(x1<x)
			right=false;
		double width = x1 - x;
		double height = y1 - y;
		double diag = Math.sqrt((width * width) + (height * height));
		sin = height / diag;
		cos = width / diag;
		dx = cos * v;
		dy = sin * v;
	}
	
	public double getDx() {
		return dx;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void addDx(double ddx) {
		dx+=ddx;
	}
	
	public void addDy(double ddy) {
		dy+=ddy;
	}
	
	public void setDx(double ddx) {
		dx=ddx;
	}
	
	public void setDy(double ddy) {
		dy=ddy;
	}
	
	public double getTg() {
		return dy/dx;
	}
	
	public void setV(double v) {
		dx = cos * v;
		dy = sin * v;
	}
}