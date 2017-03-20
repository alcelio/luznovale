package br.com.luznovale.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.luznovale.data.VisitaDao;
import br.com.luznovale.model.Visita;

/**
 * Servlet implementation class IncluiContato
 */
@WebServlet(name="/incluiVisita")
public class IncluiContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluiContato() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson g = new Gson();
		String dadosVisita =  (String) request.getAttribute("GsonVisita");
		
		Visita v = new Visita();
		v = g.fromJson(dadosVisita, Visita.class);
		
		VisitaDao dao = new VisitaDao();
		try {
			dao.create(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
