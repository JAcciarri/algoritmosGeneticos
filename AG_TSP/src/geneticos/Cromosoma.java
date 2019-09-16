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
	
	public void agregarCiudad(int i, Cromosoma padre) {
		int k = padre.ciudadesCromosoma.get(i); 
		this.ciudadesCromosoma.add(i, k);
	}
	
	public boolean yaExiste (int j, Cromosoma padre2) {
		int k=padre2.ciudadesCromosoma.get(j);
		return (this.ciudadesCromosoma.contains(k));
	}
	
	public int buscarGen(int i, Cromosoma padre2){
		int posNueva=0;
		int k=padre2.ciudadesCromosoma.get(i);//guardo el numero que hay en padre 2 en pos
	    for (int j = 0; j < padre2.ciudadesCromosoma.size(); j++) {//busco la posicion en la cual esta k en padre 1
	        if (this.ciudadesCromosoma.get(j).equals(k)) {
	            posNueva=j;
	            break;
	        }
	    }
	    return posNueva;
	}

	
	public boolean genVacio (int i) {
		int gen = this.ciudadesCromosoma.get(i);
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
	
	}
