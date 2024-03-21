package servlet.mouton;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mouton;
import jdbc.mouton.ModifierMoutonJdbc;
import jdbc.proprietaire.ListerProprietaire;

/**
 * Servlet implementation class ServletModifierMouton
 */
@WebServlet("/ServletModifierMouton")
public class ServletModifierMouton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ModifierMoutonJdbc jdbc = new ModifierMoutonJdbc();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierMouton() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListerProprietaire proprietaire = new ListerProprietaire();
		int id_mouton = Integer.valueOf(request.getParameter("id_mouton"));
		
		request.setAttribute("mouton", jdbc.mouton_a_modifier(id_mouton));
		request.setAttribute("proprietaires", proprietaire.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/mouton/formulaire.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_mouton = Integer.valueOf(request.getParameter("id_mouton"));
		Mouton mouton = jdbc.mouton_a_modifier(id_mouton);
		
		String nom = request.getParameter("nomMouton");
		String race = request.getParameter("race");
		String couleur = request.getParameter("couleur");
		int id_proprietaire = Integer.valueOf(request.getParameter("id_proprietaire"));
		
		mouton.setNom(nom);
		mouton.setRace(race);
		mouton.setCouleur(couleur);
		mouton.setId_proprietaire(id_proprietaire);
		
		jdbc.update(mouton);
		response.sendRedirect("ListeMouton");
	}

}
