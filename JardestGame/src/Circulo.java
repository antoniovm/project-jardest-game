
import java.awt.Rectangle;


public class Circulo extends Rectangle{
	int radio;
	
	Circulo(){
		radio = 5;
	}
	
	Circulo(int radio){
		this.radio = radio;
	}

	public Circulo(int i, int j, int k, int l) {
		super(i,j,k,l);
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

}
