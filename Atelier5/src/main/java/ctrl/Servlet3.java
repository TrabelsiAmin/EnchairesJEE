package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.Client;
import model.Revendeur;

public class Servlet3 extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setAttribute("articles", Servlet0.getArticles());
	        req.setAttribute("revendeurs", Servlet0.getRevendeurs());
	        req.setAttribute("clients", Servlet0.getClients());
	        this.getServletContext().getRequestDispatcher("/WEB-INF/voirencheres.jsp").forward(req, resp);
	    }
		
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        ArrayList<Article> articles = Servlet0.getArticles();
	        ArrayList<Revendeur> revendeurs = Servlet0.getRevendeurs();
	        ArrayList<Client> clients = Servlet0.getClients();


}
}
