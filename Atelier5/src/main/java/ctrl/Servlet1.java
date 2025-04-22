package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.Revendeur;

public class Servlet1 extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterarticle.jsp").forward(req, resp);
    }
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Article> articles = Servlet0.getArticles();
        ArrayList<Revendeur> revendeurs = Servlet0.getRevendeurs();

        String id = req.getParameter("revId");
        String nom = req.getParameter("revNom");
        String prenom = req.getParameter("revPrenom");
        String number = req.getParameter("articleId");
        String libelle = req.getParameter("libelle");
        String prixMinimal = req.getParameter("prixMinimal");
        try {
        Article newArt = new Article(Integer.parseInt(number), libelle, Integer.parseInt(prixMinimal));
        articles.add(newArt);
        int revId = Integer.parseInt(id);
        boolean exists = false;
        for (Revendeur rev : revendeurs) {
            if (rev.getIdRevendeur() == revId) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            Revendeur newRev = new Revendeur(revId, nom, prenom);
            revendeurs.add(newRev);
            newRev.getArticles().add(newArt);
        }
        for (Revendeur rev : revendeurs) {
        	System.out.println(rev.getIdRevendeur());
        }
        }catch(IllegalArgumentException e) {
        	req.setAttribute("error", e.getMessage());
        }
        

        
        

        req.setAttribute("articles", articles);
        req.setAttribute("revendeurs", revendeurs);
        req.getRequestDispatcher("/WEB-INF/ajouterarticle.jsp").forward(req, resp);

    }
}
