package juego;
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
	/**
	 * Bucle principal del juego
	 */
	public void start() {	
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
	/**
	 * LLamada al sistema para obtener la frecuencia de refresco del monitor
	 */
	private void frecuenciaRefrescoSO() {	 
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		DisplayMode dmode = gs.getDisplayMode();
		
		fps = dmode.getRefreshRate();
		

	}
	public static int getFps() {
		return fps;
	}
	public static void setFps(int fps) {
		GamePlay.fps = fps;
	}
	public Dimension getVentana() {
		return ventana;
	}
	public void setVentana(Dimension ventana) {
		this.ventana = ventana;
	}
	public Cuadrado getCuadrado() {
		return cuadrado;
	}
	public void setCuadrado(Cuadrado cuadrado) {
		this.cuadrado = cuadrado;
	}
	public LinkedList<Circulo> getBolas() {
		return bolas;
	}
	public void setBolas(LinkedList<Circulo> bolas) {
		this.bolas = bolas;
	}
	public Computo getComputo() {
		return computo;
	}
	public void setComputo(Computo computo) {
		this.computo = computo;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
