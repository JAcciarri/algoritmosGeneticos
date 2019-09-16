package geneticos;

import java.util.ArrayList;
//import ag.Ciudades;

public class Principal {

	static int longPoblacion = 50;
	static int longCromosoma = 24;
	static double probCrossover=0.75;
	static double probMutacion=0.05;
	static int[] pool = new int[100];
	static int[] distancias = new int[longCromosoma];
	static ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();
	static ArrayList<Cromosoma> poblacionAuxiliar = new ArrayList<Cromosoma>();
	static int padres[] = new int[longPoblacion];
	static Cromosoma padre2=new Cromosoma();
	static Cromosoma padre1=new Cromosoma();
	static Cromosoma hijo1=new Cromosoma();
	static Cromosoma hijo2=new Cromosoma();
	
	
	public static void main(String[] args) {
		
		crearPoblacionInicial();
		Ciudades.crearMatriz();
		
		for (int i= 0;  i < longPoblacion; i++) {
			int localDistancia = 0;
			for (int j = 0; j < 23; j++) {
				
				//getDistanciaBetween es un metodo estatico de Ciudades que devuelve la distancia dadas
				// dos ciudades como parametros, estas se obtienen de la poblacion inicial.
				
				 localDistancia = localDistancia + Ciudades.getDistanciaBetween(
								poblacion.get(i).getCiudadesCromosoma().get(j), 
								poblacion.get(i).getCiudadesCromosoma().get(j+1));
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
		
		generarPool();
		determinarPadres();
		crossoverCiclico();
	
		
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
	
	static void generarPool(){
		int actualPos=0;
		for (int i=0; i<longPoblacion; i++) {
			
				for (int posibilidades=0; posibilidades<(int)(Math.round(poblacion.get(i).getFitness()*100)); posibilidades++) {
					if (actualPos==100) break; 
					else {
						pool[actualPos]=i;
						actualPos++;
						}
				}
		}
	}
	
	static void determinarPadres(){
		
		for (int i=0; i<longPoblacion; i++) {
			padres[i] = pool[(int)(Math.random()*100)]; //padres me guarda los indices de la pool que son los indices de poblacion
		}
	}
	
	static void crossoverCiclico() {
		for (int parejas=0; parejas<longPoblacion; parejas+=2) {			
			int hacerCrossover = (int)(Math.random()*101); //¿HACER O NO EL CROSSOVER?//
			padre1 = poblacion.get(padres[parejas]);
			padre2 = poblacion.get(padres[parejas+1]);
			if (hacerCrossover<=(int)(probCrossover*100)) {
				int pos1=0; 
				int pos2=0; 
				poblacionAuxiliar.add(parejas, new Cromosoma());
				poblacionAuxiliar.add(parejas+1, new Cromosoma()); 				
				hijo1=poblacionAuxiliar.get(parejas);
				hijo2=poblacionAuxiliar.get(parejas+1);
				hijo1.agregarCiudad(pos1, padre1);
				hijo2.agregarCiudad(pos2, padre2);
				pos1=padre1.buscarGen(pos1, padre2);//esta la uso para el hijo 1
				pos2=padre1.buscarGen(pos2, padre2);//esta la uso para el hijo 2
				//segundo hago ciclico el resto de las posiciones - HIJO 1
				//arranca en 1 porque la pos en 0 ya la llene
				for (int i=1; i<longCromosoma-1; i++) {					
					if(hijo1.yaExiste(pos1, padre2)) {
						break; //se termina el crossover, no se si esta bien este break pero si esto es true se tiene que terminar
						}else{
							hijo1.agregarCiudad(pos1, padre1); 
							pos1=padre1.buscarGen(pos1, padre2);							
						}
					}
				//cuando sale por el break o porque ya completo todos, rellena el resto de los genes que quedaron vacios
				for (int i=0;i<longCromosoma;i++) {
					if (hijo1.genVacio(i)) {
						hijo1.agregarCiudad(i, padre2);
					}
				}
				
				//HIJO 2
				for (int i=1; i<longCromosoma-1; i++) {					
					if(hijo2.yaExiste(pos2, padre1)) {
						break; //se termina el crossover, no se si esta bien este break pero si esto es true se tiene que terminar
						}else{							
							hijo2.agregarCiudad(pos2, padre2); 
							pos2=padre2.buscarGen(pos2, padre1);							
						}
					}
				//cuando sale por el break o porque ya completo todos, rellena el resto de los genes que quedaron vacios
				for (int i=0;i<longCromosoma;i++) {
					if (hijo2.genVacio(i)) {
						hijo2.agregarCiudad(i, padre1);
					}
				}
			
				}else { //copio los padres tal cual
					poblacionAuxiliar.add(padre1);
					poblacionAuxiliar.add(padre2);
					
					
				}
			}
				
	}
	
	//mutacion
	//traspasar poblacion
	
}
