package juego;

import java.awt.Dimension;

public class Geometria {
	private byte[][] matriz = {{2,2,2,0,0,0,0,0,0,0,0,0,0,1,1,3,3,3},
							   {2,2,2,0,1,1,1,1,1,1,1,1,1,1,0,3,3,3},
							   {2,2,2,0,1,1,1,1,1,1,1,1,1,1,0,3,3,3},
							   {2,2,2,0,1,1,1,1,1,1,1,1,1,1,0,3,3,3},
							   {2,2,2,0,1,1,1,1,1,1,1,1,1,1,0,3,3,3},
							   {2,2,2,1,1,0,0,0,0,0,0,0,0,0,0,3,3,3}};
	private int sizeLosa, i, j;
	
	Geometria(Dimension sizePanel, int sizeLosa){
		this.sizeLosa = sizeLosa;
		//this.matriz = new byte[sizePanel.height/sizeLosa][sizePanel.width/sizeLosa];
		
		//crearNivel();
	}
	
	private void crearNivel() {
		for(int j=0; j<matriz[0].length; j++){
			for(int i=0; i<matriz.length; i++){
				if(j==0 || j==1 || j==2)
					matriz[i][j] = 2; //zona segura inicial
				if(j==3){
					if(i==9)
						matriz[i][j] = 1;
					else
						matriz[i][j] = 0;
				}
				if(j==4){
					if(i==0)
						matriz[i][j] = 0;
					else
						matriz[i][j] = 1;
				}
				if(j==5 || j==6 || j==7 || j==8 || j==9 || j==10){
					if(i==0 || i==9)
						matriz[i][j] = 0;
					else
						matriz[i][j] = 1;
				}
				if(j==11){
					if(i==9)
						matriz[i][j] = 0;
					else
						matriz[i][j] = 1;
				}
				if(j==12){
					if(i==0)
						matriz[i][j] = 1;
					else
						matriz[i][j] = 0;
				}
				if(j==13 || j==14 || j==15){
					matriz[i][j] = 3; //zona de meta
				}
			}
		}
		
	}

	public boolean esValido(Punto punto1, Punto punto2){
		i = (int)punto1.getY()/sizeLosa; //filas
		j = (int)punto1.getX()/sizeLosa; //columnas
		
		//si se supera el maximo tamaño de la matriz (colision pared derecha o inferior)
		if(i > matriz.length || j > matriz[0].length){
			i = matriz.length;
			j = matriz[0].length;
			return false;
		}
		
		//colision pared izquierda o superior
		if(i < 0 || j < 0){
			i = 0;
			j = 0;
			return false;
		}
		
		//losa no valida (la forma del nivel)
		if(matriz[i][j] == 0)
			return false;
		
		i = (int)punto2.getY()/sizeLosa;
		j = (int)punto2.getX()/sizeLosa;
		
		if(i > matriz.length || j >= matriz[0].length){
			i = matriz.length;
			j = matriz[0].length;
			return false;
		}
		
		if(i < 0 || j < 0){
			i = 0;
			j = 0;
			return false;
		}
		
		if(matriz[i][j] == 0)
			return false;
		
		return true;
	}
	
	public int getParedIzq(){
		return i*sizeLosa; //devuelve arista izquierda de la losa
	}
	
	public int getParedSup(){
		return j*sizeLosa; //devuelve arista izquierda de la losa
	}
	
	public byte [][] getMatriz(){
		return matriz;
	}
	
	public int getAncho(){
		return matriz[0].length;
	}
	
	public int getAlto(){
		return matriz.length;
	}
	
	public byte getElemento(int i, int j){
		return matriz[i][j];
	}
	
	public int getLosa(){
		return sizeLosa;
	}
	
	@Override
	public String toString() {
		return matriz.toString();
	}

}
