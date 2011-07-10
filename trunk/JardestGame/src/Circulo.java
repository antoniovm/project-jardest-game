
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Circulo {
	private double x, y, ancho,alto;
	private Color color;
	private double radio;
	private Velocidad velocidad;
	//private int tiempoViejo;
	
	public Circulo(){
		radio = 5;
	}
	
	public Circulo(double radio, int i, int j){
		this.color=Color.blue;
		this.radio = radio;
		velocidad = new Velocidad(i,j);
	}

	public Circulo(double x, double y, double ancho, double alto, double modulo, double angulo, double radio, Color color) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.radio = radio;
		velocidad = new Velocidad(modulo, angulo);
		this.color=color;
		
	}
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, (int)this.ancho, (int)this.alto);
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

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Velocidad getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Velocidad velocidad) {
		this.velocidad = velocidad;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public void retroceder(){
		velocidad.cambiarSentido();
	}
	
	public void rebotar(String s) {
		velocidad.rebote(s);
	}
	
	public Punto getCompoentesVelocidad() {
		return new Punto(velocidad.getI(),velocidad.getJ());
	}
	
	@Override
	public String toString() {
		return "Origen: ("+x+","+y+")\n"+
			   "Dim: ("+ancho+","+alto+")\n"+
			   "Radio: "+radio+"\n"+
			   "Velocidad: "+velocidad.toString();
	}

	

}
