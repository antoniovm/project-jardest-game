

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.FocusManager;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Cuadrado extends JComponent implements KeyListener{ //jcomponent para poder pedir focus
	private int altura;
	private int mitadAltura;
	private int x, y;
	private float vx, vy; //para fisica()
	private boolean presionado, arriba, abajo, derecha, izquierda; //aux, para que al dejar pulsada la tecla no se inicie el hilo muchas veces
	private Velocidad velocidad;
	
	Cuadrado(){
		this.altura = 20;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		this.presionado = false;
		this.velocidad = new Velocidad(0,0); //velocidad por defecto?
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	Cuadrado(int altura, int i, int j){
		this.altura = altura;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		this.presionado = false;
		this.velocidad = new Velocidad(i, j);
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getMitadAltura() {
		return mitadAltura;
	}

	public void setMitadAltura(int mitadAltura) {
		this.mitadAltura = mitadAltura;
	}
	
	public void mover(double dt){
		Dimension dim = velocidad.mover(dt);
		this.x = dim.width;
		this.y = dim.height;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, mitadAltura, mitadAltura);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//si lo metemos dentro de !presionado, si queda alguna pulsada (true), al hacer released no llamara a actualizar y no cambiara la velocidad
		actualizar(e.getKeyCode(),5);
		/*if(!this.presionado){ //si es la primera vez que pulso la tecla (no multiples evento de dejarla pulsada)
			this.presionado=true;
		}*/
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		actualizar(e.getKeyCode(), 0);
		//this.presionado = arriba || abajo || derecha || izquierda;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	//actualizar direccion de movimiento
	private void actualizar(int keyCode, double valor){
		 switch (keyCode) {
         case KeyEvent.VK_UP:
             //arriba = presionado;
             velocidad.setJ(-valor);
        	 break;

         case KeyEvent.VK_DOWN:
             //abajo = presionado;
             velocidad.setJ(valor);
        	 break;

         case KeyEvent.VK_LEFT:
             //izquierda = presionado;
             velocidad.setI(-valor);
        	 break;

         case KeyEvent.VK_RIGHT:
             //derecha = presionado;
             velocidad.setI(valor);
        	 break;
		 }
	}
}
