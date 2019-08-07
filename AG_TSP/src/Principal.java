import java.util.ArrayList;

public class Principal {

	private static String[] ciudades = Ciudades.getCiudades();
	private static Celda[][] matrizCiudades = Ciudades.getMatriz();
	
	public static void main(String[] args) {
		
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				if(j==4)
				System.out.print(matrizCiudades[i][j].getDistanciaEntreAmbas()+"\n");
				else System.out.print(matrizCiudades[i][j].getDistanciaEntreAmbas()+" ");
			}
		}
	}

	
	
}
