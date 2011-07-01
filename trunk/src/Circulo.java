
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Circulo extends JComponent{
	int radio;
	
	Circulo(){
		radio = 5;
	}
	
	Circulo(int radio){
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

}
