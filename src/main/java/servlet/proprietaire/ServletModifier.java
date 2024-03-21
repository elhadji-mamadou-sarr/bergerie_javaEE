package servlet.proprietaire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Proprietaire;
import jdbc.proprietaire.ModifierProprietaireJdbc;

/**
 * Servlet implementation class ServletModifier
 */
@WebServlet("/ServletModifier")
public class ServletModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ModifierProprietaireJdbc proprietaireJdbc = new ModifierProprietaireJdbc();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletModifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_prop = Integer.valueOf(request.getParameter("id_prop"));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("proprietaire", proprietaireJdbc.prop_a_modifier(id_prop));
		this.getServletContext().getRequestDispatcher("/WEB-INF/proprietaire/ajouter.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_prop = Integer.valueOf(request.getParameter("id_prop"));
		
		Proprietaire proprietaire = proprietaireJdbc.prop_a_modifier(id_prop);
		String nomComplet = request.getParameter("nomComplet");
		String param_telephone = request.getParameter("telephone");
		String daral = request.getParameter("daral");
		Long telephonne = Long.valueOf(param_telephone);
		
		proprietaire.setDaral(daral);
		proprietaire.setNomComplet(nomComplet);
		proprietaire.setTelephone(telephonne);
		
		proprietaireJdbc.update(proprietaire);
		
		response.sendRedirect("ServletLister");
	}

}
