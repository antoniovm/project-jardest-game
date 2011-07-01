
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class InterfazGrafica extends JPanel implements KeyListener{
	private Circulo circulo; //circulo que tiene info sobre radio
	private boolean arribaAbajoPar; //saber si vamos de arriba hacia abajo o al contrario (pelotas pares)
	private boolean arribaAbajoImpar; //saber si vamos de arriba hacia abajo o al contrario (pelotas impares)
	private Rectangle[] rects; //array de pelotas
	private Cuadrado cuadrado;
	private String prueba;
	
	InterfazGrafica(){
		circulo = new Circulo();
		cuadrado = new Cuadrado();
		arribaAbajoPar = true;
		arribaAbajoImpar = false;
		prueba = "inicio";
		rects = new Rectangle[20];
		for(int i=0; i<20; i++){
			if(i%2==0){
				//las pares empiezan arriba
				rects[i] = new Rectangle(i*(circulo.getRadio()+20), 0+circulo.getRadio(), circulo.getRadio()*2, circulo.getRadio()*2);
			}
			else{
				//las impares empiezan abajo (no cuadra el this.getHeight(), tengo que sumarle 460 cuando no deberia hacer falta)
				rects[i] = new Rectangle(i*(circulo.getRadio()+20), this.getHeight()+460, circulo.getRadio()*2, circulo.getRadio()*2);
			}
		}
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
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
		for(int i=0; i<20; i++){
			if(i%2==0)
				g.setColor(Color.blue);
			else
				g.setColor(Color.red);
			g.fillOval(rects[i].x, rects[i].y, rects[i].width, rects[i].height); //pintamos el circulo con las coordenadas y tamaño del rectangulo
		}
			//g.drawString(prueba, 100, 100);
			
			cuadrado.paint(g);
			
			try {
				Thread.sleep(20); //retrasamos desplazamiento
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			if(arribaAbajoPar){ //movimiento de las pares arriba abajo
				for(int j=0; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()*2 < this.getHeight()) //si no hemos llegado al borde inferior
						rects[j].translate(0, 5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
					else
						arribaAbajoPar=false; //si llegamos abajo, cambiamos movimiento
				}
				this.repaint();
			}
		
			if(!arribaAbajoPar){ //movimiento de las pares abajo arriba
				for(int j=0; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()-5 > 0) //si no hemos llegado al borde superior
						rects[j].translate(0, -5); //posicionX+=0  posicionY-=5
					else
						arribaAbajoPar=true; //si llegamos arriba, cambiamos movimiento
				}
				this.repaint();
			}
			
			if(arribaAbajoImpar){ //movimiento de las impares de arriba abajo
				for(int j=1; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()*2 < this.getHeight()) //si no hemos llegado al borde inferior
						rects[j].translate(0, 5); //posicionX+=0  posicionY+=5, se actuailza x e y de rect
					else
						arribaAbajoImpar=false; //si llegamos abajo, cambiamos movimiento
				}
				this.repaint();
			}
		
			if(!arribaAbajoImpar){ //movimiento de las impares de abajo arriba
				for(int j=1; j<20; j+=2){
					if(rects[j].y+circulo.getRadio()-5 > 0) //si no hemos llegado al borde superior
						rects[j].translate(0, -5); //posicionX+=0  posicionY-=5
					else
						arribaAbajoImpar=true; //si llegamos arriba, cambiamos movimiento
				}
				this.repaint();
			}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cuadrado.desplazar(6, 0);
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cuadrado.desplazar(-6, 0);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			cuadrado.desplazar(0, -6);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cuadrado.desplazar(0, 6);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
