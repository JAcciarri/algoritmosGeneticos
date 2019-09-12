package ag;


import javax.swing.JOptionPane;

public class Principal {

	 static String[] ciudades = Ciudades.getCiudades();
	 static String[] recorrido = new String[ciudades.length];
	 static int distanciaTotal = 0;
	 static int r=1;
	 
	public static void main(String[] args) {
		
		Ciudades.crearMatriz();
		String ciudadElegida = (JOptionPane.showInputDialog(null, "Elegir la provincia"));
		Ciudades.encontrarCiudadInicial(ciudadElegida);
		recorrido[0]=ciudadElegida;
		String nextCiudad = ciudadElegida;
		
		for (int i = 0; i<ciudades.length-1; i++) {
			Celda cell = Ciudades.encontrarProximaCiudad(nextCiudad);
			nextCiudad = (cell.getCiudadHasta());
			recorrido[r] = nextCiudad;  r++;
			distanciaTotal += cell.getDistanciaEntreAmbas();
		}
		
		distanciaTotal = distanciaTotal + Ciudades.volverAlInicio(ciudadElegida, recorrido[ciudades.length-1]);

		System.out.println("Ciudad de inicio: " + ciudadElegida +"\nRecorrido: ");
		for (int i = 0; i < ciudades.length; i++) {
			System.out.println(" " +i+ "-" + recorrido[i]);
		}
		System.out.println("\nDistancia total: " +distanciaTotal);		   
		
	}
	
	
	
	
}
