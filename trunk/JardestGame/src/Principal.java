
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal {
	private static JFrame frame;
	private static InterfazGrafica gui;
	private static Nivel nivel;
	private static Computo computo;
	private static GamePlay gp;
	
	public static void main(String[] args) {
		frame = new JFrame();
		//gui = new InterfazGrafica();
		frame.getContentPane().add(nivel);
		nivel=new Nivel(cuadrado, bolas, ventana)
		computo=new Computo(new Cuadrado(10), bolas, ventana)
		gp=new GamePlay(computo, nivel);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}

}
