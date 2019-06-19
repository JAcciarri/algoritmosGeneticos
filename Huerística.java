import java.util.Arrays;
import java.util.Comparator;

public class Huerística {
	
	static int volumenMochila = 4200;
	static int cant = 10;
	static int[][] objetosMochila = new int [cant][2];
	static double [][] greedy = new double [cant][2];
	static int [][] mochila = new int [cant][2];
	 
	public static void main(String[] args) {
		// inicializamos array de objetos
		objetosMochila[0][0] = 150;
		objetosMochila[0][1] = 20;
		objetosMochila[1][0] = 325;
		objetosMochila[1][1] = 40;
		objetosMochila[2][0] = 600;
		objetosMochila[2][1] = 50;
		objetosMochila[3][0] = 805;
		objetosMochila[3][1] = 36;
		objetosMochila[4][0] = 430;
		objetosMochila[4][1] = 25;
		objetosMochila[5][0] = 1200;
		objetosMochila[5][1] = 64;
		objetosMochila[6][0] = 770;
		objetosMochila[6][1] = 54;
		objetosMochila[7][0] = 60;
		objetosMochila[7][1] = 18;
		objetosMochila[8][0] = 930;
		objetosMochila[8][1] = 46;
		objetosMochila[9][0] = 353;
		objetosMochila[9][1] = 28; 
		System.out.println("Lista de objetos");		
		for (int[] d : objetosMochila)
	        System.out.println(Arrays.toString(d));
		
		
		//dividimos $/V y llenamos array greedy
		
		
		for (int i = 0; i<cant; i++ ) {
			
			
			greedy [i][0] = (int)(i+1);
			greedy [i][1] = (double)objetosMochila[i][1]/ (double)objetosMochila[i][0];
			
		}
		
		System.out.println("Lista de arreglo greedy");		
		for (double[] d : greedy)
	        System.out.println(Arrays.toString(d));
		
		// sort array greedy
		 Arrays.sort(greedy, new Comparator<double[]>() {
		        @Override
		        public int compare(double[] o1, double[] o2) {
		            return Double.compare(o2[1], o1[1]);
		        }
		    });

		 System.out.println("Lista de arreglo greedy ordenado");
		    for (double[] d : greedy)
		        System.out.println(Arrays.toString(d));
		
	// cargamos mochila
		    int sum = 0;
		    int k = 0;
		    int j = 0;
		    int bandera = 0;
		    while (j<cant) {
		    	
		    	//debo buscar con el indice del greedy[j][0] el volumen de ese objeto j en el arreglo de objetosMochila
		    	
		    	int indice  = ((int) greedy[j][0]);		    	    	
		    	sum = sum + objetosMochila[indice-1][0]; //sumo al acumulador el volumen de ese objeto
		    	if (sum<=volumenMochila) {
		    	mochila [j][0] = indice; 
		    	mochila[j][1] = objetosMochila[indice-1][0]; // le tengo que restar 1 a indice porque cuando guarde el numero del objeto en el greedy que era un indice le sum[e unno para que sea correlativo con la tabla
		    	
		    	}else {
		    		//bandera=1; 
		    		sum = sum - objetosMochila[indice-1][0];
		    		//k = indice;
		    		}  
		    	j++;
		    }
		    //System.out.println(k);
		    
		   /* if (k!=9) {
		    for (int i = k+1; i<cant;i++) {//k+1 ser[ia el siguiente elemento al ultimo que no pudo agregarse y debo probar con los que siguen en la lista
		    	int indice  = (int) greedy[i][0];		    	    	
		    	sum = sum + objetosMochila[indice][0]; //sumo al acumulador el volumen de ese objeto
		    	if (sum<volumenMochila) {
		    		mochila [j][0] = indice; 
			    	mochila[j][1] = objetosMochila[indice][0];
			    	j++;
		    	}
		    	
		    }
		    }*/
		    
		    System.out.println("Mochila");
		    for (int [] d : mochila)
		        System.out.println(Arrays.toString(d));
		    System.out.println ("suma volumen");
		    System.out.println (sum);
	
	
	
	};
		
 
	
					
	
	
}
