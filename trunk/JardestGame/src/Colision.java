import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;


public class Colision extends Thread{

	private LinkedList<Circulo> bolas;
	private Cuadrado cuadrado;
	private double limite;
	private static int ANCHO_VENTANA, ALTO_VENTANA;
	
	public Colision(LinkedList<Circulo> bolas, Cuadrado cuadrado, Dimension ventana) {
		this.bolas=bolas;
		this.cuadrado=cuadrado;
		this.limite = (cuadrado.getMitadAltura() + bolas.get(0).getRadio());
		this.ANCHO_VENTANA = ventana.width;
		this.ALTO_VENTANA = ventana.height;
	}
	
	@Override
	public void run() {
		while(true){
			comprobar();
		}
	}
	
	public void comprobar() {
		for (Iterator<Circulo> iterator = bolas.iterator(); iterator.hasNext();) {
			Circulo aux = iterator.next();
			if((Math.abs(cuadrado.getCentroX()-aux.getCentroX()) <= limite) && (Math.abs(cuadrado.getCentroY()-aux.getCentroY()) <= limite)){
				cuadrado.setX(0);
				cuadrado.setY(ALTO_VENTANA/2);
			}
			
			//  Pared Izq		Pared Der	--Circulos--     		Pared Sup		Pared Inf
			if((aux.getX()<0)||((aux.getX()+aux.getRadio()*2)>ANCHO_VENTANA)||(aux.getY()<0)||((aux.getY()+aux.getRadio()*2)>ALTO_VENTANA)){
				aux.retroceder();
			}
			
			
		}

		// Cuadrado
		if(cuadrado.X()<0)
			cuadrado.setX(0);
			
		if((cuadrado.X()+cuadrado.getAltura())>ANCHO_VENTANA)
			cuadrado.setX(ANCHO_VENTANA-cuadrado.getAltura());
		
		if(cuadrado.Y()<0)
			cuadrado.setY(0);

		if((cuadrado.Y()+cuadrado.getAltura())>ALTO_VENTANA) //17 depende del tamaño del cuadrado
			cuadrado.setY(ALTO_VENTANA-cuadrado.getAltura());

	}
	
}
