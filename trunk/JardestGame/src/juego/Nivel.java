package juego;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;


public class Nivel extends JPanel{
	private Geometria geometria;
	private Dimension ventana;
	private Cuadrado cuadrado;
	private LinkedList<Circulo> bolas;
	private Color lilaClaro, lila, verdeClaro;

	public Nivel(Cuadrado cuadrado, LinkedList<Circulo> bolas, Geometria geometria) {
		this.ventana=new Dimension(geometria.getAncho()*geometria.getLosa(), geometria.getAlto()*geometria.getLosa());
		this.cuadrado=cuadrado;
		this.bolas=bolas;
		this.geometria=geometria;
		this.setVentana(ventana);
		cuadrado.setVisible(true);
		tamanoVentanaPorDefecto(ventana);
		this.setSize(ventana);
		construirBolas(4,4); 
		setUI(null);
		
		
		//COLORES
		lila=new Color(0xe6e6ff);
		lilaClaro=new Color(0xf7f7ff);
		verdeClaro=new Color(0xb5feb4);
				
	}
	/**
	 * Construye las bolas 
	 * @param numBolas
	 * @param radio
	 */
	public void construirBolas(int numBolas,int radio) {
		for(int i=0; i<numBolas; i++){
			if(i%2==0){
				//las pares empiezan arriba
				//bolas.add( new Circulo(i*(radio+20), 0,radio, 250, Math.PI,  Color.blue));
				bolas.add( new Circulo(340, i*(radio+20)+geometria.getLosa()*2+geometria.getLosa()/4,radio, 250, 0,  Color.blue));
			}
			else{
				//las impares empiezan abajo (no cuadra el this.getHeight(), tengo que sumarle 460 cuando no deberia hacer falta)
				bolas.add( new Circulo(100, i*(radio+20)+geometria.getLosa()/2, radio, 250 ,0, Color.red));
				
			}
		}
		//bolas.get(0).setVelocidad(new Velocidad(250, Math.PI/4));
		//bolas.get(1).setVelocidad(new Velocidad(250, Math.PI/4));
		
		this.add(cuadrado);
		

	}
	/**
	 * Refresca la pantalla
	 */
	public void repintar() {
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
		fondo(g);

		Iterator<Circulo> it=bolas.iterator();
		for(int i=0; it.hasNext(); i++){
			it.next().paint(g);
		}
			
		cuadrado.paint(g);
	}
	/**
	 * Establece un tamaño de ventana por defecto
	 * @param ventana
	 */
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

	/**
	 * Pinta la zona segura (inicio/meta)
	 * @param g
	 */
	private void zonaSegura(Graphics g) {
		g.setColor(verdeClaro); 	
		g.fillRect(0, getHeight()/2-50, 50, 100);

	}
	/**
	 * Pinta la cuadricula de fondo 
	 * @param g
	 */
	private void fondo(Graphics g) {
		int i, j;
		for (i = 0; i < geometria.getAlto(); i++) {
			for (j = 0; j < geometria.getAncho(); j++) {
				if(seleccionarColor(i, j, g))
					g.fillRect(j*geometria.getLosa(), i*geometria.getLosa(), geometria.getLosa(), geometria.getLosa());
			}
		}

	}
	
	private boolean seleccionarColor(int i, int j,Graphics g) {
		switch (geometria.getElemento(i,j)) {
		case 0: return false;
		case 1: 
			if(i%2==j%2) g.setColor(lila);
			else		g.setColor(lilaClaro);
			return true;
		case 2:
		case 3:
			g.setColor(verdeClaro);
			return true;
			

		default:
			return false;
		}

	}
	public LinkedList<Punto> getPuntos() {
		Punto primPosValida = geometria.getPrimeraPosicionValida();
		int sentido=0; //0 derecha, 1 arriba, 2 izquierda, 3 abajo
		LinkedList<Punto> puntos = new LinkedList<Punto>();
		puntos.add(new Punto(0, 0));
		
		for (int i = 0; i < geometria.getAlto(); i++) {
			for (int j = 0; j < geometria.getAncho(); j++) {
				if(cambioDireccion(sentido, i, j)) 
					puntos.add(new Punto(i*geometria.getLosa(),j*geometria.getLosa()));
			}
		}
		return null;
	}
	
	private boolean cambioDireccion(int sentido, int i, int j) {
		switch (sentido) {
		case 0:
			if(i>0)
			break;

		default:
			break;
		}
		return false; 

	}
	
}
