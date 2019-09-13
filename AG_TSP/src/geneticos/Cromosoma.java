package geneticos;


import java.util.ArrayList;
import java.util.Random;

public class Cromosoma {
	
	private ArrayList<Integer> ciudadesCromosoma;
	int distTotal;
	double fitness;

	
	public Cromosoma() {
		this.ciudadesCromosoma = new ArrayList<Integer>(24);
	}
	
	public ArrayList<Integer> getCiudadesCromosoma() {
		return ciudadesCromosoma;
	}

	public void setCiudadesCromosoma(ArrayList<Integer> ciudadesCromosoma) {
		this.ciudadesCromosoma = ciudadesCromosoma;
	}

	public void llenarCromosoma() {
	
		Random random = new Random();
		int numRandom;
		for (int i = 0; i< 24; i++) { //ciudades cromosoma son los numeros de los genes que representan las ciudades
			do {
				numRandom = random.nextInt(24);
			} while(this.ciudadesCromosoma.contains(numRandom));
			this.ciudadesCromosoma.add(numRandom);
		}
	}
	
	//agregue agregarCiudad, yaExiste, buscarGen, genVacio
	public void agregarCiudad(int i, int j, Cromosoma padre) {//recibo las 2 posiciones, el cromosoma del padre y agrego a this en la primer
		int k = padre.ciudadesCromosoma.get(j); //posicion al gen del padre en la 2da posicion
		this.ciudadesCromosoma.add(i, k);
	}
	
	public boolean yaExiste (int j, Cromosoma padre2) {
		int k=padre2.ciudadesCromosoma.get(j);
		return (this.ciudadesCromosoma.contains(k));
	}
	
	public int buscarGen (int i, Cromosoma padre2) {
		int k=padre2.ciudadesCromosoma.get(i);
		return k;
	}
	
	public boolean genVacio (int i) {
		Integer gen = this.ciudadesCromosoma.get(i);
		return (gen == 0);
	}
	
	@Override 
	public String toString(){
		String cromosoma = "";
		for (Integer i : ciudadesCromosoma) {
			cromosoma = cromosoma + (i) + " ";
		}
		return cromosoma;
	}

	public int getDistTotal() {
		return distTotal;
	}

	public void setDistTotal(int distTotal) {
		this.distTotal = distTotal;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
