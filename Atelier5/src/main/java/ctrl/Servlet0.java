package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.Client;
import model.Enchaire;
import model.Revendeur;
import model.Revendeurs;

public class Servlet0 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Article> articles = new ArrayList<>();
    private static ArrayList<Revendeur> revendeurs = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<Client>();
    static {
        articles.add(new Article(1, "portrait", 10));
        articles.add(new Article(2, "voiture", 20));
        articles.add(new Article(3, "test", 30));
        articles.get(0).addEnchaire(new Client(1, "saif", "saif"), 40.0);
        revendeurs.add(new Revendeur(0, "saeuf", "saeuf"));
        
    }
    

    public static ArrayList<Client> getClients() {
		return clients;
	}

	public static ArrayList<Article> getArticles() {
        return articles;
    }

    public static ArrayList<Revendeur> getRevendeurs() {
        return revendeurs;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("articles", articles);
        req.setAttribute("revendeurs", revendeurs);
        this.getServletContext().getRequestDispatcher("/WEB-INF/articlesdisponibles.jsp").forward(req, resp);
    }
}
