package ag_heuristica;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Heuristica {

	public static void main (String[] args){
		
		DecimalFormat formato = new DecimalFormat("0.00000");

		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		Mochila mochila = new Mochila();
		//mochila.setCapacidad(4200);
		mochila.setCapacidad (3000);
		
		/*elementos.add(new Elemento(1, 150, 20));
		elementos.add(new Elemento(2, 325, 40));
		elementos.add(new Elemento(3, 600, 50));
		elementos.add(new Elemento(4, 805, 36));
		elementos.add(new Elemento(5, 430, 25));
		elementos.add(new Elemento(6, 1200, 64));
		elementos.add(new Elemento(7, 770, 54));
		elementos.add(new Elemento(8, 60, 18));
		elementos.add(new Elemento(9, 930, 46));
		elementos.add(new Elemento(10, 353, 28));
		*/
		
		elementos.add(new Elemento (1, 1800, 72));
		elementos.add(new Elemento (2, 600, 36));
		elementos.add(new Elemento (3, 1200, 60));
		
			
		for (Elemento e : elementos) {
				e.setFitness((double)e.getValor()/e.getVolumen());
			}
	

		elementos.sort( (o1, o2) -> o1.compareTo(o2));
		
		/* System.out.println("Elementos ordenados por fitness\n");
		for(Elemento e : elementos) {
		/* System.out.println("ID: " + e.getIdElemento() +
		 					" Volumen: " + e.getVolumen() +
		 					" Precio: " + e.getValor() +
		 					" Fitness: " + formato.format(e.getFitness()));
		 
		 System.out.println("ID: " + e.getIdElemento() +
	 					" Peso: " + e.getVolumen() +
	 					" Precio: " + e.getValor());
		 
		}*/
		
		
		for (int i=0 ; i<elementos.size() ; i++) {
				
			if	( (elementos.get(i).getVolumen() + mochila.getVolumenOcupado() ) <= mochila.getCapacidad())
			{
				mochila.elementosMochila.add(elementos.get(i));
			}
		}
		
		System.out.println("  Desarrollado por BUSQUEDA HEURISTICA");	
		System.out.println("\nMochila optima encontrada: " + mochila.getVolumenOcupado());
		//System.out.println("\nMochila cargada con peso ocupado: " + mochila.getVolumenOcupado());		
		for(Elemento e : mochila.elementosMochila) {
			 System.out.println("  -ID: " + e.getIdElemento() +
		 					" Volumen: " + e.getVolumen() +
		 					" Precio: " + e.getValor());
			 /*
			 System.out.println("ID: " + e.getIdElemento() +
		 					" Peso: " + e.getVolumen() +
		 					" Precio: " + e.getValor());
			 */
			}
		System.out.println("Capacidad total ocupada: "+ mochila.getVolumenOcupado() );
		System.out.println("Capacidad total desaprovechada: " + (mochila.getCapacidad()-mochila.getVolumenOcupado()));
		System.out.println("Beneficio total: "+ mochila.getBeneficio());
	
	}
	
}