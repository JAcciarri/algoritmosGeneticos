package geneticos;

import java.util.ArrayList;
import ag.Ciudades;

public class Principal {

	static int longPoblacion = 10;
	static int longCromosoma = 24;
	static int[] distancias = new int[longCromosoma];
	static ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();
	
	public static void main(String[] args) {
		
		crearPoblacionInicial();
		Ciudades.crearMatriz();
		
		for (int i= 0;  i < longPoblacion; i++) {
			int localDistancia = 0;
			for (int j = 0; j < longCromosoma; j++) {
				 localDistancia = localDistancia + Ciudades.getDistanciaBetween(
								poblacion.get(i).getCiudadesCromosoma().get(i), 
								poblacion.get(i).getCiudadesCromosoma().get(j));
			}
			distancias[i] = localDistancia;
		}
		
	
		
		System.out.println("Poblacion inicial y lpm");
		for (Cromosoma cr : poblacion) {
			int index = poblacion.indexOf(cr);
			System.out.println("Cromosoma " + index + ":   " + cr.toString() + " - Distancia: "+ distancias[index] );
		}
		
	}
	
	
	static void crearPoblacionInicial() {
		for (int i = 0; i < longPoblacion; i++) {
	           poblacion.add(new Cromosoma());
	           poblacion.get(i).llenarCromosoma();
		}
	}
}
