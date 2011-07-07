import java.awt.Dimension;


public class Velocidad {
	
	private double i,j;
	
	
	public Velocidad() {
		// TODO Auto-generated constructor stub
	}
	public Velocidad(double i, double j) {
		this.i=i;
		this.j=j;
	}
	
	Dimension mover(int dt){
		return new Dimension((int)(i*dt),(int)(j*dt));
	}
	
	void setComponentes(double i, double j) {
		this.i=i;
		this.j=j;
	}
	public double getI() {
		return i;
	}
	public void setI(double i) {
		this.i = i;
	}
	public double getJ() {
		return j;
	}
	public void setJ(double j) {
		this.j = j;
	}
	
	public void cambiarSentido(){
		i=-i;
		j=-j;
	}

}
