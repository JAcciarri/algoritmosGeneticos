package ag_heuristica;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Heuristica {

	public static void main (String[] args){
		
		DecimalFormat formato = new DecimalFormat("0.00000");
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		Mochila mochila = new Mochila();
		mochila.setCapacidad(4200);
		
		elementos.add(new Elemento(1, 150, 20));
		elementos.add(new Elemento(2, 325, 40));
		elementos.add(new Elemento(3, 600, 50));
		elementos.add(new Elemento(4, 805, 36));
		elementos.add(new Elemento(5, 430, 25));
		elementos.add(new Elemento(6, 1200, 64));
		elementos.add(new Elemento(7, 770, 54));
		elementos.add(new Elemento(8, 60, 18));
		elementos.add(new Elemento(9, 930, 46));
		elementos.add(new Elemento(10, 353, 28));
			
		for (Elemento e : elementos) {
				e.setFitness((double)e.getValor()/e.getVolumen());
			}
	

		elementos.sort( (o1, o2) -> o1.compareTo(o2));
		
		System.out.println("Elementos ordenados por fitness\n");
		for(Elemento e : elementos) {
		 System.out.println("ID: " + e.getIdElemento() +
		 					" Volumen: " + e.getVolumen() +
		 					" Precio: " + e.getValor() +
		 					" Fitness: " + formato.format(e.getFitness()));
		}
		
		
		for (int i=0 ; i<elementos.size() ; i++) {
				
			if	( (elementos.get(i).getVolumen() + mochila.getVolumenOcupado() ) <= mochila.getCapacidad())
			{
				mochila.elementosMochila.add(elementos.get(i));
			}
		}
			
		System.out.println("\nMochila cargada con volumen ocupado: " + mochila.getVolumenOcupado());
		System.out.println("Llenado con los elementos:");
		for(Elemento e : mochila.elementosMochila) {
			 System.out.println("ID: " + e.getIdElemento() +
		 					" Volumen: " + e.getVolumen() +
		 					" Precio: " + e.getValor());
			}
	
	}
	
}
