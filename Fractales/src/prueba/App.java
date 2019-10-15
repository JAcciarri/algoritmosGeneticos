package prueba;

import java.util.ArrayList;

public class App {

	static ArrayList<Character> linea = new ArrayList<Character>(99);
	static int longitud = 81;  //longitud de la linea
	static int cantidadNiveles = 5;   //cantidad de veces a llamar a la recursividad
	
	public static void main(String[] args) {
		
		//creo el array de caracteres _
		for (int i = 0; i <= longitud; i++) {
			linea.add('_');
		}
		for (Character c : linea) System.out.print(c);
		System.out.println();
		
		// llamo la primera vez con nivel igual a 1 ...
		cut(1);
	
	}
	
	
	static void cut(int nivel) {
		for (int i = longitud/(int)Math.pow(3, nivel);
				 i < (longitud*2) / (int)Math.pow(3, nivel); 
				 i++) 
			{
				linea.set(i, ' ');
			}
		
		for (int i = longitud - (longitud * 2 / (int)Math.pow(3, nivel));
				 i < longitud - (longitud / (int)Math.pow(3, nivel)); 
				 i++) 
			{
				linea.set(i, ' ');
			}
		
		System.out.println();
		for (Character c : linea) System.out.print(c);
		
		if(nivel != cantidadNiveles) {
			//llamo a la recursividad
			cut(++nivel);
			} 
	}
}
