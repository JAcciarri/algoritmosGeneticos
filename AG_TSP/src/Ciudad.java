
public class Ciudad {
	
	// POR AHORA NO SE USARIA, NO TIENE SENTIDO
	
	
	private int idCiudad;
	private String nombreCiudad;
	private String provincia;
	private int distanciaHasta;
	
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public Ciudad(String ciudad) {
		this.nombreCiudad = ciudad;
	}
	public Ciudad(String ciudad, String provincia, int distancia) {
		this.nombreCiudad = ciudad;
		this.provincia = provincia;
		this.distanciaHasta = distancia;
	}
	public int getDistanciaHasta() {
		return distanciaHasta;
	}
	public void setDistanciaHasta(int distanciaHasta) {
		this.distanciaHasta = distanciaHasta;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
}
