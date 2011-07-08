import java.awt.Dimension;
import java.util.LinkedList;


public class GamePlay {
	private static final int fps=60;
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
	
	public void start() {	//Bucle principal del juego
		double tiempoViejo=System.currentTimeMillis();
		int i=0;
		while(true){
			double tiempoNuevo = System.currentTimeMillis();
			double dt = (double)1/fps;//(tiempoNuevo - tiempoViejo)/1000; //segundos 
			tiempoViejo = tiempoNuevo;
			computo.siguienteEstado(dt);
			nivel.repintar();
			i++;
			try {
				Thread.sleep((int)(((double)1/fps)*1000));	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
