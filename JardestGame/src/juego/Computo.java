package juego;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;


public class Computo {
	
	private Dimension ventana;
	private Colision colision;	//Gestion de colisiones
	private Cuadrado cuadrado;
	private LinkedList<Circulo> bolas;

	public Computo(Cuadrado cuadrado, LinkedList<Circulo> bolas, Dimension ventana) {
		this.colision=new Colision(bolas, cuadrado, ventana);
		this.cuadrado=cuadrado;
		this.bolas=bolas;
		this.ventana=ventana;
	}

	public void siguienteEstado(double dt){
		for (Iterator<Circulo> iterator = bolas.iterator(); iterator.hasNext();) {
			iterator.next().mover(dt);	//Mover las bolas
		}								
		cuadrado.mover(dt);				//Mover cuadrado
		colision.comprobar();			// Comprobar colisiones
		
		
	}
	
	public void setAncho(int ancho){
		colision.setAncho(ancho);
	}
	
	public void setAlto(int alto){
		colision.setAlto(alto);
	}

	public Dimension getVentana() {
		return ventana;
	}

	public void setVentana(Dimension ventana) {
		this.ventana = ventana;
	}

	public Colision getColision() {
		return colision;
	}

	public void setColision(Colision colision) {
		this.colision = colision;
	}

	public Cuadrado getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(Cuadrado cuadrado) {
		this.cuadrado = cuadrado;
	}

	public LinkedList<Circulo> getBolas() {
		return bolas;
	}

	public void setBolas(LinkedList<Circulo> bolas) {
		this.bolas = bolas;
	}
	
	

}
