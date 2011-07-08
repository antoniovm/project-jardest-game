
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
		nivel=new Nivel(cuadrado, bolas, new Dimension(500,500));
		frame.getContentPane().add(nivel);
		
		
		
		
		
		
		
		
		
		computo=new Computo(cuadrado, bolas, new Dimension(500,500));
		gp=new GamePlay(computo, nivel);
		
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		gp.start();
		
	}

}
