package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ag_web.*;

/**
 * Servlet implementation class CiudadServlet
 */
@WebServlet("/CiudadServlet")
public class CiudadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CiudadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Celda mejorC = Ciudades.getMejorRecorrido();
		request.setAttribute("mejorCiudad", mejorC);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int distanciaTotal=0;
		String[] ciudades = Ciudades.getCiudades();
		String[] recorrido = new String[ciudades.length];
		int r=1;
		String cElegida = request.getParameter("destino");
		Ciudades.crearMatriz();
		Ciudades.encontrarCiudadInicial(cElegida);
		recorrido[0]=cElegida;
		String nextCiudad = cElegida;
		
		for (int i = 0; i<ciudades.length-1; i++) {
			Celda cell = Ciudades.encontrarProximaCiudad(nextCiudad);
			nextCiudad = (cell.getCiudadHasta());
			recorrido[r] = nextCiudad;  r++;
			distanciaTotal += cell.getDistanciaEntreAmbas();
		}
		distanciaTotal = distanciaTotal + Ciudades.volverAlInicio(cElegida, recorrido[ciudades.length-1]);
		
		request.setAttribute("cElegida", cElegida);
		request.setAttribute("recorrido", recorrido);
		request.setAttribute("dTotal", distanciaTotal);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
