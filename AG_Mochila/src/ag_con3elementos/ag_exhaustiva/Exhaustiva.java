package ag_exhaustiva;


public class Exhaustiva {
	 
	static Elemento[] elementos = inicializar10Elementos();
	static Elemento[] elementos3 = inicializar3Elementos();
	
    public static void main(String[] args) {
       
         //Mochila mochilaBase = new Mochila(4200, elementos.length);
         //Mochila mochilaOptima = new Mochila(4200, elementos.length);
         Mochila mochilaBase = new Mochila(3000, elementos3.length);
         Mochila mochilaOptima = new Mochila(3000, elementos3.length);
         
        llenarMochila(mochilaBase, elementos3, false, mochilaOptima); // funcion recursiva
        
        mostrarResultados(mochilaOptima);
        
    }
    
   
    public static Elemento[] inicializar3Elementos() {
    	
    	Elemento[] elems = {
    			 new Elemento(1800, 72),
    			 new Elemento(1200, 60),
    			 new Elemento(600, 36),
    			};
    	return elems;
    }
    
public static Elemento[] inicializar10Elementos() {
    	
    	Elemento[] elems = {
    			new Elemento(150, 20),
    		    new Elemento(325, 40),
    		    new Elemento(600, 50),
    		    new Elemento(805, 36),
    		    new Elemento(430, 25),
    		    new Elemento(1200, 64),
    		    new Elemento(770, 54),
    		    new Elemento(60, 18),
    		    new Elemento(930, 46),
    		    new Elemento(353, 28), 
    		    };
    	return elems;
    }
    
    //funcion recursiva
    public static void llenarMochila(Mochila m_base, Elemento[] elementos, boolean llena, Mochila m_opt) {

      
        if (llena) {
            //si esta llena verifico si tiene mas beneficio que la optima
            if (m_base.getBeneficio() >= m_opt.getBeneficio()) {
            	 //si tiene mas beneficio debo vaciar la optima y traspasarla	
                Elemento[] elementosMochBase = m_base.getElementos();
                m_opt.vaciarMochila();
                //metemos los elementos
                for (Elemento e : elementosMochBase) {
                    if (e != null) {
                        m_opt.agregarElemento(e);
                    }
                }

            }

        } else {
            //Y si no esta llena entonces recorre los indices de los elementos
            for (int i = 0; i < elementos.length; i++) {
                
                if (m_base.existeElemento(elementos[i]) == false ) //si no existe este elemento entonces...
                {
                    //Si ademas el peso de la mochila se supera, indicamos que esta llena
                    if (m_base.getCapacidadMaxima() >= m_base.getCapacidadOcupada() + elementos[i].getVolumen()) {
                       //pero si tengo lugar lo agrego
                    	m_base.agregarElemento(elementos[i]); //agregamos el elemento
                        llenarMochila(m_base, elementos, false, m_opt); //llamamos a la recursividad
                        m_base.eliminarElemento(elementos[i]); // luego lo eliminamos
                    } 
                    
                    else { //esto sucede si es que se supera el peso
                        llenarMochila(m_base, elementos, true, m_opt);
                    }

                }

            }

        }

    }
    
    
    public static void mostrarResultados(Mochila mochilaOptima) {
    	System.out.println("   Desarrollado por BUSQUEDA EXHAUSTIVA\n");
    System.out.println("Mochila optima: ");
    Elemento[] elementosMochila = mochilaOptima.getElementos();
    for (int i=0; i<elementosMochila.length; i++) {
    	if (elementosMochila[i]!= null) {
    			    System.out.println("  -Elemento con volumen: "+
    				elementosMochila[i].getVolumen()+
    				" - Beneficio: "+elementosMochila[i].getBeneficio());
    	}
    }
    System.out.println("Capacidad total ocupada: "+ mochilaOptima.getCapacidadOcupada());
    System.out.println("Capacidad total desaprovechada: " + (mochilaOptima.getCapacidadMaxima()-mochilaOptima.getCapacidadOcupada()));
    System.out.println("Beneficio total: "+ mochilaOptima.getBeneficio());
    }
}
