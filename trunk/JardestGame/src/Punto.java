import java.awt.Point;


public class Punto extends Point{
	private double x, y;
	
	public Punto(double x, double y) {
		this.x=x;
		this.y=y;
	}

	public Punto() {
		// TODO Auto-generated constructor stub
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
