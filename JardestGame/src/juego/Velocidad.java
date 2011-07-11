package juego;


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
	
	public double getModulo() {
		return modulo;
	}

	public void setModulo(double modulo) {
		this.modulo = modulo;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	/**
	 * Constructor en coordenadas polares
	 * @param modulo	El modulo de la velocidad
	 * @param angulo	El angulo respecto al eje OX
	 */
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
	/**
	 * Cambia el sentido del vector
	 */
	public void cambiarSentido(){
		i=-i;
		j=-j;
		rectangulasresPolares();
	}
	/**
	 * Pasa de coordenadas rectangulares a coordenadas polares
	 */
	private void rectangulasresPolares() {
		modulo = Math.sqrt(i*i+j*j);	//Pitagoras (Hipotenusa)
		angulo = Math.atan2(i, j);		

	}
	/**
	 * Pasa de coordenadas polares a coordenadas rectangulares
	 */
	private void polaresRectangulares() {
		i = Math.cos(angulo)*modulo;
		j = Math.sin(angulo)*modulo;

	}
	
	/**
	 * Cambia la direccion del vector, en funcion del rebote
	 * @param s	La componente del vector que cambia de sentido
	 */
	public void rebote(String s) {
		if(s.equals("i")){
			i=-i;
			rectangulasresPolares();
			return;
		}
		if(s.equals("j")){
			j=-j;
			rectangulasresPolares();
			return;
		}

	}
	
	@Override
	public String toString() {
		return "Rect: "+"("+i+","+j+")\nPol: "+"("+modulo+","+angulo+")";
	}

}
