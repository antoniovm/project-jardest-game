import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JPanel;


public class Nivel extends JPanel{

	private Dimension ventana;
	private Colision colision;	//Gestion de colisiones
	private Cuadrado cuadrado;
	private LinkedList<Circulo> bolas;

	public Nivel(Cuadrado cuadrado, LinkedList<Circulo> bolas, Dimension ventana) {
		this.colision=new Colision(bolas, cuadrado);
		this.cuadrado=cuadrado;
		this.bolas=bolas;
		this.ventana=ventana;
		cuadrado.setVisible(true);
	}
	
	public void construirBolas(Circulo circulo) {
		for(int i=0; i<20; i++){
			if(i%2==0){
				//las pares empiezan arriba
				bolas.add( new Circulo(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2, 0, 5));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2);
			}
			else{
				//las impares empiezan abajo (no cuadra el this.getHeight(), tengo que sumarle 460 cuando no deberia hacer falta)
				bolas.add( new Circulo(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2, 0 ,-5));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2);
			}
		}
		this.add(cuadrado);
		

	}
	
}
