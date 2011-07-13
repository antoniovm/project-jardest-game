package juego;

import java.awt.Dimension;

public class Geometria {
	private char[][] matriz;
	private int sizeLosa, i, j;
	
	Geometria(Dimension sizePanel, int sizeLosa){
		this.sizeLosa = sizeLosa;
		this.matriz = new char[sizePanel.width/sizeLosa][sizePanel.height/sizeLosa];
		
		crearNivel();
	}
	
	private void crearNivel() {
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j<matriz[0].length; j++){
				if(i==0 || i==1 || i==2)
					matriz[i][j] = '2'; //zona segura inicial
				if(i==3){
					if(j==9)
						matriz[i][j] = '1';
					else
						matriz[i][j] = '0';
				}
				if(i==4){
					if(j==0)
						matriz[i][j] = '0';
					else
						matriz[i][j] = '1';
				}
				if(i==5 || i==6 || i==7 || i==8 || i==9 || i==10){
					if(j==0 || j==9)
						matriz[i][j] = '0';
					else
						matriz[i][j] = '1';
				}
				if(i==11){
					if(j==9)
						matriz[i][j] = '0';
					else
						matriz[i][j] = '1';
				}
				if(i==12){
					if(j==0)
						matriz[i][j] = '1';
					else
						matriz[i][j] = '0';
				}
				if(i==13 || i==14 || i==15){
					matriz[i][j] = '3'; //zona de meta
				}
			}
		}
		
	}

	public boolean esValido(Punto punto1, Punto punto2){
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
