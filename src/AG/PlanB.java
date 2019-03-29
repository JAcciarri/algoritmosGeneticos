package AG;

import java.text.DecimalFormat;

public class PlanB {

	public static void main(String[] args) {
		int pobInicial=4;
		int genes=5;
		int[][]poblacion= new int[pobInicial][genes];
		int[]decimales=new int[pobInicial];
		int sumaTotal=0;
		double[] fitness= new double[pobInicial];
		int[] pool=new int[100];
		DecimalFormat formato = new DecimalFormat("0.00");
		int maximo;
		////////////////////////////GENERAR POBLACION INICIAL/////////////////////////
		
		for (int i=0; i<pobInicial; i++) {
			for (int j=0; j<genes; j++) {
				poblacion[i][j]=(int)(Math.random()*2);
				}
			}
		
		///////////////////////////// DEFINIR LA CANTIDAD //////////////////////////////////
		/////////////////////////////// DE GENERACIONES ////////////////////////////////////
		
		int generacion=0;
		while ((generacion<1000) && (1<4)){
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
		//////////////////////////////HACER SUMA TOTAL////////////////////////////// 
		
		sumaTotal=0;
		for (int i=0;i<pobInicial;i++) sumaTotal=sumaTotal+(decimales[i]*decimales[i]);
		
		
		/////////////////////////// ACTUALIZAR TABLA DE MAXIMOS /////////////////////////	
		maximo=0;
		for (int i=0; i<pobInicial; i++) {
			if(decimales[i]>maximo) maximo=decimales[i];
		}
		
		
		////////////////////////////// MOSTRAR //////////////////////////////
		
		System.out.println("\nGeneracion numero "+generacion);
		for (int i=0; i<pobInicial; i++) {
			System.out.print("Cromosoma "+(i+1) +":\nBin: ");
			//FITNESS DE CADA UNO//
			fitness[i] = ((float)(decimales[i]*decimales[i])/sumaTotal); 
		  
			for (int k=0; k<genes; k++)
			  if (k!=(genes-1)) System.out.print(poblacion[i][k]); 
			  else {
				  //IMPRIMIR//
				  System.out.println(poblacion[i][k]+" ("+decimales[i]+") - Func Obj: "+(decimales[i]*decimales[i])+
						  " - Fitness: "+ formato.format(fitness[i]));
				  
			  }
			
		}
		System.out.println("\n\t\t\t\tMaximo de la generacion: "+maximo+"\n");
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
		
		int random1= (int)(Math.random()*100);
		int random2= (int)(Math.random()*100);
		int random3= (int)(Math.random()*100);
		int random4= (int)(Math.random()*100);
		int padre1 = pool[random1];
		int padre2 = pool[random2];
		int padre3 = pool[random3];
		int padre4 = pool[random4];
		
		/*	System.out.println(random1);
			System.out.println(random2);
			System.out.println("Padre 1:");
			for (int i=0; i<genes; i++)
				System.out.print(poblacion[padre1][i]);
			System.out.println("\nPadre 2:");
			for (int i=0; i<genes; i++)
				System.out.print(poblacion[padre2][i]);
			System.out.println();
		*/
		
		//////////////////////////////// HACER CROSSOVER 1 //////////////////////////////
			
		double probCrossover=0.90;
		double probMutacion=0.01;
		
		
		int hacerCrossover = (int)(Math.random()*101); //¿HACER O NO EL CROSSOVER 1?//
		System.out.println("crossover 1 = "+hacerCrossover);
			//PARA POBLACION VARIABLE // for (int parejas=1; parejas<=(pobInicial/2);parejas++){
				
		if (hacerCrossover<=(int)(probCrossover*100)) {  //SI DICE QUE SI HAY QUE HACER EL CROSSOVER 
			    int nCorte=(int)(Math.random()*((genes-1))+1);
				//int nCorte=(int)(Math.random()*(genes-1));   //PARA LA PRIMER PAREJA
				System.out.println("num corte 1= "+nCorte);
					
				for(int j=0; j<=nCorte; j++) {
						poblacion[padre1][j]=poblacion[padre1][j];  //PADRE 1//
						}
				for (int k=(nCorte+1); k<genes; k++) {
						poblacion[padre1][k]=poblacion[padre2][k];  //PADRE 1//
						}
				
				
				for(int j=0; j<=nCorte; j++) {
						poblacion[padre2][j]=poblacion[padre2][j];  //PADRE 2//
						}
				for (int k=(nCorte+1); k<genes; k++) {
						poblacion[padre2][k]=poblacion[padre1][k];  //PADRE 2//
						}
				}
		//////////////////////////////// HACER MUTACION 1 //////////////////////////////
		
		int hacerMutacion = (int)(Math.random()*1000);
		System.out.println("mutacion 1 = "+hacerMutacion);
		
		if (hacerMutacion<=(int)(probMutacion*100)) {
			int posRandom=(int)(Math.random()*(genes-1));
			if (poblacion[padre1][posRandom]==0) //INVERTIR BIT PADRE 1//
					poblacion[padre1][posRandom]=1;
			   else	poblacion[padre1][posRandom]=0; 	

			if (poblacion[padre2][posRandom]==0) //INVERTIR BIT PADRE 2//
					poblacion[padre2][posRandom]=1;
			   else	poblacion[padre2][posRandom]=0; 	
		}

		////////////////////////////////HACER CROSSOVER 2 //////////////////////////////
		
		int hacerCrossover2 = (int)(Math.random()*101); //¿HACER O NO EL CROSSOVER 2?//
		System.out.println("crossover 2 = "+hacerCrossover2);
		
		if (hacerCrossover2<=(int)(probCrossover*100)) {  //SI DICE QUE SI HAY QUE HACER EL CROSSOVER
			int nCorte=(int)(Math.random()*((genes-1))+1);
			//int nCorte=(int)(Math.random()*(genes-1));	  // PARA LA SEGUNDA PAREJA 
			System.out.println("num corte 2 = "+nCorte);
				
				for(int j=0; j<=nCorte; j++) {
						poblacion[padre3][j]=poblacion[padre3][j];  //PADRE 3//
						}
				for (int k=(nCorte+1); k<genes; k++) {
						poblacion[padre3][k]=poblacion[padre4][k];  //PADRE 3//
						}
				
				
				for(int j=0; j<=nCorte; j++) {
						poblacion[padre4][j]=poblacion[padre4][j];  //PADRE 4//
						}
		for (int k=(nCorte+1); k<genes; k++) {
						poblacion[padre4][k]=poblacion[padre3][k];  //PADRE 4//
						}
			}
		////////////////////////////////// HACER MUTACION 2 //////////////////////////////
		
		int hacerMutacion2 = (int)(Math.random()*1000);
		System.out.println("mutacion 2 = "+hacerMutacion2);

			if (hacerMutacion2<=(int)(probMutacion*100)) {
				int posRandom=(int)(Math.random()*(genes-1));
				if (poblacion[padre2][posRandom]==0) //INVERTIR BIT PADRE 1//
					poblacion[padre2][posRandom]=1;
				else	poblacion[padre2][posRandom]=0; 	

				if (poblacion[padre3][posRandom]==0) //INVERTIR BIT PADRE 2//
					poblacion[padre3][posRandom]=1;
				else	poblacion[padre3][posRandom]=0; 	
			}
			
		
		}  //LLAVE DE CIERRE DE LAS GENERACIONES//
		
	}

	
	
}
