
package ag_exhaustiva;

public class Elemento {
 
    private int volumen;
    private int beneficio;

    public Elemento(int volumen, int beneficio) {
        this.volumen = volumen;
        this.beneficio = beneficio;
    }



    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (this.volumen != other.volumen) {
            return false;
        }
        if (this.beneficio != other.beneficio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Volumen total :"+volumen+","+" beneficio total:"+beneficio;
    }

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
    
    
}
