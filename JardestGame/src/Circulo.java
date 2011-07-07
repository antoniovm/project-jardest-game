
import java.awt.Dimension;
import java.awt.Rectangle;


public class Circulo extends Rectangle{
	private int radio;
	private Velocidad velocidad;
	//private int tiempoViejo;
	
	Circulo(){
		radio = 5;
	}
	
	Circulo(int radio, int i, int j){
		this.radio = radio;
		velocidad = new Velocidad(i,j);
	}

	public Circulo(int i, int j, int k, int l, int vx, int vy) {
		super(i,j,k,l);
		velocidad = new Velocidad(vx, vy);
		//tiempoViejo = (int)System.nanoTime();
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public void mover(double dt){
		Dimension dim = velocidad.mover(dt);
		this.x = dim.width;
		this.y = dim.height;
	}
	
	public void retroceder(){
		velocidad.cambiarSentido();
	}

	

}
