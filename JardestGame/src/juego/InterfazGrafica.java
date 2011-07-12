package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;


public class InterfazGrafica extends JPanel{
	
	private Nivel nivel;
	private GridBagConstraints gridBagCoord;
	
	
	InterfazGrafica(Nivel nivel){
		this.nivel=nivel;
		this.setPreferredSize(new Dimension(550, 400)); //tamaño por probar
		this.setLayout(new GridBagLayout());
		gridBagCoord = new GridBagConstraints();
		
		gridBagCoord.gridx = 1;
		gridBagCoord.gridy = 1;	
		gridBagCoord.gridwidth = 1;
		gridBagCoord.gridheight = 1;
		
		this.add(nivel, gridBagCoord);
	}
	
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(0xb4b5fe)); //Lila de fondo
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		
	}

}
