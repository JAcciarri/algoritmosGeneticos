package geneticos;

import java.util.ArrayList;
import ag.Ciudades;

public class Principal {

	static int longPoblacion = 4;
	static int longCromosoma = 24;
	static int[] distancias = new int[longCromosoma];
	static ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();
	
	public static void main(String[] args) {
		
		crearPoblacionInicial();
		Ciudades.crearMatriz();
		
		for (int i= 0;  i < longPoblacion; i++) {
			int localDistancia = 0;
			for (int j = 0; j < longCromosoma; j++) {
				
				//getDistanciaBetween es un metodo estatico de Ciudades que devuelve la distancia dadas
				// dos ciudades como parametros, estas se obtienen de la poblacion inicial.
				
				 localDistancia = localDistancia + Ciudades.getDistanciaBetween(
								poblacion.get(i).getCiudadesCromosoma().get(i), 
								poblacion.get(i).getCiudadesCromosoma().get(j));
			}
			poblacion.get(i).setDistTotal(localDistancia);
		}
		
		evaluarFitness();
		
		//imprimir poblacion inicial
		for (Cromosoma cr : poblacion) {
			int index = poblacion.indexOf(cr);
			System.out.println("Cromosoma " + index + ": " + cr.toString() +
							   "- Distancia: "+ cr.getDistTotal()+ 
							   "- Fitness: " + cr.getFitness());
		}
	
		
	}
	
	static void evaluarFitness() {
		int summ = 0;
		double sumfit = 0;
		for (Cromosoma cr : poblacion) {
			summ+=cr.getDistTotal();
		}
		// LA FUNCION OBJETIVO ES LA DIFERENCIA ENTRE EL TOTAL DE KM Y LA QUE RECORRIO CADA CROMOSOMA,
		// ESO DIVIDIDO POR LA SUMATORIA MULTIPLICADO POR LA CANT DE CROMOSOMAS MENOS UNO
		for(Cromosoma cr : poblacion) {
			cr.setFitness( ((double)summ - cr.getDistTotal())  /  ((double)summ * (longPoblacion-1)));
			sumfit += cr.getFitness();
		}
		System.out.println("Suma total de distancias: " + summ);
		System.out.println("Sumatoria fitness: " + sumfit);
	}
	
	//LLENAR CROMOSOMA ES UN METODO PROPIO DE CADA CROMOSOMA QUE LLENA ALEATORIAMENTE LAS 24 CIUDADES
	static void crearPoblacionInicial() {
		for (int i = 0; i < longPoblacion; i++) {
	           poblacion.add(new Cromosoma());
	           poblacion.get(i).llenarCromosoma();
		}
	}
}
