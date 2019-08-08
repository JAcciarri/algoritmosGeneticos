import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	 static String[] ciudades = Ciudades.getCiudades();
	 static Celda[][] matrizCiudades;
	 static String[] recorrido = new String[ciudades.length];
	
	public static void main(String[] args) {
		
		/*
		int r=1;
		String provElegida = (JOptionPane.showInputDialog(null, "Elegir la provincia"));
		int minimaDistancia = 10000;
		
		
	    for (int j=0; j<ciudades.length; j++) {
			if (ciudades[j].equalsIgnoreCase(provElegida)) {
					for (int k=0; k<ciudades.length; k++) {
						if (j!=k && matrizCiudades[j][k].getDistanciaEntreAmbas() < minimaDistancia )
							minimaDistancia = matrizCiudades[j][k].getDistanciaEntreAmbas();
					}
				 
				
			}
	    }
		for (int i=0; i<ciudades.length-1; i++) {
			
		}
			*/
		Ciudades.crearMatriz();
		matrizCiudades = Ciudades.getMatriz();
		
		for (int i = 0; i < ciudades.length; i++) {
			for (int j = 0; j < ciudades.length; j++) {
				if(j==ciudades.length-1)
				System.out.print(matrizCiudades[i][j].getDistanciaEntreAmbas()+"\n");
				else System.out.print(matrizCiudades[i][j].getDistanciaEntreAmbas()+" ");
			}
		}
	}
	
	
	
	
}
