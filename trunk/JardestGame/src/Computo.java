import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;


public class Computo {
	
	private Dimension ventana;
	private Colision colision;	//Gestion de colisiones
	private Cuadrado cuadrado;
	private LinkedList<Circulo> bolas;

	public Computo(Cuadrado cuadrado, LinkedList<Circulo> bolas, Dimension ventana) {
		this.colision=new Colision(bolas, cuadrado);
		this.cuadrado=cuadrado;
		this.bolas=bolas;
		this.ventana=ventana;
	}

	public void siguienteEstado(double dt){
		for (Iterator<Circulo> iterator = bolas.iterator(); iterator.hasNext();) {
			iterator.next().mover(dt);
		}
		cuadrado.mover(dt);
		colision.comprobar();
		
		
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
