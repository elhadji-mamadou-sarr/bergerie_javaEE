package servlet.proprietaire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Proprietaire;
import jdbc.proprietaire.AjoutProprietaireJdbc;

/**
 * Servlet implementation class ServletAjouter
 */
@WebServlet("/ServletAjouter")
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/proprietaire/ajouter.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AjoutProprietaireJdbc proprietaireJdbc = new AjoutProprietaireJdbc();
		Proprietaire proprietaire = new Proprietaire(request);
		
		proprietaireJdbc.inserer(proprietaire);
		
		response.sendRedirect("ServletLister");
		
	}

}
