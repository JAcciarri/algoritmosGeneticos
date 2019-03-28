package AG;
public class Cromosoma {
		
	//Atributos de la clase
		private int idCromosoma;
		private int[] valorBinario=new int[10];
		private int valorDecimal;
		private int valorFuncion;
		private double fitness;
		
	//Constructor
		public Cromosoma(){}
		
	//Metodos de la clase
		
		public void setId(int id){
			idCromosoma = id;
		}
		public void generarBinario() {
				for (int i=0; i<=4; i++) {
					int randomNum=(int)(Math.random()*2);
					valorBinario[i]=randomNum;
				}
		}
		public int[] getBinario() {
			return valorBinario;
		}
		public void hacerCrossover(){
		}
		public void mutar() {
		}
	}