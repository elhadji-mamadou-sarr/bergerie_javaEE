package servlet.mouton;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mouton;
import jdbc.mouton.AjoutMoutonJdbc;
import jdbc.proprietaire.ListerProprietaire;

/**
 * Servlet implementation class ServletAjouterMouton
 */
@WebServlet("/ServletAjouterMouton")
public class ServletAjouterMouton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterMouton() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListerProprietaire proprietaire = new ListerProprietaire();
		
		request.setAttribute("proprietaires", proprietaire.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/mouton/formulaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mouton mouton = new Mouton(request);
		AjoutMoutonJdbc ajoutMoutonJdbc = new AjoutMoutonJdbc();
		ajoutMoutonJdbc.inserer(mouton);
		response.sendRedirect("ListeMouton");
	}

}
