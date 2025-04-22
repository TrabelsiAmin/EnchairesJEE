package model;

import java.io.Serializable;

public class Enchaire implements Serializable {
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 5755218401511085900L;
	private Client client;
	private double valeur;
	public Enchaire() {
		
	}
	public Enchaire(Client client, double valeur) {
		this.client = client;
		this.valeur = valeur;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valeur);
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
		Enchaire other = (Enchaire) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (Double.doubleToLongBits(valeur) != Double.doubleToLongBits(other.valeur))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Enchaire [client=" + client + ", valeur=" + valeur + "]";
	}	
}
