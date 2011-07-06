
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class InterfazGrafica extends JPanel{
	private Circulo circulo; //circulo que tiene info sobre radio
	private boolean arribaAbajoPar; //saber si vamos de arriba hacia abajo o al contrario (pelotas pares)
	private boolean arribaAbajoImpar; //saber si vamos de arriba hacia abajo o al contrario (pelotas impares)
	private Rectangle[] rects; //array de pelotas
	private Cuadrado cuadrado;
	private String prueba;
	private LinkedList<Circulo> bolas;
	
	InterfazGrafica(){
		bolas = new LinkedList<Circulo>();
		circulo = new Circulo();
		cuadrado = new Cuadrado();
		arribaAbajoPar = true;
		arribaAbajoImpar = false;
		prueba = "inicio";
		rects = new Circulo[20];
		for(int i=0; i<20; i++){
			if(i%2==0){
				//las pares empiezan arriba
				bolas.add( new Circulo(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2);
			}
			else{
				//las impares empiezan abajo (no cuadra el this.getHeight(), tengo que sumarle 460 cuando no deberia hacer falta)
				bolas.add( new Circulo(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2));
				//rects[i] = new Rectangle(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2);
			}
		}
		this.add(cuadrado);
		cuadrado.setVisible(true);
		
		/*this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();*/
		//this.requestFocus();
	}
	
	public Circulo getCirculo() {
		return circulo;
	}

	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//pintamos todas, cada una de su color correspondiente
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
			
			try {
				Thread.sleep(20); //retrasamos desplazamiento
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			if(arribaAbajoPar){ //movimiento de las pares arriba abajo
				for (Iterator<Circulo> iterator = bolas.iterator(); iterator
						.hasNext();) {
					Circulo circ =  iterator.next();
					if(circ.y+circulo.getRadio()*2 < this.getHeight()) //si no hemos llegado al borde inferior
						circ.translate(0, 5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
					else
						arribaAbajoPar=false; //si llegamos abajo, cambiamos movimiento
					if(iterator.hasNext())
					iterator.next();
					
				}
				/*for(int j=0; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()*2 < this.getHeight()) //si no hemos llegado al borde inferior
						rects[j].translate(0, 5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
					else
						arribaAbajoPar=false; //si llegamos abajo, cambiamos movimiento
				}*/
				this.repaint();
			}
		
		if (!arribaAbajoPar) { // movimiento de las pares abajo arriba
			for (Iterator<Circulo> iterator = bolas.iterator(); iterator
					.hasNext();) {
				Circulo circ = iterator.next();
				if (circ.y + circulo.getRadio() * 2 >0) // si no
																		// hemos
																		// llegado
																		// al
																		// borde
																		// inferior
					circ.translate(0, -5); // posicionX+=0 posicionY+=5, se
											// actuailza x e y de rect
				else
					arribaAbajoPar = true; // si llegamos abajo, cambiamos
				if(iterator.hasNext())				// movimiento
				iterator.next();

			}
				/*for(int j=0; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()-5 > 0) //si no hemos llegado al borde superior
						rects[j].translate(0, -5); //posicionX+=0  posicionY-=5
					else
						arribaAbajoPar=true; //si llegamos arriba, cambiamos movimiento
				}*/
				this.repaint();
			}
			
			if(arribaAbajoImpar){ //movimiento de las impares de arriba abajo
				Iterator<Circulo> iterator = bolas.iterator();
				iterator.next();
				for (; iterator
				.hasNext();) {
			Circulo circ =  iterator.next();
			if(circ.y+circulo.getRadio()*2 < this.getHeight()) //si no hemos llegado al borde inferior
				circ.translate(0, 5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
			else
				arribaAbajoImpar=false; //si llegamos abajo, cambiamos movimiento
			if(iterator.hasNext())
			iterator.next();
			
		}
				/*for(int j=1; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()*2 < this.getHeight()) //si no hemos llegado al borde inferior
						rects[j].translate(0, 5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
					else
						arribaAbajoImpar=false; //si llegamos abajo, cambiamos movimiento
				}*/
				this.repaint();
			}
		
			if(!arribaAbajoImpar){ //movimiento de las impares de abajo arriba
				Iterator<Circulo> iterator = bolas.iterator();
				iterator.next();
				for (; iterator
				.hasNext();) {
			Circulo circ =  iterator.next();
			if(circ.y+circulo.getRadio()*2 >0) //si no hemos llegado al borde inferior
				circ.translate(0, -5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
			else
				arribaAbajoImpar=true; //si llegamos abajo, cambiamos movimiento
			if(iterator.hasNext())
			iterator.next();
				/*for(int j=1; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()-5 > 0) //si no hemos llegado al borde superior
						rects[j].translate(0, -5); //posicionX+=0  posicionY-=5
					else
						arribaAbajoImpar=true; //si llegamos arriba, cambiamos movimiento
				*/}
				this.repaint();
			}
	}

}
