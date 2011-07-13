package juego;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;


public class Colision extends Thread{

	private LinkedList<Circulo> bolas;
	private Cuadrado cuadrado;
	private double limite;
	private int ANCHO_VENTANA, ALTO_VENTANA;
	private Geometria geometria;
	
	public Colision(LinkedList<Circulo> bolas, Cuadrado cuadrado, Dimension ventana) {
		this.bolas=bolas;
		this.cuadrado=cuadrado;
		this.limite = (cuadrado.getMitadAltura() + bolas.get(0).getRadio());
		this.ANCHO_VENTANA = (int) ventana.getWidth();
		this.ALTO_VENTANA = (int) ventana.getHeight();
		this.geometria = new Geometria(ventana, 25); //size panel, tamaño losa

	}
	
	public void setAncho(int ancho){
		this.ANCHO_VENTANA = ancho;
	}
	
	public void setAlto(int alto){
		this.ALTO_VENTANA = alto;
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
		
			
			/*//  Pared Izq		
			if(aux.getX()<0){
				aux.rebotar("i");
				aux.setX(0);
			}
			//  Pared Derecha
			if((aux.getX()+aux.getRadio()*2)>ANCHO_VENTANA){
				aux.rebotar("i");
				aux.setX(ANCHO_VENTANA-aux.getRadio()*2);
			}
			// Pared Sup
			if(aux.getY()<0){
				aux.rebotar("j");
				aux.setY(0);
			}
			// Pared Inf
			if((aux.getY()+aux.getRadio()*2)>ALTO_VENTANA){
				aux.rebotar("j");
				aux.setY(ALTO_VENTANA-aux.getRadio()*2);
			}*/
			
			
			//toca por arista izquierda
			if(!geometria.esValido(new Punto(aux.getX(), aux.getY()), new Punto(aux.getX(), aux.getY()+aux.getRadio()*2))){
				aux.rebotar("i");
				if(geometria.getParedIzq() != 0)
					geometria.setJ(geometria.getJ()+1);
				aux.setX(geometria.getParedIzq());
			}
			
			//toca por arista derecha
			if(!geometria.esValido(new Punto(aux.getX()+aux.getRadio()*2, aux.getY()), new Punto(aux.getX()+aux.getRadio()*2, aux.getY()+aux.getRadio()*2))){
				aux.rebotar("i");
				if(geometria.getParedIzq()+geometria.getLosa() != ANCHO_VENTANA) //no es valido y ademas no nos hemos salido del panel
					geometria.setJ(geometria.getJ()-1); //como no se actualiza la J en valido, se hace aqui
				aux.setX((geometria.getParedIzq()+geometria.getLosa())-aux.getAncho()-1); //-1 porque sino lo considera de la losa siguiente
			}
			
			//toca por arista superior
			if(!geometria.esValido(new Punto(aux.getX(), aux.getY()), new Punto(aux.getX()+aux.getRadio()*2, aux.getY()))){
				aux.rebotar("j");
				if(geometria.getParedSup() != 0)
					geometria.setI(geometria.getI()+1);
				aux.setY(geometria.getParedSup());
			}
			
			//toca por arista inferior
			if(!geometria.esValido(new Punto(aux.getX(), aux.getY()+aux.getRadio()*2), new Punto(aux.getX()+aux.getRadio()*2, aux.getY()+aux.getRadio()*2))){
				aux.rebotar("j");
				if(geometria.getParedSup()+geometria.getLosa() != ALTO_VENTANA)
					geometria.setI(geometria.getI()-1);
				aux.setY(geometria.getParedSup()+geometria.getLosa());
			}
			
		}
		

		// Cuadrado
		
		//  Pared Izq		
		/*if(cuadrado.X()<0)
			cuadrado.setX(0);*/
		
		if(!geometria.esValido(new Punto(cuadrado.X(), cuadrado.Y()), new Punto(cuadrado.X(), cuadrado.Y()+cuadrado.getAltura()))){
			if(geometria.getParedIzq() != 0)
				geometria.setJ(geometria.getJ()+1);
			cuadrado.setX(geometria.getParedIzq());
		}
		
		//  Pared Derecha
		if((cuadrado.X()+cuadrado.getAltura())>ANCHO_VENTANA)
			cuadrado.setX(ANCHO_VENTANA-cuadrado.getAltura());
		// Pared Sup
		if(cuadrado.Y()<0)
			cuadrado.setY(0);
		// Pared Inf
		if((cuadrado.Y()+cuadrado.getAltura())>ALTO_VENTANA) //17 depende del tamaño del cuadrado
			cuadrado.setY(ALTO_VENTANA-cuadrado.getAltura());

	}
	
	private boolean paredesCirculos(Circulo aux) {
			
		if((aux.getX()<0)||((aux.getX()+aux.getRadio()*2)>ANCHO_VENTANA)||(aux.getY()<0)||((aux.getY()+aux.getRadio()*2)>ALTO_VENTANA)){
			aux.retroceder();
			return true;
		}
		return false;
		
			
		

	}
	
}
