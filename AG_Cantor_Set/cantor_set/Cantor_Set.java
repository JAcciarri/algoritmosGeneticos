package cantor_set;


public class Cantor_Set {
	// LONGITUD LIMITADA A 3 ELEVADO A LA N (3, 9, 27, 81, 243, 729...)   
	
	 	static final int LONGITUD = 81;
	    static final int NIVELES = 5;
	    static char[][] lines;
	    static int recursividad = 0;
	    static {
	        lines = new char[NIVELES][LONGITUD];
	        for (int i = 0; i < NIVELES; i++) {
	            for (int j = 0; j < LONGITUD; j++) {
	                lines[i][j] = '_';
	            }
	        }
	    }	
	   
	    
	    public static void main(String[] args) throws InterruptedException {
	    	
	    	cantor(0, LONGITUD, 1);
	    	
	    	System.out.println("\nGrafica Cantor Set finalizada");
	    	System.out.println("Nro de recursividades: " + recursividad);
	 
	    }
	    
	    
	    static void cantor(int start, int longitud, int index) throws InterruptedException {
	        recursividad++;
	    	 int segmento = longitud / 3;
	        if (segmento == 0) return;
	       
	        for (int i = index; i < NIVELES; i++) {
	            for (int j = start + segmento; j < start + segmento * 2; j++) {
	                lines[i][j] = ' ';
	            }
	        }
	        
	        imprimir();
	      
	        cantor(start, segmento, index + 1);
	        cantor(start + segmento * 2, segmento, index + 1);
	    }
	     
	    
	    static void imprimir() throws InterruptedException {
	    	for (int i = 0; i < NIVELES; i++) {
	            for (int j = 0; j < LONGITUD; j++) {
	                System.out.print(lines[i][j]);
	            }
	            System.out.println();
	    	}
	    	Thread.sleep(300);
	    	System.out.println();
	    	System.out.println();
	    }
	    
}