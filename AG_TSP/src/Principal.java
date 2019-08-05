import java.util.ArrayList;

public class Principal {

	private static String[] ciudades = crearCiudades();
	private static Celda[][] matrizCiudades = inicializarMatriz();
	
	public static void main(String[] args) {
		
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				if(j==4)
				System.out.print(matrizCiudades[i][j].getDistanciaEntreAmbas()+"\n");
				else System.out.print(matrizCiudades[i][j].getDistanciaEntreAmbas()+" ");
			}
		}
	}

	public static Celda[][] inicializarMatriz(){
		Celda[][] matriz = new Celda[5][5];
		
		/// Buenos Aires
		matriz[0][0] = new Celda(ciudades[0], ciudades[0], 0);
		matriz[0][1] = new Celda(ciudades[0], ciudades[1], 646);
		matriz[0][2] = new Celda(ciudades[0], ciudades[2], 792);
		matriz[0][3] = new Celda(ciudades[0], ciudades[3], 933);
		matriz[0][4] = new Celda(ciudades[0], ciudades[4], 53);
			
				matriz[1][0] = new Celda(ciudades[1], ciudades[0], 646);
				matriz[2][0] = new Celda(ciudades[2], ciudades[0], 792);
				matriz[3][0] = new Celda(ciudades[3], ciudades[0], 933);
				matriz[4][0] = new Celda(ciudades[4], ciudades[0], 53);
	
		/// Cordoba
		matriz[1][1] = new Celda(ciudades[1], ciudades[1], 0);
		matriz[1][2] = new Celda(ciudades[1], ciudades[2], 677);
		matriz[1][3] = new Celda(ciudades[1], ciudades[3], 824);
		matriz[1][4] = new Celda(ciudades[1], ciudades[4], 698);
		
			matriz[2][1] = new Celda(ciudades[2], ciudades[1], 677);
			matriz[3][1] = new Celda(ciudades[3], ciudades[1], 824);
			matriz[4][1] = new Celda(ciudades[4], ciudades[1], 698);
		
		/// Corrientes	
		matriz[2][2] = new Celda(ciudades[2], ciudades[2], 0);
		matriz[2][3] = new Celda(ciudades[2], ciudades[3], 157);
		matriz[2][4] = new Celda(ciudades[2], ciudades[4], 830);
			matriz[3][2] = new Celda(ciudades[3], ciudades[2], 157);
			matriz[4][2] = new Celda(ciudades[4], ciudades[2], 830);
			
		// Formosa
			matriz[3][3] = new Celda(ciudades[2], ciudades[3], 0);
			matriz[3][4] = new Celda(ciudades[3], ciudades[4], 968);
				matriz[4][3] = new Celda(ciudades[4], ciudades[3], 968);
		
		// La Plata
			matriz[4][4] = new Celda(ciudades[4], ciudades[4], 0);
			
		return matriz;
	}
	
	public static String[] crearCiudades() {
		String[] ciudades = new String[5];
		ciudades[0] = ("Cdad de Buenos Aires");
		ciudades[1] = ("Cordoba");
		ciudades[2] = ("Corrientes");
		ciudades[3] = ("Formosa");
		ciudades[4] = ("La Plata");
		return ciudades;
		
	}
	
}
