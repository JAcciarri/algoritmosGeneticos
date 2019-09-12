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
		for (int i = 0; i< 24; i++) {
			do {
				numRandom = random.nextInt(24);
			} while(this.ciudadesCromosoma.contains(numRandom));
			this.ciudadesCromosoma.add(numRandom);
		}
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
	
	}

