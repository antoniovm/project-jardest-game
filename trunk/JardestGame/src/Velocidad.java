import java.awt.Dimension;


public class Velocidad {
	
	private double i,j;		//Coordenadas rectangulares
	private double modulo, angulo;	//Coordenadas Plares
	
	
	public Velocidad() {
		this.i=0;
		this.j=0;
	}
	/*public Velocidad(double i, double j) {
		this.i=i;
		this.j=j;
	}*/
	
	public Velocidad(double modulo, double angulo) {
		this.modulo=modulo;
		this.angulo=angulo;
		polaresRectangulares();
	}
	
	public Punto mover(double dt){
		return new Punto((i*dt),(j*dt));
	}
	
	void setComponentes(double i, double j) {
		this.i=i;
		this.j=j;
		rectangulasresPolares();
	}
	public double getI() {
		return i;
	}
	public void setI(double i) {
		this.i = i;
		rectangulasresPolares();
	}
	public double getJ() {
		return j;
	}
	public void setJ(double j) {
		this.j = j;
		rectangulasresPolares();
	}
	
	public void cambiarSentido(){
		i=-i;
		j=-j;
		rectangulasresPolares();
	}
	
	private void rectangulasresPolares() {
		modulo = Math.sqrt(i*i+j*j);	//Pitagoras (Hipotenusa)
		angulo = Math.atan2(i, j);		

	}
	
	private void polaresRectangulares() {
		i = Math.cos(angulo)*modulo;
		j = Math.sin(angulo)*modulo;

	}
	
	@Override
	public String toString() {
		return "Rect: "+"("+i+","+j+")\nPol: "+"("+modulo+","+angulo+")";
	}

}
