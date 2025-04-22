package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Revendeur extends Personne implements Serializable {
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -9133950672139563815L;
	private long idRevendeur;
	private ArrayList<Article> articles;
	public ArrayList<Article> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	
	public long getIdRevendeur() {
		return idRevendeur;
	}
	public void setIdRevendeur(long idRevendeur) {
		this.idRevendeur = idRevendeur;
	}
	public Revendeur(long idRevendeur, String nom, String prenom) {
		super(nom, prenom);
		this.idRevendeur = idRevendeur;
		this.articles = new ArrayList<Article>();
	}
	public Revendeur() {
		super();
		idRevendeur = 0;
		articles = new ArrayList<Article>();
	}
	@Override
	public String toString() {
		return "Revendeur [idRevendeur=" + idRevendeur + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", articles=" + articles + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((articles == null) ? 0 : articles.hashCode());
		result = prime * result + (int) (idRevendeur ^ (idRevendeur >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revendeur other = (Revendeur) obj;
		if (articles == null) {
			if (other.articles != null)
				return false;
		} else if (!articles.equals(other.articles))
			return false;
		if (idRevendeur != other.idRevendeur)
			return false;
		return true;
	}
}
