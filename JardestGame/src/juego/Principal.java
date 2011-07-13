package juego;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;


public class Principal {
	private static JFrame frame;
	private static InterfazGrafica gui;
	private static Nivel nivel;
	private static Computo computo;
	private static GamePlay gp;
	private static LinkedList<Circulo> bolas;
	private static Cuadrado cuadrado;
	private static Dimension dimensionVentana;
	
	public static void main(String[] args) {
		dimensionVentana=new Dimension(400, 250);
		frame = new JFrame();
		//gui = new InterfazGrafica();
		cuadrado=new Cuadrado(12);
		bolas= new LinkedList<Circulo>();
		frame.setResizable(false);	//TU PUTA MADRE CABRON!
		nivel=new Nivel(cuadrado, bolas, dimensionVentana, new Geometria(dimensionVentana, 25));
		//frame.getContentPane().add(nivel);
		gui = new InterfazGrafica(nivel);
		frame.getContentPane().add(gui);
		
		
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		computo=new Computo(cuadrado, bolas, dimensionVentana);
		gp=new GamePlay(computo, nivel,dimensionVentana);
		frame.setVisible(true);
		gp.start();
		
	}

}
