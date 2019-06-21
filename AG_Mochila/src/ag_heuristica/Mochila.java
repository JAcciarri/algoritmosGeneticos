package ag_heuristica;

import java.util.ArrayList;

public class Mochila {

	private int capacidad;
    ArrayList<Elemento> elementosMochila = new ArrayList<Elemento>();
    
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public int getVolumenOcupado() {
		int acum = 0;
		for (Elemento e : elementosMochila) {
			acum = acum + e.getVolumen();
		}
		return acum;
	}
			
	
}
	
