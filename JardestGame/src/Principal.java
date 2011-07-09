
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal {
	private static JFrame frame;
	private static InterfazGrafica gui;
	private static Nivel nivel;
	private static Computo computo;
	private static GamePlay gp;
	private static LinkedList<Circulo> bolas;
	private static Cuadrado cuadrado;
	
	public static void main(String[] args) {
		frame = new JFrame();
		//gui = new InterfazGrafica();
		cuadrado=new Cuadrado(15);
		bolas= new LinkedList<Circulo>();
		frame.setResizable(false);	//TU PUTA MADRE CABRON!
		nivel=new Nivel(cuadrado, bolas, new Dimension(500,500));
		frame.getContentPane().add(nivel);
		
		
		
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		computo=new Computo(cuadrado, bolas, new Dimension(nivel.getWidth(),nivel.getHeight()));
		gp=new GamePlay(computo, nivel);
		frame.setVisible(true);
		gp.start();
		
	}

}
