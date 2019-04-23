package AG;

import java.text.DecimalFormat;

public class TP1 {

	public static void main(String[] args) {
		
		int pobInicial = 10;
		int genes = 30;
		int cantGeneraciones = 20;
		double probCrossover=0.75;
	    double probMutacion=0.05;
	    
		int coef = -1+(int)(Math.pow(2, 30));
		
		int[][]poblacion = new int[pobInicial][genes];
		int[][]poblacionAuxiliar = new int[pobInicial][genes];
		int[]decimales =new int[pobInicial];
		double[]funcionEvaluada = new double[pobInicial];
		double sumaTotal = 0;
		double[] fitness = new double[pobInicial];
		int[] pool = new int[100];
		double []maximos= new double [cantGeneraciones];
		double []minimos= new double [cantGeneraciones];
		double []promedios= new double [cantGeneraciones];
		DecimalFormat formato = new DecimalFormat("0.00000000000");
		double maximo;
		double minimo;
		double promedio;
		int cMax;
		int cMin;
				
		////////////////////////////GENERAR POBLACION INICIAL/////////////////////////
		
		for (int i=0; i<pobInicial; i++) {
			for (int j=0; j<genes; j++) {
				poblacion[i][j]=(int)(Math.random()*2);
				
				}
			}

		///////////////////////////// DEFINIR LA CANTIDAD //////////////////////////////////
		/////////////////////////////// DE GENERACIONES ////////////////////////////////////
		
		int generacion=0;
		while ((generacion<cantGeneraciones)){
				generacion++;

		////////////////////////////PASAR A NUMERO DECIMAL///////////////////////////////
		
		for (int k=0; k<pobInicial; k++) {
			int suma=0;
			for (int j=0; j<genes; j++) {
				if (poblacion[k][j]==1) {
					suma = suma+(int) Math.pow(2, ((genes-1)-j));
						}
					}
				decimales[k]=suma;
			}
		//////////////////// EVALUAR FUNCION Y DEFINIR MAXIMO, MINIMO //////////////////////
		maximo=0;
		minimo=coef;
		cMax=0;
		cMin=0;
		for (int i=0; i<pobInicial; i++) {
			funcionEvaluada[i] = Math.pow((double)decimales[i]/coef, 2);
			if (funcionEvaluada[i]>maximo) { 				
				maximo=funcionEvaluada[i];
				cMax = i;}
			if (funcionEvaluada[i]<minimo) {
				minimo=funcionEvaluada[i];
				cMin = i;}
		}
		maximos[generacion-1]=maximo; //tengo q poner -1 porque apenas entra al while incrementa la poblacion
		minimos[generacion-1]=minimo;
		////////////////////// HACER SUMA TOTAL Y CALCULAR PROMEDIO /////////////////////// 
		
		sumaTotal=0;
		for (int i=0;i<pobInicial;i++) 
			sumaTotal=sumaTotal+(funcionEvaluada[i]);
		
		promedio = (double)(sumaTotal/pobInicial);
		promedios[generacion-1]= promedio;
		
		/////////////////////////// FITNESS DE CADA UNO /////////////////////////	
		
		for (int i=0; i<pobInicial; i++) { 
		fitness[i] = ((double)(funcionEvaluada[i])/sumaTotal); 
		}
		
		////////////////////////////// MOSTRAR //////////////////////////////
		
		System.out.println("\n\nGeneracion numero "+generacion);
		/* for (int i=0; i<pobInicial; i++) {
			//System.out.print("Cromosoma "+(i+1) +"\n");			//DEJADO PARA COMPROBAR QUE EL CROMOSOMA CORRESPONDE AL DECIMAL DEL VALOR MAXIMO
			System.out.println(decimales[i]
				  		+ " - Func Obj: "+formato.format(funcionEvaluada[i])+
				  		" - Fitness: "+formato.format(fitness[i]));		  
		} */
				
		System.out.println("Maximo de la generacion: "+formato.format(maximo));
		System.out.println("Minimo de la generacion: "+formato.format(minimo));
		System.out.println("Promedio de la generacion: "+formato.format(promedio));
		System.out.println("Cromosoma correspondiente al valor maximo: ");
		for (int j=0; j<genes; j++) System.out.print(poblacion[cMax][j]);
		System.out.println("\nCromosoma correspondiente al valor minimo: ");
		for (int j=0; j<genes; j++) System.out.print(poblacion[cMin][j]);
		
		
		
		
		////////////////////////////// HACER POOL SEGUN FITNESS //////////////////////////////
		
		int actualPos=0;
		for (int i=0; i<pobInicial; i++) {
			
				for (int posibilidades=0; posibilidades<(int)(Math.round(fitness[i]*100)); posibilidades++) {
					if (actualPos==100) break; 
					else {
						pool[actualPos]=i;
						actualPos++;
						}
				}
		}
		////////////////////////////// VISUALIZAR POOL DE POSIBILIDADES ////////////////////////

		//for (int i=0; i<100; i++) System.out.println("Crom "+(pool[i]+1));
			
		////////////////////////////// ELEGIR PADRES CON RANDOM ////////////////////////////////
		
		int padres[] = new int[pobInicial];
		for (int i=0; i<pobInicial; i++) {
			padres[i] = pool[(int)(Math.random()*100)];
		}
		
		//////////////////////////////// HACER CROSSOVER //////////////////////////////
		
		for (int parejas=0; parejas<pobInicial; parejas+=2) {
			
		int hacerCrossover = (int)(Math.random()*101); //¿HACER O NO EL CROSSOVER?//
		
		if (hacerCrossover<=(int)(probCrossover*100)) {  //SI DICE QUE SI HAY QUE HACER EL CROSSOVER 
			    int nCorte = 1 + (int)(Math.random()*(genes-1)); //AGREGAMOS EL 1+ PARA QUE EL CROSSOVER SE REALICE DESPUES DEL GEN N°1
					
				for(int j=0; j<nCorte; j++) {
						poblacionAuxiliar[parejas][j] = poblacion[padres[parejas]][j];  //DESCENDIENTE A//
						} 
				for (int k=(nCorte); k<genes; k++) {
						poblacionAuxiliar[parejas][k] = poblacion[padres[parejas+1]][k];  //DESCENDIENTE A//
						}
				
				
				for(int j=0; j<nCorte; j++) {
						poblacionAuxiliar[parejas+1][j] = poblacion[padres[parejas+1]][j];  //DESCENDIENTE B//
						}
				for (int k=(nCorte); k<genes; k++) {
						poblacionAuxiliar[parejas+1][k] = poblacion[padres[parejas]][k];  //DESCENDIENTE B//
						}
			}
		

		
		// SI NO SE HIZO EL CROSSOVER PASO LOS PADRES COMO ESTABAN //
		else 
			for(int j=0; j<genes; j++) {
				poblacionAuxiliar[parejas][j] = poblacion[padres[parejas]][j];  //DESCENDIENTE A//
				} 
			for(int j=0; j<genes; j++) {
				poblacionAuxiliar[parejas+1][j] = poblacion[padres[parejas+1]][j];  //DESCENDIENTE B//
				}
	
		}   //TERMINO EL CROSSOVER
		
		
		
		//////////////////////////////// MUTACION   //////////////////////////////
		
		for (int i=0; i<pobInicial; i++) {
			
			int hacerMutacion = (int)(Math.random()*101);
			
			if (hacerMutacion<=(int)(probMutacion*100)) {
				int posRandom=(int)(Math.random()*(genes-1));

				if (poblacionAuxiliar[i][posRandom]==0) //INVERTIR BIT HIJO i//
					poblacionAuxiliar[i][posRandom]=1;
				else	poblacionAuxiliar[i][posRandom]=0; 
				}
		}
		
//////////////////////////////// TRASPASO AHORA SI LA NUEVA POBLACION  //////////////////////////////
		for (int i=0; i<pobInicial; i++) {
			for (int j=0; j<genes; j++) {
				poblacion[i][j] = poblacionAuxiliar[i][j];
			}
		}
		
		
		}  //LLAVE DE CIERRE DE LAS GENERACIONES//
		
		System.out.println("\n\nTabla Maximos:");
		for(int i=0; i<cantGeneraciones; i++)
			System.out.println(maximos[i]);
		System.out.println("\nTabla Minimos:");
		for(int i=0; i<cantGeneraciones; i++)
			System.out.println(minimos[i]);
		System.out.println("\nTabla Promedios:");
		for(int i=0; i<cantGeneraciones; i++)
			System.out.println(promedios[i]);
	}
	
}
