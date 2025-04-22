package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Article implements Serializable {
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -6522006330814859850L;
	private long id;
	private String libele;
	private double prixMinimal;
	private ArrayList<Enchaire> enchaires;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	public double getPrixMinimal() {
		return prixMinimal;
	}
	public void setPrixMinimal(double prixMinimal) {
		this.prixMinimal = prixMinimal;
	}
	public ArrayList<Enchaire> getEnchaires() {
		return enchaires;
	}
	public void setEnchaires(ArrayList<Enchaire> enchaires) {
		this.enchaires = enchaires;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", libele=" + libele + ", prixMinimal=" + prixMinimal + "]";
	}
	public Article(long id, String libele, double prixMinimal) {
		if (prixMinimal < 10) {
	        throw new IllegalArgumentException("prixMinimal must be at least 10");
	    }
		this.id = id;
		this.libele = libele;
		this.prixMinimal = prixMinimal;
		this.enchaires = new ArrayList<Enchaire>();
	}
	public Article() {
		id = 0;
		libele = "";
		prixMinimal = 10;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enchaires == null) ? 0 : enchaires.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((libele == null) ? 0 : libele.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixMinimal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (enchaires == null) {
			if (other.enchaires != null)
				return false;
		} else if (!enchaires.equals(other.enchaires))
			return false;
		if (id != other.id)
			return false;
		if (libele == null) {
			if (other.libele != null)
				return false;
		} else if (!libele.equals(other.libele))
			return false;
		if (Double.doubleToLongBits(prixMinimal) != Double.doubleToLongBits(other.prixMinimal))
			return false;
		return true;
	
	}
	public void addEnchaire(Client client, Double prix) {
		if (prix <  prixMinimal) {
			System.out.println("prix d'enchaire doit etre plus grand que le prix minimal");}
		else {
			Enchaire e = new Enchaire(client, prix);
			this.enchaires.add(e);
			System.out.println("Enchaire sauvegard");
		}
		
	}
	
}
