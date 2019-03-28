public class Clase1 {
	
	
	public static void main(String[] args) {
	int [][] matriz =new int [10][30];
	int[] entero = new int [10];
	double suma1;
	
	
//	int[]matrizprueba = {1,0,0,1};
//  int decimal = convertir(matrizprueba);
//	System.out.println(decimal);
	
	for(int i=0;i<10;i++) {
		for(int j=0;j<30;j++) {
			int num = (int)(Math.random()*2);
			matriz[i][j]=num;
		}
		
		for (int k=0; k<10; k++) {
			suma1=0;
			for (int j=0; j<30; j++) {
			if (matriz[k][j]==1) {
				double num = j;
				num = Math.pow(2, (29-j));
				suma1 =suma1 + num;
				}
					
		}
			int suma2 = (int) suma1;
			entero[k]=suma2;
		}
		
			}
		for(int i=0; i<10; i++)
		System.out.println(entero[i]);
	
	}
}

