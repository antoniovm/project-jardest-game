import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.LinkedList;


public class GamePlay {
	private static int fps;
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
		frecuenciaRefrescoSO();
	}
	
	public void start() {	//Bucle principal del juego
		while(true){
			double dt = (double)1/fps;
			
			computo.siguienteEstado(dt);
			nivel.repintar();
			
			try {
				Thread.sleep((int)(((double)1/fps)*1000));	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private void frecuenciaRefrescoSO() {	// LLamada al sistema para obtener la frecuencia de refresco del monitor 
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		DisplayMode dmode = gs.getDisplayMode();
		
		fps = dmode.getRefreshRate();
		

	}
}
