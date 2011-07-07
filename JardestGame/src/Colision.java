import java.util.Iterator;
import java.util.LinkedList;


public class Colision extends Thread{

	private LinkedList<Circulo> bolas;
	private Cuadrado cuadrado;
	private int limite;
	private static int ANCHO_VENTANA, ALTO_VENTANA;
	
	public Colision(LinkedList<Circulo> bolas, Cuadrado cuadrado) {
		this.bolas=bolas;
		this.cuadrado=cuadrado;
		this.limite = cuadrado.getMitadAltura() + bolas.get(0).getRadio();
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
			if(Math.abs(cuadrado.getX()+cuadrado.getMitadAltura()-(aux.getX()+aux.getRadio())) <= limite){
				cuadrado.setX(0);
				cuadrado.setY(ALTO_VENTANA/2);
			}
			//  Pared Izq		Pared Der	--Circulos--     		Pared Sup		Pared Inf
			if((aux.getX()<0)||((aux.getX()+aux.getRadio())>ANCHO_VENTANA)||(aux.getY()<0)||((aux.getY()+aux.getRadio())>ALTO_VENTANA)){
				aux.retroceder();
			}
			
			
			// Cuadrado
			if(cuadrado.getX()<0)	aux.x=0;
				
			if((cuadrado.getX()+cuadrado.getAltura())>ANCHO_VENTANA) aux.x=ANCHO_VENTANA-aux.getRadio();
			
			if(cuadrado.getY()<0)	aux.y=0;

			if((cuadrado.getY()+cuadrado.getAltura())>ALTO_VENTANA) aux.y=ALTO_VENTANA-aux.getRadio();
		}

	}
	
}
