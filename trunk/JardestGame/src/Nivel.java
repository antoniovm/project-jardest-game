import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;


public class Nivel extends JPanel{

	private Dimension ventana;
	private Colision colision;	//Gestion de colisiones
	private Cuadrado cuadrado;
	private LinkedList<Circulo> bolas;

	public Nivel(Cuadrado cuadrado, LinkedList<Circulo> bolas, Dimension ventana) {	
		this.cuadrado=cuadrado;
		this.bolas=bolas;
		this.setVentana(ventana);
		cuadrado.setVisible(true);
		tamanoVentanaPorDefecto(ventana);
		this.setSize(ventana);
		construirBolas(20,5);
		this.setColision(new Colision(bolas, cuadrado, ventana));
		
		
		
	}
	
	public void construirBolas(int numBolas,int radio) {
		for(int i=0; i<numBolas; i++){
			if(i%2==0){
				//las pares empiezan arriba
				bolas.add( new Circulo(i*(radio+20), radio, radio*2, radio*2, 250, Math.PI/2, radio, Color.blue));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2);
			}
			else{
				//las impares empiezan abajo (no cuadra el this.getHeight(), tengo que sumarle 460 cuando no deberia hacer falta)
				bolas.add( new Circulo(i*(radio+20), this.getHeight()-radio*2, radio*2, radio*2, 250 ,-Math.PI/2, radio,Color.red));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2);
			}
		}
		bolas.get(0).setVelocidad(new Velocidad(250, Math.PI/4));
		bolas.get(1).setVelocidad(new Velocidad(250, Math.PI/4));
		this.add(cuadrado);
		

	}

	public void repintar() {
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Iterator<Circulo> it=bolas.iterator();
		for(int i=0; it.hasNext(); i++){
			it.next().paint(g);
		}
			//g.drawString(prueba, 100, 100);
			
		cuadrado.paint(g);
	}
	
	public void tamanoVentanaPorDefecto(Dimension ventana) {
		setPreferredSize(ventana);
		setMinimumSize(ventana);
		setMaximumSize(ventana);

	}

	public void setVentana(Dimension ventana) {
		this.ventana = ventana;
	}

	public Dimension getVentana() {
		return ventana;
	}

	public void setColision(Colision colision) {
		this.colision = colision;
	}

	public Colision getColision() {
		return colision;
	}
	
}
