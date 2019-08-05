
public class Celda {

	private String ciudadDesde;
	private String ciudadHasta;
	private int distanciaEntreAmbas;
	
	public Celda(String cDesde, String cHasta, int distancia) {
		this.ciudadDesde = cDesde;
		this.ciudadHasta = cHasta;
		this.distanciaEntreAmbas = distancia;
	}
	
	public String getCiudadDesde() {
		return ciudadDesde;
	}
	public void setCiudadDesde(String ciudadDesde) {
		this.ciudadDesde = ciudadDesde;
	}
	public String getCiudadHasta() {
		return ciudadHasta;
	}
	public void setCiudadHasta(String ciudadHasta) {
		this.ciudadHasta = ciudadHasta;
	}
	public int getDistanciaEntreAmbas() {
		return distanciaEntreAmbas;
	}
	public void setDistanciaEntreAmbas(int distanciaEntreAmbas) {
		this.distanciaEntreAmbas = distanciaEntreAmbas;
	}
}
