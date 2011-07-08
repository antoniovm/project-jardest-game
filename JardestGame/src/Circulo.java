
import java.awt.Dimension;
import java.awt.Rectangle;


public class Circulo extends Rectangle{
	private double radio;
	private Velocidad velocidad;
	//private int tiempoViejo;
	
	Circulo(){
		radio = 5;
	}
	
	Circulo(double radio, int i, int j){
		this.radio = radio;
		velocidad = new Velocidad(i,j);
	}

	public Circulo(double x, double y, double width, double height, double vx, double vy, double radio) {
		super((int)x,(int)y,(int)width,(int)height);
		this.radio = radio;
		velocidad = new Velocidad(vx, vy);
		//tiempoViejo = (int)System.nanoTime();
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public double getCentroX(){
		return x+radio;
	}
	
	public double getCentroY(){
		return y+radio;
	}
	
	public void mover(double dt){
		Punto dim = velocidad.mover(dt);
		this.x += dim.getX();
		this.y += dim.getY();
	}
	
	public void retroceder(){
		velocidad.cambiarSentido();
	}

	

}
