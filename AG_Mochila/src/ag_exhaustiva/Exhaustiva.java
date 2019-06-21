package ag_exhaustiva;

public class Exhaustiva {

	public static void main(String[] args) {
		 
		Elemento_2[] elementos = {
            new Elemento_2(150, 20),
            new Elemento_2(325, 40),
            new Elemento_2(600, 50),
            new Elemento_2(805, 36),
            new Elemento_2(430, 25),
            new Elemento_2(1200, 64),
            new Elemento_2(770, 54),
            new Elemento_2(60, 18),
            new Elemento_2(930, 46),
            new Elemento_2(353, 28) };
        
 
        Mochila_2 m_base = new Mochila_2(4200, elementos.length);
        Mochila_2 m_opt = new Mochila_2(4200, elementos.length);
 
        llenarMochila(m_base, elementos, false, m_opt);
 
        System.out.println(m_opt);
    }
		
		
		public static void llenarMochila(Mochila_2 m_base, Elemento_2[] elementos, boolean llena, Mochila_2 m_opt) {
			 
		      //si esta llena
		      if (llena) {
		          //compruebo si tiene mas beneficio que otra
		          if (m_base.getBeneficio() > m_opt.getBeneficio()) {
		 
		              Elemento_2[] elementosMochBase = m_base.getElementos();
		              m_opt.clear();
		 
		              //metemos los elementos
		              for (Elemento_2 e : elementosMochBase) {
		                  if (e != null) {
		                      m_opt.aniadirElemento(e);
		                  }
		 
		              }
		 
		          }
		 
		      } else {
		          //Recorre los elementos
		          for (int i = 0; i < elementos.length; i++) {
		              //si existe el elemento
		              if (!m_base.existeElemento(elementos[i])) {
		                  //Si el peso de la mochila se supera, indicamos que esta llena
		                  if (m_base.getPesoMaximo() > m_base.getPeso() + elementos[i].getPeso()) {
		                      m_base.aniadirElemento(elementos[i]); //añadimos
		                      llenarMochila(m_base, elementos, false, m_opt);
		                      m_base.eliminarElemento(elementos[i]); // lo eliminamos
		                  } else {
		                      llenarMochila(m_base, elementos, true, m_opt);
		                  }
		 
		              }
		 
		          }
		 
		      }
		 
		  }
		
	}

