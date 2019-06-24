
package ag_exhaustiva;

public class Mochila {
	
	private int capacidadMaxima;
    private int capacidadOcupada;
    private int beneficio;
    private Elemento[] elementos;
    
    
    public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getCapacidadOcupada() {
		return capacidadOcupada;
	}

	public void setCapacidadOcupada(int capacidadOcupada) {
		this.capacidadOcupada = capacidadOcupada;
	}

	public int getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}

	public void setElementos(Elemento[] elementos) {
		this.elementos = elementos;
	}

	public Mochila(int capMax) {
		this.capacidadMaxima = capMax;
		this.beneficio = 0;
		this.capacidadOcupada = 0;
	}
    public Mochila(int capMax, int numElementos) {
        this.capacidadMaxima = capMax;
        this.elementos = new Elemento[numElementos];
        this.beneficio = 0;
        this.capacidadOcupada = 0;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    
    public void agregarElemento(Elemento e) {

        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e; //lo añade
                this.beneficio+=e.getBeneficio(); // aumenta el beneficio
                this.capacidadOcupada+=e.getVolumen(); // Aumenta el piso
                break;
            }
        }

    }


    public void vaciarMochila() {
        this.capacidadOcupada=0;
        this.beneficio=0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }


    public void eliminarElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i].equals(e)) {
                this.elementos[i] = null; //el elemento fuera
                this.capacidadOcupada-=e.getVolumen(); //Reduce el peso
                this.beneficio-=e.getBeneficio(); // reduce el beneficio
                break;
            }
        }
    }
    
    public boolean existeElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


}
