

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class Cuadrado extends JComponent implements KeyListener{ //jcomponent para poder pedir focus
	private double altura;
	private double mitadAltura;
	private double x, y;
	private float vx, vy; //para fisica()
	private boolean presionado, arriba, abajo, derecha, izquierda; //aux, para que al dejar pulsada la tecla no se inicie el hilo muchas veces
	private Velocidad velocidad;
	
	Cuadrado(){
		this.altura = 20;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		this.presionado = false;
		this.velocidad = new Velocidad();
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	Cuadrado(int altura){
		this.altura = altura;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=0;
		this.presionado = false;
		this.velocidad = new Velocidad();
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		
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
	
	public void mover(double dt){
		Punto dim = velocidad.mover(dt);
		this.x += dim.getX();
		this.y += dim.getY();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, (int)altura, (int)altura);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//si lo metemos dentro de !presionado, si queda alguna pulsada (true), al hacer released no llamara a actualizar y no cambiara la velocidad
		actualizar(e.getKeyCode(),200);
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
