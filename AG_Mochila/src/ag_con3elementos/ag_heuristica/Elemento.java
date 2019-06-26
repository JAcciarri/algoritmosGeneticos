package ag_heuristica;

public class Elemento implements Comparable<Elemento>{

	private int idElemento;
	private int volumen;
	private int valor;
	private double fitness;
	
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public int getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public Elemento(int idElem, int vol, int val) {
		this.idElemento = idElem;
		this.volumen = vol;
		this.valor = val;
	}
	
	@Override
	public int compareTo(Elemento o) {
		if (fitness > o.fitness) return -1;
		if (fitness < o.fitness) return 1;
		return 0;
	}
	
}
