package juego;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;


public class InterfazGrafica extends JPanel{
	
	private Nivel nivel;
	private Constraints gridBagCoord;
	
	
	InterfazGrafica(Nivel nivel){
		this.nivel=nivel;
	}
	
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
	}

}
