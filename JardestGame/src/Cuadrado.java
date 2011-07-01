

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cuadrado{
	private int altura;
	private int mitadAltura;
	private int x;
	private int y;
	private Rectangle rect;
	private Graphics grafico;
	
	Cuadrado(){
		this.altura = 20;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		rect=new Rectangle(x,y,mitadAltura,mitadAltura);
	}
	
	Cuadrado(int altura){
		this.altura = altura;
		this.mitadAltura = altura/2;
		this.x=0;
		this.y=200;
		rect=new Rectangle(x,y,mitadAltura,mitadAltura);
	}
	
	public void desplazar(int dx, int dy){
		rect.translate(dx, dy);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(rect.x, rect.y, mitadAltura, mitadAltura);
	}
}
