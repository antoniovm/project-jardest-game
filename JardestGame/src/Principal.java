
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal {
	private static JFrame frame;
	private static InterfazGrafica gui;
	
	public static void main(String[] args) {
		frame = new JFrame();
		gui = new InterfazGrafica();
		frame.getContentPane().add(gui);
		
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}

}
