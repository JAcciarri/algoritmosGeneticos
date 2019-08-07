
public class Ciudades {
	
	private static Celda[][] matriz = new Celda[23][23];
	private static String[] ciudades = {
	("Cdad de Buenos Aires"),
	("Cordoba"),
	("Corrientes"),
	("Formosa"),
	("La Plata"),
	("La Rioja"),
	("Mendoza"),
	("Neuquen")};
	
	public static void main(String args[]) {


		//Todas contra todas (Solo nombres)
		
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 24; j++) {
				matriz[i][j] = new Celda(ciudades[i], ciudades[j]);
			}
		}
		
		//Distancias diagonales (=0)
		for (int k=0; k<24; k++) {
			matriz[k][k].setDistanciaEntreAmbas(0);
		}
		
	
		//Todas las distancias Ushuaia
		matriz[22][23].setDistanciaEntreAmbas(1605); matriz[23][22].setDistanciaEntreAmbas(1605);
		
		//Todas las distancias Stgo del Estero
		matriz[21][22].setDistanciaEntreAmbas(3016); matriz[22][21].setDistanciaEntreAmbas(3016);
		matriz[21][23].setDistanciaEntreAmbas(1446); matriz[23][21].setDistanciaEntreAmbas(1446);
		
		//Todas las distancias Santa Rosa
		matriz[20][21].setDistanciaEntreAmbas(977); matriz[21][20].setDistanciaEntreAmbas(977);
		matriz[20][22].setDistanciaEntreAmbas(2044); matriz[22][20].setDistanciaEntreAmbas(2044);
		matriz[20][23].setDistanciaEntreAmbas(477); matriz[23][20].setDistanciaEntreAmbas(477);
		
		//Todas las distancias Santa Fe
		matriz[19][20].setDistanciaEntreAmbas(641); matriz[20][19].setDistanciaEntreAmbas(641);
		matriz[19][21].setDistanciaEntreAmbas(547); matriz[21][19].setDistanciaEntreAmbas(547);
		matriz[19][22].setDistanciaEntreAmbas(2641); matriz[22][19].setDistanciaEntreAmbas(2641);
		matriz[19][23].setDistanciaEntreAmbas(1035); matriz[23][19].setDistanciaEntreAmbas(1035);
		
		
		
		// .... y asi aumentando cada vez 1 fila hasta llegar a buenos aires, la ultima de todas
		
		
		
		//Todas las distancias Ciudad de Buenos aires
		matriz[0][1].setDistanciaEntreAmbas(646); matriz[1][0].setDistanciaEntreAmbas(646);
		matriz[0][2].setDistanciaEntreAmbas(792); matriz[2][0].setDistanciaEntreAmbas(792);
		matriz[0][3].setDistanciaEntreAmbas(933); matriz[3][0].setDistanciaEntreAmbas(933);
		matriz[0][4].setDistanciaEntreAmbas(53); matriz[4][0].setDistanciaEntreAmbas(53);
		matriz[0][5].setDistanciaEntreAmbas(986); matriz[5][0].setDistanciaEntreAmbas(986);
		matriz[0][6].setDistanciaEntreAmbas(985); matriz[6][0].setDistanciaEntreAmbas(985);
		matriz[0][7].setDistanciaEntreAmbas(989); matriz[7][0].setDistanciaEntreAmbas(989);
		matriz[0][8].setDistanciaEntreAmbas(375); matriz[8][0].setDistanciaEntreAmbas(375);
		matriz[0][9].setDistanciaEntreAmbas(834); matriz[9][0].setDistanciaEntreAmbas(834);
		matriz[0][10].setDistanciaEntreAmbas(1127); matriz[10][0].setDistanciaEntreAmbas(1127);
		matriz[0][11].setDistanciaEntreAmbas(794); matriz[11][0].setDistanciaEntreAmbas(794);
		matriz[0][12].setDistanciaEntreAmbas(2082); matriz[12][0].setDistanciaEntreAmbas(2082);
		matriz[0][13].setDistanciaEntreAmbas(979); matriz[13][0].setDistanciaEntreAmbas(979);
		matriz[0][14].setDistanciaEntreAmbas(1080); matriz[14][0].setDistanciaEntreAmbas(1080);
		matriz[0][15].setDistanciaEntreAmbas(1334); matriz[15][0].setDistanciaEntreAmbas(1334);
		matriz[0][16].setDistanciaEntreAmbas(1282); matriz[16][0].setDistanciaEntreAmbas(1282);
		matriz[0][17].setDistanciaEntreAmbas(1005); matriz[17][0].setDistanciaEntreAmbas(1005);
		matriz[0][18].setDistanciaEntreAmbas(749); matriz[18][0].setDistanciaEntreAmbas(749);
		matriz[0][19].setDistanciaEntreAmbas(393); matriz[19][0].setDistanciaEntreAmbas(393);
		matriz[0][20].setDistanciaEntreAmbas(579); matriz[20][0].setDistanciaEntreAmbas(579);
		matriz[0][21].setDistanciaEntreAmbas(939); matriz[21][0].setDistanciaEntreAmbas(939);
		matriz[0][22].setDistanciaEntreAmbas(2373); matriz[22][0].setDistanciaEntreAmbas(2373);
		matriz[0][23].setDistanciaEntreAmbas(799); matriz[23][0].setDistanciaEntreAmbas(799);
	}

	public static Celda[][] getMatriz(){
		return matriz;
	}
	
	public static String[] getCiudades() {
		return ciudades;
	}
}
