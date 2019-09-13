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
	
	//JOSHUA HICE DE ACA PARA ABAJO
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
	
	static void crossoverCiclico() { //est[a llenando solo el hijo 1 siguiendo el ciclo, falta hijo2 
		for (int parejas=0; parejas<longPoblacion; parejas+=2) {
			
			int hacerCrossover = (int)(Math.random()*101); //¿HACER O NO EL CROSSOVER?//
			if (hacerCrossover<=(int)(probCrossover*100)) {
				int posN = 0;
				int pos=0; 
				//primero guardo en el primer gen del hijo1 el primer gen del padre 1
				poblacionAuxiliar.add(new Cromosoma());//hijo 1 en posicion:parejas
				padre1 = poblacion.get(padres[parejas]);
				padre2 = poblacion.get(padres[parejas+1]);
				poblacionAuxiliar.get(parejas).agregarCiudad(posN, pos, padre1); //mando las 2 posiciones y el cromosoma del padre
				//segundo hago ciclico el resto de las posiciones
				//arranca en 1 porque la pos0 ya la llene
				for (int i=1; i<longCromosoma; i++) {					
					if(poblacionAuxiliar.get(parejas).yaExiste(posN, padre2)) {
						break; //se termina el crossover, no se si esta bien este break pero si esto es true se tiene que terminar
						}else{
							pos=posN;
							posN=padre1.buscarGen(pos, padre2);
							poblacionAuxiliar.get(parejas).agregarCiudad(posN, pos, padre2);
							
						}
					}
				//cuando sale por el break o porque ya completo todos, rellena el resto de los genes que quedaron vacios
				for (int i=0;i<longCromosoma;i++) {
					if (poblacionAuxiliar.get(parejas).genVacio(i)) {
						poblacionAuxiliar.get(parejas).agregarCiudad(i, i, padre2);
					}
				}
				
			
			
				}else {//paso los padres como estaban
					
				}
			}
				
	}
	
	
}
