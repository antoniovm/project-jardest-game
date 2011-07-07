

import java.awt.Color;
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
	private Thread hiloMovimiento; //hilo solo para mover cuadrado y repintarlo
	
	Cuadrado(){
		this.altura = 20;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		this.presionado = false;
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		hiloMovimiento=new Thread(){
			public void run() {
				//long tiempoViejo = System.nanoTime();
				while(presionado){
		            //long tiempoNuevo = System.nanoTime();
		            //float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
		            //tiempoViejo = tiempoNuevo;
					//fisica(dt);
					desplazar();
					try {
						repintar();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
	}
	
	Cuadrado(int altura){
		this.altura = altura;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	public int getX() {
		return Math.round(x);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return Math.round(y);
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

	//desplazar en eje x e y de 6 en 6
	public void desplazar(){
		if(arriba)
			y-=6;
		if(abajo)
			y+=6;
		if(derecha)
			x+=6;
		if(izquierda)
			x-=6;
	}
	
	//copiado
	 private void fisica(float dt) {
		 vx = 0;
	     vy = 0;
	     if (arriba)
	    	 vy = -300;
	     if (abajo)
	            vy = 300;
	        if (izquierda)
	            vx = -300;
	        if (derecha)
	            vx = 300;
	        //x = clamp(x + vx * dt, 0, 500 - altura);
	        //y = clamp(y + vy * dt, 0, 500 - altura);
	}
	 
	 //copiado
	 private float clamp(float valor, float min, float max) {
	        if (valor > max)
	            return max;
	        if (valor < min)
	            return min;
	        return valor;
	    }
	
	private void repintar() throws Exception{ //llamarlo desde el hilo
		 SwingUtilities.invokeAndWait(new Runnable() {
             public void run() {
                 repaint();
             }
         });
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(Math.round(x), Math.round(y), mitadAltura, mitadAltura);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		actualizar(e.getKeyCode(),true);
		if(!this.presionado){ //si es la primera vez que pulso la tecla (no multiples evento de dejarla pulsada)
			this.presionado=true;
			Thread hilo = new Thread(hiloMovimiento); //apaño para volver a lanzar el hilo despues de hacer released
			hilo.start();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		actualizar(e.getKeyCode(),false);
		this.presionado = arriba || abajo || derecha || izquierda;
		if(!presionado)
			hiloMovimiento.interrupt();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	//actualizar direccion de movimiento
	private void actualizar(int keyCode, boolean presionado){
		 switch (keyCode) {
         case KeyEvent.VK_UP:
             arriba = presionado;
             break;

         case KeyEvent.VK_DOWN:
             abajo = presionado;
             break;

         case KeyEvent.VK_LEFT:
             izquierda = presionado;
             break;

         case KeyEvent.VK_RIGHT:
             derecha = presionado;
             break;
		 }
	}
}
