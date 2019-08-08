
public class Ciudades {
	
	private static int c;
	private static Celda[][] matriz;
	private static String[] ciudades = {
			("Cdad de Buenos Aires"),
			("Cordoba"),
			("Corrientes"),
			("Formosa"),
			("La Plata"),
			("La Rioja"),
			("Mendoza"),
			("Neuquen"),
			("Parana"),
			("Posadas"),
			("Rawson"),
			("Resistencia"),
			("Rio Gallegos"),
			("S.F.d.V.d. Catamarca"),
			("S.M. de Tucuman"),
			("S.S. de Jujuy"),
			("Salta"),
			("San Juan"),
			("San Luis"),
			("Santa Fe"),
			("Santa Rosa"),
			("Sgo. Del Estero"),
			("Ushuaia"),
			("Viedma")};
			
	private static int [] distancias = new int[] {
			0,	646,    792,    933,	53,		986,	985,	989,	375,	834,	1127,	794,	2082,	979,	1080,	1334,	1282,	1005,	749,	393,	579,	939,	2373,	799,
			0,	677,	824,	698,	340,	466,	907,	348,	919,	1321,	669,	2281,	362,	517,	809,	745,	412,	293,	330,	577,	401,	2618,	1047,	
			0,	157,	830,	814,	1131,	1534,	500,	291,	1845,	13,		2819,	691,	633,	742,	719,	1039,	969,	498,	1136,	535,	3131,	1527,
			0,  968,	927,	1269,	1690,	656,	263,	1999,	161,	2974,	793,	703,	750,	741,	1169,	1117,	654,	1293,	629,	3284,	1681,
			0,	1038,	1029,	1005,	427,	857,	1116,	833,	2064,	1030,	1132,	1385,	1333,	1053,	795,	444,	602,	991,	2350,	789,
			0,	427,	1063,	659,	1098,	1548,	802,	2473,	149,	330,	600,	533,	283,	435,	640,	834,	311,	2821,	1311,
			0,	676,	790,	1384,	1201,	1121,	2081,	569,	756,	1023,	957,	152,	235,	775,	586,	713,	2435,	1019,
			0,	1053,	1709,	543,	1529,	1410,	1182,	1370,	1658,	1591,	824,	643,	1049,	422,	1286,	1762,	479,
			0,	658,	1345,	498,	2320,	622,	707,	959,	906,	757,	574,	19,		642,	566,	2635,	1030,
			0,	1951,	305,	2914,	980,	924,	1007,	992,	1306,	1200,	664,	1293,	827,	3207,	1624,
			0,	1843,	975,	1647,	1827,	2120,	2054,	1340,	1113,	1349,	745,	1721,	1300,	327,
			0,	2818,	678,	620,	729,	706,	1029,	961,	495,	1132,	523,	3130,	1526,
			0,	2587,	2773,	3063,	2997,	2231,	2046,	2325,	1712,	2677,	359,	1294,
			0,	189,	477,	410,	430,	540,	602,	915,	166,	2931,	1391,
			0,	293,	228,	612,	727,	689,	1088,	141,	3116,	1562,
			0,	67,		874,	1017,	942,	1382,	414,	3408,	1855,
			0,	808,	950,	889,	1316,	353,	3341,	1790,
			0,	284,	740,	686,	583,	2585,	1141,
			0,	560,	412,	643,	2392,	882,
			0,	641,	547,	2641,	1035,
			0,	977,	2044,	477,
			0,	3016,	1446,
			0,	1605,
			0
			

			};
	
	public static void main(String args[]) {


		
		/*//Distancias diagonales (=0)
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
		
		//Todas las distancias Cordoba
		matriz[1][2].setDistanciaEntreAmbas(677); matriz[1][0].setDistanciaEntreAmbas(646);
		matriz[1][3].setDistanciaEntreAmbas(824); matriz[2][0].setDistanciaEntreAmbas(792);
		matriz[1][4].setDistanciaEntreAmbas(698); matriz[4][0].setDistanciaEntreAmbas(53);
		matriz[1][5].setDistanciaEntreAmbas(340); matriz[5][0].setDistanciaEntreAmbas(986);
		matriz[1][6].setDistanciaEntreAmbas(466); matriz[6][0].setDistanciaEntreAmbas(985);
		matriz[1][7].setDistanciaEntreAmbas(9); matriz[7][0].setDistanciaEntreAmbas(989);
		matriz[1][8].setDistanciaEntreAmbas(375); matriz[8][0].setDistanciaEntreAmbas(375);
		matriz[1][9].setDistanciaEntreAmbas(834); matriz[9][0].setDistanciaEntreAmbas(834);
		matriz[1][10].setDistanciaEntreAmbas(1127); matriz[10][0].setDistanciaEntreAmbas(1127);
		matriz[1][11].setDistanciaEntreAmbas(794); matriz[11][0].setDistanciaEntreAmbas(794);
		matriz[1][12].setDistanciaEntreAmbas(2082); matriz[12][0].setDistanciaEntreAmbas(2082);
		matriz[1][13].setDistanciaEntreAmbas(979); matriz[13][0].setDistanciaEntreAmbas(979);
		matriz[1][14].setDistanciaEntreAmbas(1080); matriz[14][0].setDistanciaEntreAmbas(1080);
		matriz[1][15].setDistanciaEntreAmbas(1334); matriz[15][0].setDistanciaEntreAmbas(1334);
		matriz[1][16].setDistanciaEntreAmbas(1282); matriz[16][0].setDistanciaEntreAmbas(1282);
		matriz[1][17].setDistanciaEntreAmbas(1005); matriz[17][0].setDistanciaEntreAmbas(1005);
		matriz[1][18].setDistanciaEntreAmbas(749); matriz[18][0].setDistanciaEntreAmbas(749);
		matriz[1][19].setDistanciaEntreAmbas(393); matriz[19][0].setDistanciaEntreAmbas(393);
		matriz[1][20].setDistanciaEntreAmbas(579); matriz[20][0].setDistanciaEntreAmbas(579);
		matriz[1][21].setDistanciaEntreAmbas(939); matriz[21][0].setDistanciaEntreAmbas(939);
		matriz[1][22].setDistanciaEntreAmbas(2373); matriz[22][0].setDistanciaEntreAmbas(2373);
		matriz[1][23].setDistanciaEntreAmbas(2373); matriz[22][0].setDistanciaEntreAmbas(2373);
		
	
		
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
		matriz[0][23].setDistanciaEntreAmbas(799); matriz[23][0].setDistanciaEntreAmbas(799);*/
	}

	public static void crearMatriz() {
	 matriz = new Celda[24][24];
	 
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 24; j++) {
				
				matriz[i][j] = new Celda(ciudades[i], ciudades[j]);
			}
		}
		
		int k=0;
		int l=0;
		for( int i = 0; i<ciudades.length; i++) {
			for (int j = k; j<ciudades.length; j++) {
				int dist = distancias [l];
				matriz[i][j].setDistanciaEntreAmbas(dist);		
				matriz[j][i].setDistanciaEntreAmbas(dist);
				l++;
				
				//c++;
			}
			k++;
		}
	}
	
	public static Celda[][] getMatriz(){
		return matriz;
	}
	
	
	public static String[] getCiudades() {
		return ciudades;
	}
}