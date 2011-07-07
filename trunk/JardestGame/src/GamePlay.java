import java.awt.Dimension;
import java.util.LinkedList;


public class GamePlay {
	private Dimension ventana;
	private Cuadrado cuadrado;
	private LinkedList<Circulo> bolas;
	private Computo computo;
	private Nivel nivel;
	

	public GamePlay(Computo computo, Nivel nivel) {
		this.cuadrado=new Cuadrado(5);
		this.bolas=new LinkedList<Circulo>();
		this.ventana=new Dimension(500,500);
		this.computo=computo;
		this.nivel=nivel;
	}
	
	public void start() {
		double tiempoViejo=System.currentTimeMillis();
		while(true){
			double tiempoNuevo = System.currentTimeMillis();
			double dt = (tiempoNuevo - tiempoViejo)/1000000; //segundos 
			tiempoViejo = tiempoNuevo;
		}

	}
}
