package cantor_set;

public class Cantor_Set {
	   
	private static final int LONGITUD = 243;
	    private static final int NIVELES = 7;
	    private static char[][] lines;
	    static {
	        lines = new char[NIVELES][LONGITUD];
	        for (int i = 0; i < NIVELES; i++) {
	            for (int j = 0; j < LONGITUD; j++) {
	                lines[i][j] = '_';
	            }
	        }
	    }	
	 
	    public Cantor_Set() {
	    	cantor(0, LONGITUD, 1);
	    }
	   
	    private static void cantor(int start, int longitud, int index) {
	        int segmento = longitud / 3;
	        if (segmento == 0) return;
	        for (int i = index; i < NIVELES; i++) {
	            for (int j = start + segmento; j < start + segmento * 2; j++) {
	                lines[i][j] = ' ';
	            }
	        }
	        cantor(start, segmento, index + 1);
	        cantor(start + segmento * 2, segmento, index + 1);
	    }
	 
	    public static void main(String[] args) throws InterruptedException {
	    	//funcion recursiva
	    	cantor(0, LONGITUD, 1);
	    	//imprimir
	        for (int i = 0; i < NIVELES; i++) {
	            for (int j = 0; j < LONGITUD; j++) {
	                System.out.print(lines[i][j]);
	            }
	            Thread.sleep(1000);
	            System.out.println();
	            System.out.println();
	        }
	    }
	   
}