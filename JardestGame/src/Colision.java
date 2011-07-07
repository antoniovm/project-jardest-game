import java.util.Iterator;
import java.util.LinkedList;


public class Colision extends Thread{

	private LinkedList<Circulo> bolas;
	private Cuadrado cuadrado;
	private int limite;
	
	public Colision(LinkedList<Circulo> bolas, Cuadrado cuadrado) {
		this.bolas=bolas;
		this.cuadrado=cuadrado;
		this.limite = cuadrado.getMitadAltura() + bolas.get(0).getRadio();
	}
	
	@Override
	public void run() {
		while(1==1){
			for (Iterator<Circulo> iterator = bolas.iterator(); iterator.hasNext();) {
				Circulo aux = iterator.next();
				if(Math.abs(cuadrado.getX()+cuadrado.getMitadAltura()-(aux.getX()+aux.getRadio())) <= limite){
					cuadrado.setX(0);
					cuadrado.setY(200);
				}
			}
		}
	}
	
}
