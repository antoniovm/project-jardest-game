package juego;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class Cuadrado extends JComponent implements KeyListener{ //jcomponent para poder pedir focus
	private Color color;
	private double altura, mitadAltura, x,y, vMaxima;
	private Velocidad velocidad;
	
	Cuadrado(){
		this.color = Color.green;
		this.altura = 20;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		this.velocidad = new Velocidad();
		this.vMaxima=200;
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	Cuadrado(int altura){
		this();
		this.altura = altura;
	}
	

	public void setX(double x) {
		this.x = x;
	}


	public double X() {
		return x;
	}

	public double Y() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getMitadAltura() {
		return mitadAltura;
	}

	public void setMitadAltura(int mitadAltura) {
		this.mitadAltura = mitadAltura;
	}
	
	public double getCentroX(){
		return x+mitadAltura;
	}
	
	public double getCentroY(){
		return y+mitadAltura;
	}
	/**
	 * Mueve el objeto sobre la pantalla, en funcion de su velocidad en un intervalo de tiempo
	 * @param dt El intervalo de tiempo en segundos
	 */
	public void mover(double dt){
		Punto dim = velocidad.mover(dt);
		this.x += dim.getX();
		this.y += dim.getY();
	}
	/**
	 * Pinta el cuadrado
	 * @param g El objeto grafico sobre el cual se pinta
	 */
	public void paint(Graphics g) {
		int tamBorde=3;
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)altura, (int)altura);
		g.setColor(Color.black);
		for (int i = 1; i <= tamBorde; i++) {
			g.drawRect(((int)x)-i, (int)y-i, ((int)altura)+2*i-1, ((int)altura)+2*i-1);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		actualizar(e.getKeyCode(),vMaxima);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		actualizar(e.getKeyCode(), 0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/**
	 * Establece una determinada velocidad dependiendo de las teclas pulsadas
	 * @param keyCode	El codigo de la tecla pulsada
	 * @param modulo		El modulo de la velocidad
	 */
	private void actualizar(int keyCode, double modulo){
		 switch (keyCode) {
         case KeyEvent.VK_UP:	//Arriba
         case KeyEvent.VK_W:
             velocidad.setJ(-modulo);
        	 break;

         case KeyEvent.VK_DOWN:	//Abajo
         case KeyEvent.VK_S:
             velocidad.setJ(modulo);
        	 break;

         case KeyEvent.VK_LEFT:	//Izquierda
         case KeyEvent.VK_A:
             velocidad.setI(-modulo);
        	 break;

         case KeyEvent.VK_RIGHT:	//Derecha
         case KeyEvent.VK_D:
             velocidad.setI(modulo);
        	 break;
		 }
	}
}
