package juego;

import java.awt.Dimension;

public class Geometria {
	private char[][] matriz;
	private int sizeLosa, i, j;
	
	Geometria(Dimension sizePanel, int sizeLosa){
		this.sizeLosa = sizeLosa;
		this.matriz = new char[sizePanel.height/sizeLosa][sizePanel.width/sizeLosa];
		
		/*for(int j=0; j<matriz.length; j++){
			for(int i=0; i<matriz[0].length; i++){
				if(j==0)
					matriz[i][j] = 0;
			}
		}*/
	}
	
	public boolean getValido(Punto punto1, Punto punto2){
		i = (int)punto1.getX()/sizeLosa;
		j = (int)punto1.getY()/sizeLosa;
		
		if(matriz[i][j] == 0)
			return false;
		
		i = (int)punto2.getX()/sizeLosa;
		j = (int)punto2.getY()/sizeLosa;
		
		if(matriz[i][j] == 0)
			return false;
		
		return true;
	}
	
	public int getPared(){
		return i*sizeLosa;
	}
	
	public char[][] getMatriz(){
		return matriz;
	}
	
	public int getLosa(){
		return sizeLosa;
	}

}
