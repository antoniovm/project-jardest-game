import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
		this.ventana=ventana;
		cuadrado.setVisible(true);
		construirBolas(new Circulo(5, 0, 0));
		this.colision=new Colision(bolas, cuadrado, ventana);
		
	}
	
	public void construirBolas(Circulo circulo) {
		for(int i=0; i<20; i++){
			if(i%2==0){
				//las pares empiezan arriba
				bolas.add( new Circulo(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2, 0, 100, circulo.getRadio()));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2);
			}
			else{
				//las impares empiezan abajo (no cuadra el this.getHeight(), tengo que sumarle 460 cuando no deberia hacer falta)
				bolas.add( new Circulo(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2, 0 ,-100, circulo.getRadio()));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2);
			}
		}
		this.add(cuadrado);
		

	}

	public void repintar() {
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Circulo> it=bolas.iterator();
		for(int i=0; it.hasNext(); i++){
			Circulo aux = it.next();
			if(i%2==0)
				g.setColor(Color.blue);
			else
				g.setColor(Color.red);
			g.fillOval(aux.x, aux.y, aux.width, aux.height); //pintamos el circulo con las coordenadas y tamaño del rectangulo
		}
			//g.drawString(prueba, 100, 100);
			
		cuadrado.paint(g);
	}
	
}
