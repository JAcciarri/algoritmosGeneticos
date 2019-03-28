package AG;
import AG.Cromosoma;
import java.util.Collection;
import java.util.ArrayList;

public class Environment {
	
	//Atributos de la clase
		private static double probCrossover;
		private static double probMutacion;
		private static ArrayList<Cromosoma> celula = new ArrayList<Cromosoma>();
		ArrayList<Integer> lista = new ArrayList<Integer>();
	//Constructor
		public Environment(){}
		
	//Metodos de la clase
		public void crearPoblacionInicial(int cantPob) {
			for (int i=1; i<=cantPob; i++) {
				Cromosoma unCromosoma=new Cromosoma();
				unCromosoma.setId(i);
				unCromosoma.generarBinario();
				int[] bin= unCromosoma.getBinario();
				System.out.print("Cromosoma "+i+": ");
				for (int j=0; j<5; j++) 
					System.out.print(bin[j]);
					System.out.print("\n");
			//	celula.add(unCromosoma);

			}
		}
	
	//Main
	public static void main(String[] args) {
		Environment Ambiente = new Environment();
		Ambiente.crearPoblacionInicial(10);
		
		}

}

