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

public class Servlet2 extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("articles", Servlet0.getArticles());
        req.setAttribute("revendeurs", Servlet0.getRevendeurs());
        req.setAttribute("clients", Servlet0.getClients());
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterenchere.jsp").forward(req, resp);
    }
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Article> articles = Servlet0.getArticles();
        ArrayList<Revendeur> revendeurs = Servlet0.getRevendeurs();
        ArrayList<Client> clients = Servlet0.getClients();

        String id = req.getParameter("revId");
        String nom = req.getParameter("revNom");
        String prenom = req.getParameter("revPrenom");
        String id_art = req.getParameter("articleId");
        String prix = req.getParameter("prix");

        double prixDouble = Double.parseDouble(prix);
        Article art = null;

        for (Article a : articles) {
            if (a.getId() == Integer.parseInt(id_art)) {
                art = a;
                if (a.getPrixMinimal() > prixDouble) {
                    req.setAttribute("msg", "Le prix proposé est inférieur au prix minimal de l'article.");
                    forwardToForm(req, resp, articles, revendeurs, clients);
                    return;
                }
                break;
            }
        }
        if (art != null) {
        	Client client = null;
        	for (Client c : clients) {
        	    if (c.getIdClient() == Integer.parseInt(id)) {
        	        client = c;
        	        break;
        	    }
        	}

        	if (client == null) {
        	    client = new Client(Integer.parseInt(id), nom, prenom);
        	    clients.add(client);
        	}

            art.addEnchaire(client, prixDouble);
            req.setAttribute("msg", "Enchère ajoutée avec succès.");
        }

        forwardToForm(req, resp, articles, revendeurs, clients);
    }

    private void forwardToForm(HttpServletRequest req, HttpServletResponse resp,
                               ArrayList<Article> articles, ArrayList<Revendeur> revendeurs, ArrayList<Client> clients)
            throws ServletException, IOException {
        req.setAttribute("articles", articles);
        req.setAttribute("revendeurs", revendeurs);
        req.setAttribute("clients", clients);
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterenchere.jsp").forward(req, resp);
    }
}